package ThreadPool;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.BlockingQueue;

public class ThreadPoolServiceImpl implements ThreadPoolService {
    private final List<CustomThread> workerThreads;
    private final BlockingQueue<Task> queue;
    private int activeThreads = 0;
    private final int MAX_THREADS;
    private List<Task> currentRunningTasks = Collections.synchronizedList(new ArrayList<Task>());

    public ThreadPoolServiceImpl(BlockingQueue<Task> queue, int maxThreads) {
        this.queue = queue;
        MAX_THREADS = maxThreads;
        workerThreads = new ArrayList<>(MAX_THREADS);
        initWorkerThreads();
    }

    private void initWorkerThreads() {
        for (int i = 0; i < MAX_THREADS; i++) {
            CustomThread thread = new CustomThread(queue, currentRunningTasks);
            workerThreads.add(thread);
        }
    }

    @Override
    public int totalActiveThreads() {
        return activeThreads;
    }

    @Override
    public int maxThreads() {
        return MAX_THREADS;
    }

    @Override
    public boolean submitTask(Task task) {
        if (task == null) {
            return false;
        }

        return queue.add(task);
    }

    @Override
    public boolean removeTask(Task task) {
        return queue.remove(task);
    }

    @Override
    public boolean removeAllTasks(Task task) {
        boolean status = false;
        while (queue.remove(task)) {
            status = true;
        }

        return status;
    }

    @Override
    public List<Task> currentRunningTasks() {
        return new ArrayList<>(currentRunningTasks);
    }

    @Override
    public boolean interruptTask(Task task) {
        if (task == null) {
            return false;
        }
        Optional<CustomThread> threadOpt = getTheThreadThatExecutingTheTask(task);

        if (!threadOpt.isPresent()) {
            return false;
        }

        CustomThread thread = threadOpt.get();
        thread.interrupt();
        return true;
    }

    /**
     * Return the thread that is running given task, if no thread is running
     * given task, then it returns empty.
     *
     * @param task
     * @return
     */
    private Optional<CustomThread> getTheThreadThatExecutingTheTask(Task task) {
        for (CustomThread thread : workerThreads) {
            Task currentRunningTask = thread.getCurrentRunningTask();
            if (currentRunningTask.equals(task)) {
                return Optional.of(thread);
            }
        }
        return Optional.empty();
    }

    public class CustomThread extends Thread {
        private BlockingQueue<Task> queue;
        private Task currentRunningTask;
        private List<Task> currentRunningTasks;
        private boolean isActive = false;
        private volatile boolean stopThread = false;

        public CustomThread(BlockingQueue<Task> queue, List<Task> currentRunningTasks) {
            this.queue = queue;
            this.currentRunningTasks = currentRunningTasks;
        }

        @Override
        public void run() {
            while (true) {
    /* Get the task from queue & execute */
                try {
                    isActive = true;
                    currentRunningTask = queue.take();
                    currentRunningTasks.add(currentRunningTask);
                    currentRunningTask.run();
                    currentRunningTasks.remove(currentRunningTask);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                } finally {
                    isActive = false;
                }

                if (stopThread) {
                    System.out.println("Stopping the threads");
                    break;
                }
            }
        }

        public Task getCurrentRunningTask() {
            return currentRunningTask;
        }

        public boolean isActive() {
            return isActive;
        }

        public synchronized void setStopThread(boolean stopThread) {
            this.stopThread = stopThread;
        }

    }

    @Override
    public void execute() {
        for (CustomThread thread : workerThreads) {
            System.out.println("Started the thread " + thread.getName());
            thread.start();
        }
    }

    @Override
    public boolean stopThreads() {
        for (CustomThread thread : workerThreads) {
            System.out.println("Stopping threads");
            thread.setStopThread(true);
        }
        return true;
    }

}