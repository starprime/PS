package Observer_Patterns;

/**
 * Created by star on 3/12/18.
 */
public class Subscribers implements Observer {
    String mailId;

    public Subscribers(String id){
        this.mailId=id;
    }

    @Override
    public String toString(){
        return mailId;
    }

    @Override
    public void update() {
        System.out.println(this+"recived notification");
    }
}
