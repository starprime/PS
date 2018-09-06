/**
 * Created by star on 9/5/18.
 */
class PushZero
{
    static void moveZeros(int arr[])
    {   int n = arr.length;
        int count = 0;

        for (int i = 0; i < n; i++)
            if (arr[i] != 0)
                arr[count++] = arr[i];

        while (count < n)
            arr[count++] = 0;
    }

    public static void moveZeros2(int[] nums) {
        int cntr=0,strt=0;
        for(int j=0,i=0;j<nums.length;j++){
            if(nums[j]==0&&cntr==0){
                i=j;
                strt=i;
                cntr++;
            }else if(nums[j]!=0){
                swap(nums,strt,j);
                strt=strt+1;
                i=j;
            }else if(nums[j]==0&&cntr!=0){
                cntr++;
                i=j;
            }
        }
    }

    public static void swap(int[] nums,int a,int b){
        int temp=nums[a];
        nums[a]=nums[b];
        nums[b]=temp;
    }

    public static void main (String[] args)
    {
        int arr[] = {0,1,0,3,12};
        int n = arr.length;
        moveZeros2(arr);
        System.out.println("Array after pushing zeros to the back: ");
        for (int i=0; i<n; i++)
            System.out.print(arr[i]+" ");
    }
}