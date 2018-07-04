package CTCT;

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {
    public static void main(String args[] ) throws Exception {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT */
        int [] arr1 = new int[]{0, 1, 3, 3, 3, 4, 5};
        int [] arr2 = new int []{2, 3, 3, 5};

        HashMap<Integer,Integer> mp = new HashMap();
        int i =0, j = 0;

        while (i < arr1.length && j < arr2.length ) {

            if(arr1[i] == arr2[j]){

                mp.put(arr1[i],arr2[j]);

            }else if (arr1[i] > arr2[j]){

                j++;

            }else {

                i++;

            }
        }
        System.out.println(mp);

    }
}