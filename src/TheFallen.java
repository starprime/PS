import java.net.Inet4Address;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/**
 * Created by star on 6/10/18.
 */
public class TheFallen {
    static HashSet<String> res = new HashSet<>();
    public static void main(String []args){
        String st = "kjasd";
        TheFallen p = new TheFallen();

        List<Integer> li = new ArrayList<>();
        //p.getPermute(st,0,st.length()-1);
        //System.out.println(p.swap(st,2,3));
        p.coinChange(4,li,new int[]{1,2,3});
    }

    public void getPermute(String st,int l,int r){
        int len = st.length();

        if(l==r) System.out.println(st);

        for(int i=l;i<st.length()-1 ;i++){

        }


    }

    public String swap(String st, int i,int j){
        char c=st.charAt(i);
        char d=st.charAt(j);
        return st.substring(0,i)+d+st.substring(i+1,j)+c+st.substring(j+1,st.length());
    }

    public void coinChange(int rem,List<Integer> li,int [] arr){

        if(rem==0) {
            System.out.println("got it");
            printList(li);
            return;
        }
        for(int i=0;i<arr.length;i++){
            if(rem - arr[i]>=0){
                rem=rem-arr[i];
            }
            li.add(arr[i]);
            coinChange(rem,li,arr);
        }
    }

    public void printList(List<Integer> li){
        for(int i=0;i<li.size();i++){
            System.out.print(li.get(i));
        }
    }

}
