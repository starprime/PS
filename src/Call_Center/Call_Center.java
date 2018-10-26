package Call_Center;

/**
 * Created by star on 10/16/18.
 */
public class Call_Center {
    private Escalate_Call escalate_call1;

    public Call_Center(){

        this.escalate_call1 = new Operator();
        Escalate_Call escalate_call2 = new Supervisor();
        Escalate_Call escalate_call3 = new Director();

        this.escalate_call1.setNextChain(escalate_call2);
        escalate_call2.setNextChain(escalate_call3);

    }

    public static void main(String []args){
        Call_Center call_center = new Call_Center();
        Call c = new Call();
        c.setNumber(12312);
        call_center.escalate_call1.attend(c);
    }
}
