package CTCT;

/**
 * Created by star on 6/23/18.
 */
public class RemoveSpaces1p3 {
    public static void main(String [] args){
        StringBuilder sb = new StringBuilder();
        String st = "lil max torn a";

        for(char c:st.toCharArray()){
            if(c==' '){
                sb.append('%');
                sb.append('2');
                sb.append('0');
            }else {
                sb.append(c);
            }
        }
        System.out.println(sb.toString());
    }
}
