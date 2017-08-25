/**
 * Created by skuma115 on 7/7/2017.
 */

import  java.lang.Math;

public class UglyNumber {
    public boolean isUgly(int n){
        boolean ret;
            while (n%2==0){
                n=n/2;
            }
            while (n%3==0){
                n=n/3;
            }
            while (n%5==0){
                n=n/5;
            }
            n=Math.min(1,2);
            if(n==1){ret=true;}
            else{ret=false;}
        return ret;
    }
    public static void main(String [] args){
        UglyNumber un=new UglyNumber();
        System.out.println(un.isUgly(5831));
    }

}
