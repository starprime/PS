package LeetCodeDesign;

import java.util.*;

/**
 * Created by star on 9/16/18.
 */
class MovingAverage {
    Queue<Integer> qu;
    int size;
    /** Initialize your data structure here. */
    public MovingAverage(int size) {
        qu = new LinkedList<>();
        this.size = size;
    }

    public double next(int val) {
        qu.add(val);
        if(qu.size()>size){
            qu.poll();
        }
        double avg = 0.0;
        Iterator<Integer> it = qu.iterator();
        while (it.hasNext()){
            avg += it.next();
        }
        return avg/qu.size();

    }
}