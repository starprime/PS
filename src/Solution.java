//import javafx.util.Pair;

import java.util.*;

/**
 * Created by star on 12/13/18.
 */

/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode(int x) { val = x; }
 * }
 */
public class Solution {
    public static void main(String []args){
        int []arr = new int[]{4,5,6,7,0,1,2};
        System.out.println(new Solution().findMin(arr));

        StringBuilder sb = new StringBuilder();
        sb.insert(0,"asda");
        sb.insert(0,"hrtgr");
        System.out.println(findNum("am"));

        Map<Integer, List<Integer>> mp = new HashMap<>();
    }

//    public List<String> addOperators(String num, int target) {
//
//        StringBuilder sb = new StringBuilder(num);
//        rec(sb, 1, "+", target);
//        rec(sb, 1, "-", target);
//        rec(sb, 1, "*", target);
//
//    }

    private void rec(StringBuilder sb, int indx, String sig, int tgt){
        if(indx >= sb.length()){
            cal(sb.toString());
        }
        rec(sb, indx+2, "+", tgt);
        rec(sb, indx+2, "-", tgt);
        rec(sb, indx+2, "*", tgt);

        sb.insert(indx,sig);
        rec(sb, indx+2, "+", tgt);
        rec(sb, indx+2, "-", tgt);
        rec(sb, indx+2, "*", tgt);

        return;
    }

    private void cal(String s){
        int sm = 0;
        for(char c:s.toCharArray()){
            //sif(c == '*')
        }
    }

    public static String findNum(String s){
        char c1 = s.charAt(0);
        String key = "";

        for(int i = 0;i<s.length();i++){
            char c = s.charAt(i);
            if(c - c1 < 0)c+=26;
            key+=c-c1;
        }
        return key;
    }

    public int findMin(int[] nums) {

        int l = 0, r = nums.length-1;
        int m = l+(r-l)/2;

        while(l <= r){
            m = l+(r - l)/2;
            if(m == 0 || m == nums.length-1)return nums[m];
            else if(nums[m] < nums[m+1] && nums[m] < nums[m-1]){
                return nums[m];
            }
            else if(nums[m] > nums[r]){
                l = m + 1;
            }else if(nums[m] < nums[r]){
                r = m - 1;
            }
        }

        return nums[m];

    }
//    public int findCircleNum(int[][] M) {
//
//        int []arr = new int[M.length];
//        Arrays.fill(arr, -1);
//        List<List<Integer>> visited = new ArrayList<>();
//
//        for(int i = 0;i<M.length;i++){
//            for(int j = 0; j < M[0].length;j++){
//                List<Integer> li = new ArrayList<>();
//                li.add(j);li.add(i);
//                if(M[i][j] == 1  &&  i != j){
//                    li = new ArrayList<>();
//                    li.add(i);li.add(j);
//                    visited.add(li);
//                    union(arr, i, j);
//                }
//            }
//        }
//
//        int ret = 0;
//        Set<Integer> st = new HashSet<>();
//        for(int i :arr){
//            //System.out.print(i+" ,");
//            if(i == -1)ret++;
//        }
//        return ret;
//
//    }
//
//    public void union(int []arr, int par, int chil){
//
//        int parpar = find(arr, par);
//        int chilpar = find(arr, chil);
//        if(chilpar != parpar)
//            arr[chilpar] = parpar;
//        return;
//
//    }
//
//    public int find(int []arr, int chil){
//
//        if(arr[chil] == -1 ){
//            return chil;
//        }
//
//        return find(arr, arr[chil]);
//    }
//    public int findMaxJump(int []arr){
//
//        TreeSet<Integer> st  = new TreeSet<>();
//        for(int i :arr)st.add(i);
//
//        for(int i = 0;i<arr.length - 1;i++){
//            int j = i;
//            while( j!= arr.length-1){
//                int jmp = 1;
//
//                if(jmp%2 == 0){
//                    int floor = st.floor(arr[j]);
//
//                }else {
//                    int ceiling = ceiling(arr, j);
//                }
//            }
//
//
//        }
//
//
//    }
//
//    private int ceiling(int []arr, int i){
//        if(i >= arr.length -1)return -1;
//        int j = i+1 ,mx = i+1;
//
//        while (j<arr.length-1){
//            if(arr[mx] < arr[j] && arr[mx] > arr[i]){
//
//            }
//        }
//    }

//    public int findKthLargest(int[] nums, int k) {
//        int start = 0, end = nums.length - 1, index = nums.length - k;
//        while (start < end) {
//            int pivot = partion(nums, start, end);
//            if (pivot < index) start = pivot + 1;
//            else if (pivot > index) end = pivot - 1;
//            else return nums[pivot];
//        }
//        return nums[start];
//    }
//
//    private int partion(int[] nums, int start, int end) {
//
//        List<Integer> li = new ArrayList<>();
//
//        int pivot = nums[end];
//
//        int i = start, j = start;
//
//        swap(nums, i, end);
//
//        while (j < end){
//
//            if(pivot > nums[j]){
//                swap(nums, i, j);
//                i++;
//            }
//            j++;
//        }
//
//        swap(nums,end,i);
//
//        PrintArray.printArray(nums);
//        return pivot;
//    }
//    void swap(int []nums, int i,int j){
//        int tmp = nums[i];
//        nums[i] = nums[j];
//        nums[j] = tmp;
//    }
}