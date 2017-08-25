import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

/**
 * Created by skuma115 on 8/1/2017.
 */
public class LongestPalindrome {
    public static void main(String []args){
        String s="aaaacbcaaaa";
        LongestPalindrome lp=new LongestPalindrome();
        System.out.println(lp.longestPalindrome(s));
    }
    public int longestPalindrome(String s) {
        HashMap<Integer,Integer> hm=new HashMap<Integer,Integer>();
        int va=0;
        for(int i=0;i<s.length();i++){
            if(hm.containsKey((int)s.charAt(i))){
                va=hm.get((int)s.charAt(i));
                hm.put((int)s.charAt(i),++va);
            }else{
                hm.put((int)s.charAt(i),1);
            }
        }
        int val=0;
        int ret=0;
        Boolean b=false;
        Iterator it=hm.entrySet().iterator();
        while (it.hasNext()){
            Map.Entry pa=(Map.Entry)it.next();
            System.out.println(pa.getValue());
            val=(int)pa.getValue();
            if(val%2==0){
                ret+=val;
            }else{
                b=true;
                ret+=val-1;
            }
        }
        if(b){ret++;}
        return ret;
    }
}
