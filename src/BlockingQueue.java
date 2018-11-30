import java.util.Queue;

/**
 * Created by star on 11/19/18.
 */
public class BlockingQueue {
    private java.util.Queue queue = new java.util.LinkedList<>();

    public synchronized Object dequeue(){
        Object msg = null;
        while (queue.isEmpty()){
            try {
                wait();
            }catch (InterruptedException e){
                return msg;
            }
        }
        msg = queue.remove();
        return msg;
    }

    public synchronized void enqueue(Object o){
        queue.add(o);
        notifyAll();
    }

}
