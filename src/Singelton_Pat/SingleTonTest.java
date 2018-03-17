package Singelton_Pat;

/**
 * Created by star on 3/12/18.
 */
public class SingleTonTest extends Thread {
    SingleTon obj;

    public void run(){
        obj = SingleTon.getInstance();
    }

    public static void main(String args[]) throws Exception{
        SingleTonTest s1 = new SingleTonTest();
        SingleTonTest s2 = new SingleTonTest();

        s1.start();
        s2.start();

        s1.join();
        s2.join();

        System.out.println(s1.obj==s2.obj);
    }
}
