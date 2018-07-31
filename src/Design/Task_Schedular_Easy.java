package Design;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by star on 7/31/18.
 * Description

 We have scheduler performs tasks. Task types are identified with an integer id. Each task takes 1 interval to complete and once it’s complete we take a cooldown of X intervals before another tasks of the same type can be run. However, we can still run other tasks with different ids. The cooldown is the same for all task types.

 Constraint: We must always run all tasks in the order we receive them (serially)

 Return: An integer representing the minimum intervals needed to process all tasks
 tasks: [3,4,5,3,6,4,5], cooldown: 3
 Result: 8
 3 4 5 _ 3 6 4 5
 tasks: [1,2,3,4,1,1,3,1,2,1,1], cooldown: 4
 Result: 26
 1 2 3 4 _ 1 _ _ _ _ 1 3 _ _ _ 1 2 _ _ _ 1 _ _ _ _ 1
 tasks: [1,1,2,1], cooldown: 2
 Result: 7
 1 _ _ 1 2 _ 1
 tasks: [1,2,3,1,2,3], cooldown: 3
 Result: 7
 1 2 3 _ 1 2 3
 tasks: [1,2,3,4,5,6,2,4,6,1,2,4], cooldown: 6
 Result: 18
 1 2 3 4 5 6 _ 2 _ _ _ 4 _ 6 1 2 _ 4

 */
public class Task_Schedular_Easy {
    Map<Integer,Integer> mp;
    int cooldown;
    public Task_Schedular_Easy(int cooldown){
        mp = new HashMap<>();
        this.cooldown = cooldown;
    }
    public int schedule_Task(int []arr){
        int intrRet = 0;
        int cnt = 0;
        while (cnt<arr.length){
            if(mp.containsKey(arr[cnt])){
                if(intrRet-mp.get(arr[cnt])>=cooldown){
                    mp.put(arr[cnt],intrRet);
                    cnt++;
                }
            }else {
                mp.put(arr[cnt],intrRet);
                cnt++;
            }
            intrRet++;
        }
        return intrRet;
    }

}
