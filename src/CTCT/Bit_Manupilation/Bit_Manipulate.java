package CTCT.Bit_Manupilation;

/**
 * Created by star on 7/30/18.
 */
public class Bit_Manipulate {
    public static void main(String [] args){

        int n = 100000000; int m = 1001; int i = 2; int j = 5;
        int allOnes = ~0;
        int left = allOnes << (j+1); // move left , 1s before position j then 0s 111000000

        int right = ((1 << i) -1);
        int mask = left | right;
        System.out.println();
    }
//    public static int updateBits(int m,int n,int i,int j){
//
//
//
//    }
}
