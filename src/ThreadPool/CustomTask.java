package ThreadPool;
import java.util.concurrent.atomic.AtomicInteger;

public class CustomTask implements Task {
    private String name;
    private boolean active;
    private int priority = 0;
    private int sequenceNumber = Integer.MAX_VALUE;
    private static final AtomicInteger seq = new AtomicInteger(0);

    public CustomTask(String name) {
        this.name = name;
        this.priority = 0;
        this.sequenceNumber = seq.getAndIncrement();
    }

    public CustomTask(String name, int priority) {
        this.name = name;
        this.priority = priority;
        this.sequenceNumber = seq.getAndIncrement();
    }

    @Override
    public String getTaskName() {
        return name;
    }

    @Override
    public boolean isActive() {
        return active;
    }

    @Override
    public void run() {
        active = true;
        System.out.println("Executing the task " + name + ", priority " + priority);
        active = false;
    }

    @Override
    public int getPriority() {
        return priority;
    }

    @Override
    public int getSequenceNumber() {
        return sequenceNumber;
    }

}
