public class LongIncSubSeq{
    public static void main(String []args){
        int []arr={1,3,6,7,9,4,10,5,6};

        System.out.print(lengthOfLIS(arr));

    }
     static public int lengthOfLIS(int []nums){
        int []dparr=new int[nums.length];
        int ret=0;
        int cntr=0, curr=0;
        for(int i=0;i<nums.length;i++){
            dparr[i]=1;
        }
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" -- ");
            for(int j=i;j<nums.length;j++){
                if(nums[j]>nums[i]){
                    if(dparr[i]>1) {
                        dparr[j] = dparr[i] + 1;
                    }else if(dparr[j]==1){
                        dparr[j]=dparr[j]+1;
                    }
                }
            }   for (int k : dparr) {
                System.out.print(k);
                System.out.print("\t");
            }System.out.println();
        }for(int k:dparr){
            if(k>ret){
                ret=k;
            }
         }
        return ret;
    }
}