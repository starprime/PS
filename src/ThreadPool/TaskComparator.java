package ThreadPool;

/**
 * Created by star on 3/15/18.
 */
import java.util.Comparator;

public class TaskComparator implements Comparator<Task> {

    @Override
    public int compare(Task task1, Task task2) {
        int res = task2.getPriority() - task1.getPriority();

        if (res == 0) {
            return (task1.getSequenceNumber() - task2.getSequenceNumber());
        }

        return res;
    }

}