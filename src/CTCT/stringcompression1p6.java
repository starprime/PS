package CTCT;

/**
 * Created by star on 6/23/18.
 */
public class stringcompression1p6 {
    public static void main(String []args){
        String st = "aabvvvvvdddllk";
        int prv = 0;
        StringBuilder sb = new StringBuilder();

        for(int i = 1;i<st.length();i++){
            if(st.charAt(prv)!=st.charAt(i)){
                sb.append(st.charAt(prv));
                if((i-prv) > 1)
                    sb.append(i-prv);
                prv = i;
            }
        }
        System.out.println(sb.toString());

    }

}
