package Threading;

/**
 * Created by star on 8/31/18.
 */
public class SayHello implements Runnable{
    private volatile boolean running = true;
    public static void main(String [] args) throws InterruptedException{
        Thread th = new Thread(new SayHello());
        th.start();
        //th.join();
        System.exit(3);
    }
    public void stopIt(){
        running = false;
    }

    @Override
    public void run(){
        int i = 0;
            //for(int i = 0;i<100;i++){
        while ( i < 1000){
                System.out.println("!- "+i++);
            }

    }
}
