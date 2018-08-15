/**
 * Created by star on 8/13/18.
 */

import CTCT.GraphAndTrees.TopologicalSort.Tree_Node_Weighted;

import java.util.*;

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */

class Two_Sum {
    public static void main(String []args){
        Two_Sum tw = new Two_Sum();
        tw.add(0);tw.add(-1);tw.add(-1);tw.add(0);

        System.out.println(tw.find(-2));
        System.out.println(tw.find(0));
        System.out.println(tw.find(-1));
        System.out.println(tw.find(1));

    }

    Map<Integer,Integer> mp;
    int max;
    int min;
    /** Initialize your data structure here. */
    public Two_Sum() {
        mp = new HashMap<>();
        max = 0;
        min = 0;
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        mp.put(number,mp.getOrDefault(number,0)+1);

        max = Math.max(max,number);
        min = Math.min(min,number);
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {



        if( value > max * 2 || value * 2 < min ){
            return false;
        }else{
            for(Map.Entry<Integer,Integer> entry : mp.entrySet()){
                int k = entry.getKey();
                int blnc = value - k;
                mp.put(k,mp.get(k)-1);
                if(mp.get(blnc)!=null&&mp.get(blnc)!=0){
                    mp.put(k,mp.get(k)+1);
                    return true;
                }
                mp.put(k,mp.get(k)+1);
            }
        }
        return false;

    }
}
