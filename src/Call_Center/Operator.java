package Call_Center;

/**
 * Created by star on 10/16/18.
 */

public class Operator implements Escalate_Call {
    private Escalate_Call escalate_call;
    boolean busy;

    @Override
    public void setNextChain(Escalate_Call escalate_call) {
        this.escalate_call = escalate_call;
    }

    @Override
    public void attend(Call call) {
        this.busy = true;
        if (this.busy){
            this.escalate_call.attend(call);
        }else{
            System.out.println("Operator has attended the call");
        }
    }
}
