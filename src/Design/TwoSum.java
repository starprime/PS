package Design;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by star on 7/30/18.
 * Design and implement a TwoSum class. It should support the following operations: add and find.

 add - Add the number to an internal data structure.
 find - Find if there exists any pair of numbers which sum is equal to the value.
 */
class TwoSum {
    List<Integer> li;
    /** Initialize your data structure here. */
    public TwoSum() {
        li = new ArrayList<>();
    }

    /** Add the number to an internal data structure.. */
    public void add(int number) {
        if(li.size()==0)li.add(number);
        for(int i=0;i<li.size();i++){
            if(li.get(i) > number){
                li.add(i,number);
            }
        }
    }

    /** Find if there exists any pair of numbers which sum is equal to the value. */
    public boolean find(int value) {
//        int [] arr = new int[li.size()];
//        for(int i=0;i<li.size();i++){
//            if(li.get(i) > number){
//                li.add(i,number);
//            }
//        }
        return false;
    }
}

/**
 * Your TwoSum object will be instantiated and called as such:
 * TwoSum obj = new TwoSum();
 * obj.add(number);
 * boolean param_2 = obj.find(value);
 */
