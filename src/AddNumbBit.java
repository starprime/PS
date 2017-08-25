/**
 * Created by skuma115 on 7/7/2017.
 */
public class AddNumbBit
{
    public int addNum(){
        int x=9,y=9,sum,car;
        while(y!=0){
            car=x&y;
            x=x^y;
            y=car<<1;
        }return x;
    }
    public static void main(String [] args){
        AddNumbBit adb=new AddNumbBit();
        System.out.println(adb.addNum());
    }

}
