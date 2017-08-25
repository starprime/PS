/**
 * Created by skuma115 on 8/2/2017.
 */

/// USE STRING BUILDER
public class ReverseString {
    public static void main(String []args){
        String s="helllo";
        ReverseString rev=new ReverseString();
        System.out.println(rev.getReverseString(s));
    }
    private String getReverseString(String s){
        char f,l;int len=s.length();
        char [] ret=new char[len];
        for(int i=len-1,j=0;i>=0;i--,j++){
            ret[j]=(char)s.charAt(i);
        }
        return new String(ret);
    }
}
