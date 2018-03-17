package Singelton_Pat;

/**
 * Created by star on 3/12/18.
 */
class SingleTon{
    static SingleTon instance = null;

    private SingleTon(){

    }

    public static SingleTon getInstance(){
        if(instance==null){
        synchronized (SingleTon.class){
            if(instance==null){
                instance = new SingleTon();
            }
        }
        }
        return instance;
    }
}
