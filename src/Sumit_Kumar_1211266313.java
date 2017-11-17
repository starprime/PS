    //SUMIT KUMAR
    //1211266313
import java.util.*;

public class Sumit_Kumar_1211266313 {

    public static void main(String []args){
        Sumit_Kumar_1211266313 s=new Sumit_Kumar_1211266313();

        System.out.println(s.lengthOfLastWord("Note: is Run Code inconsistent with Submit Solution? If you are using global variables or C/C++, check this out."));
        //System.out.println(s.lengthOfLastWord("   "));
        System.out.println(s.numDecodings("418913"));
        List<List<Integer>> li=new ArrayList<>();
        List<Integer> lo=new ArrayList<>();
        lo.add(-1);li.add(lo);
        lo=new ArrayList<>();lo.add(-2);lo.add(-3);li.add(lo);
        lo=new ArrayList<>();lo.add(-3);lo.add(1);lo.add(-1);li.add(lo);

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
        System.out.println(s.minimumTotal(li));

    }
    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String ret = "1";
        int i = 1;

        while (i < n) {
            StringBuilder temp = new StringBuilder();
            int count = 1;
            for (int j = 1; j < ret.length(); j++) {
                if (ret.charAt(j) == ret.charAt(j - 1)) {
                    count++;
                } else {
                    temp.append(count);
                    temp.append(ret.charAt(j - 1));
                    count = 1;
                }
            }

            temp.append(count);
            temp.append(ret.charAt(ret.length() - 1));
            ret = temp.toString();
            i++;
        }

        return ret;
    }

    public int maxSubArray(int[] nums) {
        int len=nums.length;
        if (nums==null || len==0) {
            return 0;
        }
        int sum,maxSum;
        maxSum = sum = nums[0];
        for (int i=1; i<len; ++i) {
            if (sum >= 0) {
                sum += nums[i]; }
            else { sum = nums[i]; }
            maxSum = Math.max(maxSum, sum);
        }
        return maxSum;
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
    // 1783121324
    //[-2,1,-3,4,-1,2,1,-5,4]
    public int numDecodings(String s) {
        int len=s.length();
        if(len == 0||s==null||s.equals("0")) {
            return 0;
        }
        int ret;
        int[] ways = new int[len+1];
        ways[0] = 1;
        if(s.charAt(0)=='0')ways[1]=0;
        else ways[1]=1;
        int single=0,doub=0;
        for(int i = 2; i <= s.length(); i++) {
            single = Character.getNumericValue(s.charAt(i-1));
            doub = Character.getNumericValue(s.charAt(i-2));

            doub=doub*10+single;

            if(single > 0 && single < 10) {
                ways[i] += ways[i-1];
            }
            if(doub > 9 && doub < 27) {
                ways[i] += ways[i-2];
            }
        }

        return ways[len];
    }

    //1234
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
}