import java.lang.reflect.Array;
import java.util.*;

/**
 * Created by skuma115 on 8/2/2017.
 */
public class IntersectionArray {
    public static void main(String []args){
        IntersectionArray ia=new IntersectionArray();
        int []nums1={35,2,7,9,1,6};
        int []nums2={22,9,6,4,3,2,1};
        ia.printArr(ia.getIntersectionArray(nums1,nums2));
        ia.printArr(ia.getIntersectArraySort(nums1,nums2));
    }
    int[] getIntersectionArray(int[] nums1,int[] nums2){
        HashSet<Integer> hs=new HashSet<>();
        HashSet<Integer> intercept=new HashSet<>();
        for(int i=0;i<nums1.length;i++){
            hs.add(nums1[i]);
        }
        for(int i=0;i<nums2.length;i++){
            if(hs.contains(nums2[i])){
                intercept.add(nums2[i]);
            }
        }
        int []ret=new int[hs.size()];
        Iterator i=hs.iterator();int k=0;
        while (i.hasNext()){
            ret[k]= (int) i.next();
            k++;
        }
        return ret;
    }
    void printArr(Object []nums){
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    void printArr(int []nums){
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
    }
    int[] getIntersectArraySort(int[] nums1,int[] nums2){
        Arrays.sort(nums1);
        Arrays.sort(nums2);
        int i=0,j=0;
        List<Integer> li=new ArrayList<>();
        while (i<nums1.length&&j<nums2.length){
            if(nums1[i]>nums2[j]){

            }else if(nums1[i]<nums2[j]){

            }else{
                li.add(nums1[i]);
            }
        }
        int []ret=new int[li.size()];
        for(int k=0;i<li.size();k++){
            ret[k]=li.get(k);
        }
        return ret;
    }
}
