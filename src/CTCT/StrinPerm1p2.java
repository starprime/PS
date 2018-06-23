package CTCT;

/**
 * Created by star on 6/23/18.
 */

public class StrinPerm1p2 {
    public static void main(String [] args){
        // provided length should be same
        boolean [] arr = stringPerm("asdf");

        for(char c:"dfs".toCharArray()){
            if(!arr[Integer.valueOf(c)-97]){
                System.out.println("not permutation");
            }
        }
        System.out.println("its a permutation");
    }
    public static boolean [] stringPerm(String str){
        str = str.toLowerCase();
        boolean [] arr = new boolean[(Integer.valueOf('z')-Integer.valueOf('a'))+1];

        for(char c:str.toCharArray()){
            arr[Integer.valueOf(c)-97] = true;
        }
        return arr;
    }
}


