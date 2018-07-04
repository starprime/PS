package CTCT;

/**
 * Created by star on 6/23/18.
 */
public class PalinDrome1p4 {
    public static void main(String []args){
        String st = "alaouralaourwq";
        boolean [] nt = new boolean[26];
        for(char c:st.toCharArray()){
            if(nt[Integer.valueOf(c)-97]){
                nt[Integer.valueOf(c)-97] = false;
            }else {
                nt[Integer.valueOf(c)-97] = true;
            }
        }
        int k = 0;
        for(boolean b:nt){
            if(b){
                k++;
            }
        }
        if((st.length()%2==0&&k==0)||(st.length()%2==1&&k==1)){
            System.out.println("true");
        }else {
            System.out.println("false");
        }
    }
}
