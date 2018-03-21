/**
 * Created by star on 3/16/18.
 */
import java.io.*;
import java.util.*;

class DifferentNumber {

    static int getDifferentNumber(int[] arr)
    {
        int len = arr.length;
        int l=0,r=len-1;
        int mid=0;
        while(l<r){
            mid=l+(r-l)/2;
            System.out.println(mid);
            if(mid==arr[mid]){
                l=mid+1;
            }else{
                r=mid;
            }
        }
        return arr[l];
        // your code goes here
    }
    public static void main(String[] args) {
        int [] arr=new int[]{0,3,5,1,2,7,4,6};
        System.out.println(getDifferentNumber(arr));
    }
}

// 3 5 1 2 7