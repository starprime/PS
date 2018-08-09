package CTCT.StackNQueue;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by star on 8/3/18.
 */

public class Stack {

    //static int ptr;
    static int nthStack;
    List<List<Integer>> st;
    static int threshold;

    public Stack(int threshold){

        this.threshold = threshold;
        st = new ArrayList<>();
        st.add(new ArrayList<>());
        //ptr = 0;
        nthStack = 0;

    }

    public void push(int val){
        List<Integer> li = st.get(nthStack);
        int ptr = li.size();
        li.add(ptr,val);
        if(ptr>=threshold){
            st.add(new ArrayList<>());
            nthStack++;
        }
    }

    public void printAll(){

        System.out.println(st);

    }

    public int popAt(int indx){
        List<Integer> li = st.get(indx);
        int sze = li.size();
        if(sze == 0){
            st.remove(indx);
            return -1;
        }
        return li.remove(sze-1);
    }

    public int pop(){

        List<Integer> li = st.get(nthStack);
        int ptr = li.size();
        if(ptr==0){
            st.remove(nthStack);
            nthStack--;
            li = st.get(nthStack);
            ptr = li.size();
        }

        return li.remove(ptr-1);

    }

    public int getSize(){
        int ret = 0;
        for(int i = 0;i<=nthStack;i++){
            System.out.println(st.get(i).size());
            ret+=st.get(i).size();
        }
        return ret;
    }


    public int getPtr() {
        return st.get(nthStack).size();
    }

    public static int getNthStack() {
        return nthStack;
    }

}
