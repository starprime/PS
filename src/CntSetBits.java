/**
 * Created by skuma115 on 6/25/2017.
 */
public class CntSetBits {
    public static void main(String[] args){
        CntSetBits cnb=new CntSetBits();
        System.out.println(cnb.CntBit(16));
    }
    public int CntBits(int n){
        int count=0;
        while(n!=0){
            count+=n&1;
            n>>=1;
        }return count;
    }
    public int CntBit(int n){
        int count=0;
        if(n<=0)return 0;
            if(n%2==0){
                count= 0+CntBit(n/2);
            }else{
                count= 1+CntBit(n/2);
            }
        return count;
    }
}
