import java.util.HashSet;
import java.util.Set;

public class Solution {
    public boolean isHappy(int n) {
        int x=0,total=0;
        Set<Integer> alrd=new HashSet<>();
        while(true){
            total=0;
            while(n!=0){
                x=n%10;
                total+=Math.pow(x,2);
                n=n/10;
            }

            System.out.println(total);
            if(total==1){return true;}
            else if(alrd.contains(total)){return false;}
            alrd.add(total);
            n=total;
        }
    }
    public static void main(String []args){
        Solution s=new Solution();
        System.out.println(s.isHappy(1111111));
    }
}