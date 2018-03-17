package ThreadPool;

/**
 * Created by star on 3/15/18.
 */

public interface Task extends Runnable {

    /**
     * Get the task name
     *
     * @return
     */
    public String getTaskName();

    /**
     *
     * @return true if the task is in active, else false
     */
    public boolean isActive();

    /**
     * @return priority of the task
     */
    public int getPriority();

    /**
     *
     * @return the sequence number of the task. If two tasks has same priority,
     *         then the task with less sequence number executes first.
     */
    public int getSequenceNumber();
}