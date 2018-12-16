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
class Solution {
    public static void main(String []args){
        List<Integer> li = new ArrayList<>();
        li.add(45);
        li.add(15);
        li.add(7);
        li.add(8);
        li.add(10);

        kSub(15,li);
    }


    public static List<String> computeParameterValue(List<List<String>> sources) {
        // Write your code here
        Set<String> st = new LinkedHashSet();
        Map<String,String> mp = new HashMap<>();

        for(List<String> li:sources){
            for(String itm : li){
                String[] tmp = itm.split(":");
                mp.put(tmp[0],tmp[1]);
                st.add(tmp[0]);
            }
        }

        List<String> ret = new LinkedList<>();

        Iterator<String> itr = st.iterator();

        while(itr.hasNext()){
            ret.add(mp.get(itr.next()));
        }
        return ret;

    }

    public static long kSub(int k, List<Integer> nums) {
        int mod[] = new int[k];
        Arrays.fill(mod, 0);
        int cumSum = 0;
        int neindx = 0;
        for (int i = 0; i < nums.size(); i++) {
            cumSum += nums.get(i);
            neindx = ((cumSum % k) + k);
            mod[neindx]++;
        }

        // Initialize result
        int result = 0;

        // Traverse mod[]
        for (int i = 0; i < k; i++)
            if (mod[i] > 1)
                result += (mod[i] * (mod[i] - 1)) / 2;

        result += mod[0];

        return result;
    }
}