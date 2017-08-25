import java.util.HashMap;

/**
 * Created by skuma115 on 7/4/2017.
 */
public class FibbiDP {
    HashMap<Integer,Integer> memo=new HashMap<Integer, Integer>();
    static int [] dparr;
    public FibbiDP(int n){
        dparr=new int[n];
    }
    public static void main(String [] args){
        int fib=0,n=6;
        FibbiDP fo=new FibbiDP(n+1);
        fibbiDP(n+1);
        for(int k:dparr){
            System.out.println(k);
        }

    }
    public static void fibbiDP(int n){
        for (int i=0;i<n;i++){
            if(i<3){dparr[i]=1;}
            else{dparr[i]=dparr[i-1]+dparr[i-2];}
        }
    }


    public  int fibbiRecMemo(int n){
        int febret=0;
        if(memo.containsKey(n)){return memo.get(n);}
        else if(n<=2){febret=1;}
        else{febret=fibbiRecMemo(n-2)+fibbiRecMemo(n-1);}
        memo.put(n,febret);
        return febret;
    }
}
