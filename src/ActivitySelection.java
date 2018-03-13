/**
 * Created by skuma115 on 8/13/2017.
 */

public class ActivitySelection {
    public static void main(String []args){
        int s[] =  {1, 3, 0, 5, 8, 5};
        int f[] =  {2, 4, 6, 7, 9, 9};
        int n = s.length;
        printMaxAct(s,f,n);
    }
    public static void printMaxAct(int s[],int []f,int n){
        System.out.println(s[0]+"--"+f[0]);
        for(int i=1;i<n;i++){
            if(f[i-1]<s[i]){
                System.out.println(s[i]+"--"+f[i]);
            }
        }
    }
}
