package CTCT.StackNQueue;

import java.util.Random;

/**
 * Created by star on 8/2/18.
 */
public class StackOfPlates {
    public static void main(String []args){
        Stack st = new Stack(3);
        Random rn = new Random();

        for(int i =0;i<62;i++){
            st.push(i);
        }

        st.printAll();
        System.out.println("size");
        System.out.println(st.getSize());
        System.out.println("ot");
        st.push(1212);
        System.out.println(st.getSize());

//        for(int i = 0;i<60;i++){
//            System.out.println(st.pop());
//        }

    }

}
