package CTCT;

/**
 * Created by star on 6/18/18.
 */
public class UniqChar1p1 {
    public static void main(String [] args){
        System.out.println(uniqChar("asdf"));
    }
    public static boolean uniqChar(String str){
        str = str.toLowerCase();
        boolean [] arr = new boolean[(Integer.valueOf('z')-Integer.valueOf('a'))+1];

        for(char c:str.toCharArray()){
            System.out.println(Integer.valueOf(c));
            if(arr[Integer.valueOf(c)-97]){
                return false;
            }
            arr[Integer.valueOf(c)-97] = true;
        }
        return true;
    }
}
