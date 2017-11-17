import java.util.*;

public class Solution {

    public static void main(String []args){
        Solution s=new Solution();
        //System.out.print(s.lengthOfLastWord("Note: is Run Code inconsistent with Submit Solution? If you are using global variables or C/C++, check this out."));
        //System.out.println(s.lengthOfLastWord("   "));
        //System.out.println(s.numDecodings("418913"));
        List<List<Integer>> li=new ArrayList<>();
        List<Integer> lo=new ArrayList<>();
        lo.add(-1);li.add(lo);
        lo=new ArrayList<>();lo.add(-2);lo.add(-3);li.add(lo);
        //lo=new ArrayList<>();lo.add(-3);lo.add(1);lo.add(-1);li.add(lo);

        /*
        lo.add(6);li.add(lo);
        lo=new ArrayList<>();lo.add(8);lo.add(7);li.add(lo);
        lo=new ArrayList<>();lo.add(3);lo.add(4);lo.add(2);li.add(lo);
        lo=new ArrayList<>();lo.add(8);lo.add(9);lo.add(-1);lo.add(3);li.add(lo);
        lo=new ArrayList<>();lo.add(21);lo.add(29);lo.add(-21);lo.add(30);lo.add(20);li.add(lo);
        */
//    [-1]
//   [3,2]
// [-3,1,-1]
        for (int i=0;i<li.size();i++){
            lo=li.get(i);
            //System.out.println(lo);

        }
        //System.out.println(li);
        //System.out.println(s.minimumTotal(li));
        //System.out.println(s.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));

        //System.out.println(s.removeDuplicates(new int[]{1, 2,2,3,4,5,5,6}));
        int[] nums=new int[]{1,1,2};
        //s.removeDuplicates(nums);
        System.out.println("pwo "+s.myPow(3,2));
    }

    public String countAndSay(int n) {
        return " ";
    }
    public int maxSubArray(int[] nums) {
        return 0;
    }
    public int lengthOfLastWord(String s) {
        s=s.trim();
        if(s==null||s.equals(""))return 0;
        Stack<String> st=new Stack<>();
        for(String word:s.split(" ")){
            st.push(word);
        }
        return st.pop().length();
    }
    public int numDecodings(String s) {
        int n=s.length();
        int []dp=new int[n+1];
        dp[0]=1;
        dp[1]=(s.charAt(0)=='0')?0:1;

        for(int i=2;i<s.length();i++){
            int x=Character.getNumericValue(s.charAt(i-1));
            int y=Character.getNumericValue(s.charAt(i-2));

        }
        return 0;
    }
    public int minimumTotal(List<List<Integer>> triangle) {
        int n=triangle.size();
        if (n == 0) {
            return 0;
        }
        int min = 0, prev = 0, curr = 0;
        int[] ret = new int[n];
        ret[0] = triangle.get(0).get(0);
        min = ret[0];
        int len=0;
        List<Integer> li;
        for (int i = 1; i < n; i++) {
            ret[i]=Integer.MAX_VALUE;
            li = triangle.get(i);
            len=li.size();
            prev = ret[0];
            ret[0] += li.get(0);
            for(int j = 1; j < len; j++) {
                curr = ret[j];
                if (curr <= prev) {
                    ret[j] += li.get(j);
                } else {
                    ret[j] = li.get(j) + prev;
                }
                prev = curr;
            }
        }

        min = ret[0];
        for (int i = 1; i < n; i++) {
            min=Math.min(min,ret[i]);
        }

        return min;
    }
    public int pivotIndex(int[] nums) {
        int len=nums.length;
        int suml=0,sumr=0;
        int i=0,j=len-1;
        while(j>i){
            //if(suml=sumr)
        }
        return 0;
    }
    public void removeDuplicates(int[] nums) {
        int tn = 0, p = 0;
        int c=1;
        while (c<nums.length){
            if(nums[c]==nums[tn]){
                c++;
            }else{
                tn++;
                nums[tn]=nums[c];
                c++;
            }
        }
        for(int i=0;i<nums.length;i++){
            System.out.println(nums[i]);
        }
        System.out.println(tn+"\n --");

        int []arr=Arrays.copyOfRange(nums,0,tn+1);
        for(int i=0;i<arr.length;i++){
            System.out.println(arr[i]);
        }
    }

    public double myPow(double x, int n){
        if(n==0)return 1;
        if(n==1)return x;
        if(n%2==0){
            return myPow(x*x,n/2);
        }else{
            return x*myPow(x*x,(n-1)/2);
        }

    }
}

//    [-1]
//   [2, 3]
//[1, -1, -3]