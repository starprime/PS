/**
 * Created by skuma115 on 6/25/2017.
 */
public class SwapBits {
    public static void main(String [] args){
        int i=47,p1=1, p2=5, n=3;
        int s1=(i>>p1)&((1<<n)-1);
        int s2=(i>>p2)&((1<<n)-1);
        int xor=s1^s2;
        int rexor=(xor<<p1)|(xor<<p2);
        int result=i^rexor;
        System.out.print("\nrexor "+rexor+"\nxor "+xor+"\ns2 "+s2+"\ns1 "+s1+"\nresult "+result);
    }
}
