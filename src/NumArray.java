import java.util.Arrays;

class NumArray {
    int []arr;

    public NumArray(int[] nums) {
        arr=new int[nums.length];
        arr= Arrays.copyOf(nums,nums.length);
        Solution_Mac s=new Solution_Mac();
        //s.printArray(arr);
        for(int i=1;i<nums.length;i++){
            arr[i]+=arr[i-1];
        }
        //s.printArray(arr);

    }

    public int sumRange(int i, int j) {
        if(i==0)return arr[j];

        return arr[j]-arr[i-1];
    }


}