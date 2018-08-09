package CTCT.StackNQueue;

import java.util.*;
import java.util.Stack;

/**
 * Created by star on 8/4/18.
 */
public class SortStack {
    public static void main(String [] args){
        Stack<Integer> ma = new Stack<>();
        //int [] arr={3,5,2,1,7,9};
        int [] arr={9,7,1,2,3,5};
        for(int i:arr)ma.push(i);

        System.out.println(ma);
        sort(ma);
        System.out.println(ma);
    }

    public static void sort(Stack<Integer> main){
        Stack<Integer> tmp = new Stack<>();
        int buf = main.pop();

        while (!main.isEmpty()) {
            while (!main.isEmpty()&&main.peek() > buf) {
                tmp.push(buf);
                buf = main.pop();
            }
            if (main.isEmpty()){
                break;
            }
            tmp.push(buf);
            buf = main.pop();
            while (!tmp.isEmpty()) {
                if(tmp.peek()>buf){
                    main.push(tmp.pop());
                }
            }
        }
        while (!tmp.isEmpty()){
            main.push(tmp.pop());
        }
    }
}
