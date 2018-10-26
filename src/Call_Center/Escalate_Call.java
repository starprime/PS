package Call_Center;

/**
 * Created by star on 10/16/18.
 */
public interface Escalate_Call {
    void setNextChain(Escalate_Call escalate_call);
    void attend(Call call);
}
