public class Threads_First implements Runnable{
    public int count=0;

    public void run(){
        System.out.println("Runnable Thread starting");
        try {
            while (count<5){
                Thread.sleep(500);
                count++;
            }
        }catch (InterruptedException e){
            System.out.println("Runnable Thread Interrupted");
        }
        System.out.println("Runnable Thread terminating");
    }

    public static void main(String [] args){
        Threads_First instance = new Threads_First();
        Thread th=new Thread(instance);

        th.start();

        while (instance.count !=5){
            try {
                Thread.sleep(250);
            }
            catch (InterruptedException exc){
                exc.printStackTrace();
            }
        }
    }
}
