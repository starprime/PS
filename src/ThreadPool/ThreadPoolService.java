package ThreadPool;

import java.util.List;

public interface ThreadPoolService {
    /**
     * Return total active threads of the pool.
     *
     * @return
     */
    public int totalActiveThreads();

    /**
     * Return the maximum number of threads that can run at any point of time.
     *
     * @return
     */
    public int maxThreads();
    /**
     *
     * @param task
     * @return false if the task is null, else true
     */
    public boolean submitTask(Task task);
    /**
     *
     * @return true, if the task is removed, else false
     */
    public boolean removeTask(Task task);
    /**
     * Remove all the tasks. Since this is queue implementation, there is a
     * possibility that same task existance.
     *
     * @param task
     * @return
     */
    public boolean removeAllTasks(Task task);
    /**
     * Return all the current running tasks
     *
     * @return
     */
    public List<Task> currentRunningTasks();
    /**
     * Interrupt given task.
     *
     * @param task
     * @return true if the thread is interrupted, false if the task is null (or)
     *         no thread is running given task. use this method in caution.
     */
    public boolean interruptTask(Task task);

    /**
     * Start all the threads.
     *
     */
    public void execute();

    /**
     * It stops all the threads execution, Once the threads are stopped, the
     * instance of ThreadPoolService is of no use.
     *
     * @return
     */
    public boolean stopThreads();

}