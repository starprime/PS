/**
 * Created by skuma115 on 8/2/2017.
 */
public class MaxConsicutiveOnes {
    public static void main(String []args) {
        int[] arr = {1, 1, 1, 0, 0, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        MaxConsicutiveOnes mco = new MaxConsicutiveOnes();
        System.out.println(mco.getMaxConsicutiveOnes(arr));
    }
    public int getMaxConsicutiveOnes(int []nums){
        int ret=0;
        for(int i=0;i<nums.length;i++){
            if(nums[i]==1){ret++;}
            else{ret=0;}
        }
        return ret;
    }
}
