package Design;

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

/**
 * Created by star on 8/1/18.
 */

class Task_Schedular_Leetcode {
    public static void main(String [] args){
        Task_Schedular_Easy tse = new Task_Schedular_Easy(2);
        int [] arr = {1,1,2,1};
        char [] task = {'A','A','B','B','B'};
        //System.out.println(tse.schedule_Task(arr));
        leastInterval(task,4);
    }

    static public int leastInterval(char[] tasks, int n) {
        Map<Character,Integer> mp = new HashMap<>();

        for(char c:tasks){
            mp.put(c,mp.getOrDefault(c,0)+1);
        }
        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue() != b.getValue()?b.getValue() - a.getValue(): a.getKey() - b.getKey()
        );

        pq.addAll(mp.entrySet());

        while (!pq.isEmpty()){
            Map.Entry<Character,Integer> tmp = pq.poll();
            System.out.println(tmp.getKey()+" --"+tmp.getValue());
        }

        return 1;

    }
}