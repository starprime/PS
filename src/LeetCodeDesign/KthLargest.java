package LeetCodeDesign;

import java.util.*;

/**
 * Created by star on 9/14/18.
 */
class KthLargest {
    PriorityQueue<Integer>  st;
    int kth;

    public KthLargest(int k, int[] nums) {
        kth = k;
        st = new PriorityQueue<>();
        for(int i:nums){
            st.offer(i);
        }
    }

    public int add(int val) {
        int ret = 0;
        st.add(val);
        List<Integer> li = new ArrayList<>();
        for(int i=0;i<st.size() - kth-1;i++){
            li.add(st.poll());
        }
        ret = st.poll();
        st.add(ret);
        for(int i = 0;i<li.size();i++){
            st.add(li.get(i));
        }
        return ret;
    }
}
