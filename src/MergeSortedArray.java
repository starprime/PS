/**
 * Created by skuma115 on 8/2/2017.
 */
public class MergeSortedArray {
    public static void main(String []args){
        int []nums1={1,9,21,32,35,87,98,789,8712,12311};
        int []nums2={2,3,5,7,43,45,74,211,522};
        MergeSortedArray msa=new MergeSortedArray();
        msa.printArr(msa.getMergeSortedArray(nums1,nums2));
    }
    private int[] getMergeSortedArray(int []nums1,int []nums2){
        int i,j;
        int []ret=new int[nums1.length+nums2.length];int r=0;
        //for(int i=0;i<ret.length;i++){ret[i]=0;}
        for( i=0,j=0;i<nums1.length&&j<nums2.length;){
            if(nums1[i]>nums2[j]){
                ret[r++]=nums2[j++];
            }else{
                ret[r++]=nums1[i++];
            }
        }
        System.out.println(j+"--"+i);
        if(j==(nums2.length)){
            while(i<nums1.length){ret[r++]=nums1[i++];}
        }else if(i==(nums1.length)){
            while(j<nums2.length){ret[r++]=nums2[j++];}
        }
        return ret;
    }
    void printArr(int []nums){
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
}
