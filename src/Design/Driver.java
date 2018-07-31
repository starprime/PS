package Design;

/**
 * Created by star on 7/31/18.
 */
public class Driver {
    public static void main(String [] args){
        Task_Schedular_Easy tse = new Task_Schedular_Easy(6);
        int [] arr = {1,2,3,4,5,6,2,4,6,1,2,4};
        System.out.println(tse.schedule_Task(arr));
    }
}
