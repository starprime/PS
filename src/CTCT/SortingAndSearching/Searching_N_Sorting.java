package CTCT.SortingAndSearching;

import java.util.*;

/**
 * Created by star on 7/29/18.
 */
public class Searching_N_Sorting {
    public static void main(String [] args){
        String [] arr = new String[]{"eat", "tea", "tan", "ate", "nat", "bat"};
        //System.out.println(groupAnagrams(arr));
        int [] arrInt = new int[]{1,2,4,5,6,7,0};
        System.out.println(search(arrInt,3));
    }
    static public int search(int[] nums, int target) {
        if(nums.length==0)return -1;
        if(nums.length==1){
            if(target==nums[0]){return 0;}
            else{return -1;}
        }
        int pivot = getPivot(nums,0,nums.length-1);
        System.out.println(pivot);
        if(target>=nums[0]&&target<nums[pivot-1]){
            return binarySearch(nums,0,pivot-1,target);
        }else if(target>nums[pivot]&&target<=nums[nums.length-1]){
            return binarySearch(nums,pivot,nums.length-1,target);
        }else if(target==nums[pivot]){
            return pivot;
        }else{
            return -1;
        }
    }
    static public int binarySearch(int[] nums,int l,int r,int target){
        int mid = (l+r)/2;
        while (l<=r){
            mid = (l+r)/2;
            if(nums[mid]>target){
                r = mid;
            }else if(nums[mid]<target){
                l = mid;
            }else if(nums[mid]==target){
                return mid;
            }
        }
        return -1;
    }
    static public int getPivot(int []arr,int l,int r){
        int mid=(l+r)/2;
        while (l<r){
            mid = (l+r)/2;
            //System.out.println(mid);
            if(arr[l]<arr[mid]){
                l = mid;
            }else {
                r = mid;
            }
        }
        return mid+1;
    }
    static public List<List<String>> groupAnagrams(String[] strs) {

        Map<String,List<String>> mp = new HashMap<>();
        for(String st:strs){
            char []arr = st.toCharArray();
            TreeMap<Character,Integer> tmp = new TreeMap<>();
            for(char c:arr){
                tmp.put(c,tmp.getOrDefault(c,0)+1);
            }
            StringBuilder stringBuilder = new StringBuilder();
            for(Map.Entry<Character,Integer> entry:tmp.entrySet()){
                String stng = entry.getKey()+ entry.getValue().toString();
                stringBuilder.append(stng);
            }

            String ke = stringBuilder.toString();
            List<String> li;
            if(mp.containsKey(ke)){
                li = mp.get(ke);
                li.add(st);
            }else {
                 li = new ArrayList<>();
                 li.add(st);
            }
            mp.put(ke,li);
        }
        List<List<String >> ret = new ArrayList<>();
        for(Map.Entry<String ,List<String>> mps:mp.entrySet()){
            ret.add(mps.getValue());
        }
        return ret;
    }
}
