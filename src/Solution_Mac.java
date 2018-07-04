import CTCT.LL.ListNode;

import java.util.*;

public class Solution_Mac {
    public static void main(String []args){
        Solution_Mac s=new Solution_Mac();
        //int [][] arr=new int[][]{{20,18,4},{9,9,10}};
        int [][] arr=new int[][]{{1,2},{2,4},{2,3},{4,5},{6,7},{7,8}};
        //System.out.println(s.topKFrequent(arr,2));
        //System.out.println(s.frequencySort("tree"));
        //System.out.println(s.totalHammingDistance(arr));
        //System.out.println(s.findLongestChain(arr));
        int []nums=new int[]{1,2,3};
        int []a=new int[]{0,1,1,1,1};
        int []b=new int[]{1,0,1,0,1};
        //NumArray obj = new NumArray(nums);
        //System.out.println(obj.sumRange(0,5));
        //System.out.println(s.minCost(arr));
        //System.out.println(s.findLongestChain(arr));
        //System.out.println(s.countBits(5));
        //System.out.println(s.integerBreak(3));
        //System.out.println(s.deleteAndEarn(nums));
        //System.out.println(s.findLength(a,b));

        int []dp=new int[nums.length+1];
        for(int i=0;i<dp.length;i++)dp[i]=-1;
        //System.out.println(s.combinationSum4(nums,4,dp));
        String st="abc";
        //System.out.println(st.substring(1,st.length()));
        //System.out.println(s.countSubstrings("abc"));
        int []pre=new int[]{2,1,4,3,5};
        int []ino=new int[]{1,4,2,5,3};
        int []pos=new int[]{4,1,5,3,2};

        //System.out.println(s.inorderTraversal(s.buildTree(pre,ino)));
        int []prce=new int[]{1,2,4,3,2,5,7,2,6,9,0};
        int [][]mat=new int[][]{
                { 1, 2, 3 },
                { 4, 5, 6 },
                { 7, 8, 9 }
        };
        int []longarr =new int[]{10,9,2,5,3,7,101,19,11};
        //System.out.println(s.longestIncSub(longarr));
        //System.out.println(s.inorderTraversal(s.buildTree(ino,pos)));
        //ListNode head=new ListNode(2);head.next=new ListNode(1);head.next.next=new ListNode(5);head.next.next.next=new ListNode(3);
        //s.printLL(s.sortList(head));
        List<String> li=new ArrayList<>();
        li.add("12:12");li.add("00:13");//li.add("06:02");li.add("21:00");
        //System.out.println(s.findMinDifference(li));
        int [][]matrix=new int[][]{
                {1,   4,  7, 11, 15},
                {2,   5,  8, 12, 19},
                {3,   6,  9, 16, 22},
                {10, 13, 14, 17, 24},
                {18, 21, 23, 26, 30}
        };
        //matrix=new int[][]{{1,1}};
        //System.out.println(s.searchMatrix(matrix,1));
        /*
        List<Integer> lir=new ArrayList<>();
        lir.add(1);
        lir.add(1,0);
        System.out.println(lir);
        lir.add(0,4);
        System.out.println(lir);
        lir.add(2,4);
        System.out.println(lir);
        */
        //System.out.println(s.frequencySort("tree"));
        //char []chrArr = new char[]{'A','A','A','B','B','B'};
        //System.out.println(s.leastInterval(chrArr,2));

        System.out.println(s.reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));

    }

    public int[][] reconstructQueue(int[][] people) {
        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0]==o1[0])return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        printArray(people);
        return people;

    }


        public int leastInterval(char[] tasks, int n) {

        Map<Character,Integer> mp = new HashMap<>();
        for(char c:tasks){
            mp.put(c,1+mp.getOrDefault(c,0));
        }

        PriorityQueue<Map.Entry<Character,Integer>> pq = new PriorityQueue<>(
                (a,b) -> a.getValue() != b.getValue()?b.getValue() - a.getValue(): a.getKey() - b.getKey()
        );

        pq.addAll(mp.entrySet());
        int ret=0;
        while(!pq.isEmpty()) {
            List<Map.Entry<Character,Integer>> li = new ArrayList<>();
            int itr=n+1;
            System.out.println(pq+" - "+ret);

            while (itr>0&&!pq.isEmpty()){
                Map.Entry<Character,Integer> tmp = pq.poll();
                int val = tmp.getValue();
                    val--;
                    tmp.setValue(val);
                    li.add(tmp);
                ret++;
                itr--;
            }
            for(Map.Entry<Character,Integer> va:li){
                if(va.getValue()>0){
                pq.add(va);}
            }
            if(pq.isEmpty())break;
            ret+=itr;
        }
        return ret;
        }


    public boolean searchMatrix(int[][] matrix, int target) {
        int row=0,col=matrix[0].length-1;
        while(row>=0&&col<matrix[0].length&&row<matrix.length&&col>=0){
            int val=matrix[row][col];
            System.out.println(val+" -- "+row+" -- "+col);
            if(target>val){
                row++;
            }else if(target<val){
                col--;
            }else{
                return true;
            }
        }
        return false;
    }

    int b=0;
    public boolean PredictTheWinner(int []nums){
        int len=nums.length;
        boolean fora=true;
        return fora;
    }
    public int preHelp(int []nums,int i,int j,boolean fora){
        return 1;
    }

    public int leastBricks(List<List<Integer>> wall) {
        if(wall.size()==0)return 0;
        Map<Integer,Integer> mp=new HashMap<>();

        for(List<Integer> li:wall){
            int rp=0;
            for(int i:li){
                rp+=i;
                mp.put(rp,mp.getOrDefault(rp,0)+1);
            }
        }
        System.out.println(mp);

        int max=0;
        for( Map.Entry<Integer, Integer> ret :mp.entrySet()){
            max = (ret.getValue()>max)?ret.getValue():max;
        }
        return wall.size() - max;
    }


    public void printLL(ListNode head){
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public ListNode sortList(ListNode head) {
        if(head==null||head.next==null)return head;
        ListNode prev=null,slw=head,fast=head;

        while (fast!=null&&fast.next!=null){
            prev=slw;
            slw=slw.next;
            fast=fast.next.next;
        }
        prev.next=null;
        ListNode l2=sortList(slw);
        ListNode l1=sortList(head);

        return mergeTwoLists(l1,l2);

    }

    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        if(l1==null)return l2;
        if(l2==null)return l1;
        if(l1.val>l2.val){
            l2.next=mergeTwoLists(l1,l2.next);
            return l2;
        }else {
            l1.next=mergeTwoLists(l1.next,l2);
            return l1;
        }
    }
    public int findMinDifference(List<String> timePoints) {
        int ret=Integer.MAX_VALUE;
        Collections.sort(timePoints);
        String s = timePoints.get(0);
        for(int i=1;i<timePoints.size();i++) {
            String nw=timePoints.get(i);
            String []starr=s.split(":");
            String []nwarr=nw.split(":");
            int diff=Integer.parseInt(nwarr[0])-Integer.parseInt(starr[0]);
            int min=Integer.parseInt(nwarr[1])-Integer.parseInt(starr[1]);
            diff=diff*60;
            diff+=min;
            ret=Math.min(diff,ret);
            s=nw;
        }
        System.out.println(ret+" "+s);
        String []starr=s.split(":");
        String []nwarr=new String[]{"24","00"};
        int diff=Integer.parseInt(nwarr[0])-Integer.parseInt(starr[0]);
        int min=Integer.parseInt(nwarr[1])-Integer.parseInt(starr[1]);
        diff=diff*60;
        diff+=min;


        ret=Math.min(diff,ret);

        return ret;
    }

    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        Stack<Integer> st1=new Stack<>();
        Stack<Integer> st2=new Stack<>();

        while(l1.next!=null){
            st1.push(l1.val);
            l1=l1.next;
        }
        while(l2.next!=null){
            st2.push(l2.val);
            l2=l2.next;
        }
        Stack<Integer> res=new Stack<>();
        while(!st1.isEmpty()&&!st2.isEmpty()){
            res.push(st1.pop()+st2.pop());
        }
        if(st1.isEmpty()){
            while(!st2.isEmpty()){
                res.push(st2.pop());
            }
        }
        if(st2.isEmpty()){
            while(!st1.isEmpty()){
                res.push(st1.pop());
            }
        }
        ListNode li=new ListNode(3);
        while(!res.isEmpty()){
            System.out.println(res.pop());
        }
        return li;
    }

    public int longestIncSub(int []t){
        int []x=t;
        Arrays.sort(t);

        return longIncHel(x,t,0,0);

    }
    public int longIncHel(int []x,int []t,int i,int j){
        if(i==x.length)return 0;
        if(j==t.length)return 0;
        if(x[i]==t[j]){
            return 1+longIncHel(x,t,i+1,j+1);
        }else {
            return Math.max(longIncHel(x,t,i,j+1),longIncHel(x,t,i+1,j));
        }
    }

    public int maxProfit(int[] prices){
        int len=prices.length;
        int [][]dp=new int[len][len];

        return maxProfitHelper(prices,0,1)+maxProfitHelper(prices,2,prices.length-1);


    }
    public int maxProfitHelper(int []prices,int i,int j){
        if(j<=i)return 0;
        return 1;
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<Integer>();

        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode cur = root;

        while(cur!=null || !stack.empty()){
            while(cur!=null){
                stack.add(cur);
                cur = cur.left;
            }
            cur = stack.pop();
            list.add(cur.val);
            cur = cur.right;
        }

        return list;
    }

    public TreeNode buildTree(int[] inorder, int[] postorder) {
        if(postorder.length==0||inorder.length==0)return null;
        int root=postorder[postorder.length-1];
        TreeNode nd=new TreeNode(root);
        int i;
        for(i=0;i<inorder.length;i++){if(inorder[i]==root)break;}

        if(i!=0){
            nd.left=buildTree(Arrays.copyOfRange(inorder,0,i),Arrays.copyOfRange(postorder,0,i));
        }else{
            nd.left=null;
        }

        if(i!=inorder.length-1){
            nd.right=buildTree(Arrays.copyOfRange(inorder,i+1,inorder.length),Arrays.copyOfRange(postorder,i,postorder.length-1));
        }else{
            nd.right=null;
        }

        return nd;
    }

    public boolean isSameTree(TreeNode p, TreeNode q) {
       if(p==null&&q!=null)return false;
       if(q==null&&p!=null)return false;
       if(p==null&&q==null)return true;

       if(p.val==q.val){
           return isSameTree(p.left,q.left)&&isSameTree(p.right,q.right);
       }else{
           return false;
       }
    }

    public int countSubstrings(String st){
        return  palHelper(st);
    }
HashSet<String> s;
    public int palHelper(String st){
        //System.out.println(st);
        if(!s.contains(st)){

        }
        int n=0;
        if(st.length()==1)return 1;
        if(st.charAt(0)==st.charAt(st.length()-1)){
            n = 1 + palHelper(st.substring(1,st.length()-1));
            return n + palHelper(st.substring(0,st.length()-1))+palHelper(st.substring(1,st.length()));
        }else{
            return palHelper(st.substring(0,st.length()-1))+palHelper(st.substring(1,st.length()));
        }
    }

    public int combinationSum4(int[] nums, int target,int []dp) {
        if(target==0)return 1;
        int cnt=0;
        for(int i=0;i<nums.length;i++){
            if(target-nums[i]>=0){
                //System.out.println(target-nums[i]);
                if(dp[target-nums[i]]==-1){
                    dp[target-nums[i]]=combinationSum4(nums,target-nums[i],dp);
                }
                cnt+=dp[target-nums[i]];
            }
        }
        return cnt;
    }


    public int findLength(int[] A, int[] B) {
        int max=0;
        if(A[0]==B[0]){
            max=1+findLenHelper(A,B,1,1);
        }else{
            max=Math.max(findLenHelper(A,B,0,1),findLenHelper(A,B,1,0));
        }
        return max;
    }

    public int findLenHelper(int [] A, int [] B,int ia,int ib){
        if(ia>=A.length||ib>=B.length)return 0;
        int max=0;
        if(A[ia]==B[ib]){
            max=1+findLenHelper(A,B,ia+1,ib+1);
        }else{
            max=Math.max(findLenHelper(A,B,ia,ib+1),findLenHelper(A,B,ia+1,ib));
        }
        return max;
    }

    public int deleteAndEarn(int[] nums) {
        return 4;
    }

    public int[] countBits(int num) {
        int []ret=new int[num];
        ret[0]=0;ret[1]=1;ret[2]=1;ret[3]=2;
        if(num>4){

        }
        return ret;
    }

    public int integerBreak(int n) {
        return 1;
    }
    //        int [][] arr=new int[][]{{1,2},{2,4},{2,3},{4,5},{6,7},{7,8}};

    int cnt;

    public int findLongestChain(int[][] pairs) {
        if(pairs.length==0)return 0;
        Arrays.sort(pairs, (a,b)->a[1]-b[1]);
        int []elm=pairs[0];
        //printArray(pairs);
        int cnt=1;
        //System.out.println(elm[0]+" - "+elm[1]);
        for(int i=1;i<pairs.length;i++){
            if(elm[1]<pairs[i][0]){
                //System.out.println(pairs[i][0]+" - "+pairs[i][1]);
                cnt++;
                elm=pairs[i];
            }
        }
        return cnt;
    }


    public int coinChange(int[] coins, int amount) {
        //Arrays.sort(coins);
        int ret=Integer.MAX_VALUE;
        for(int i=0;i<coins.length;i++){
            ret=Math.min(1+coinChangHelp(coins,amount-coins[i]),ret);
        }
        return (ret<0)?-1:ret;
    }

    public int coinChangHelp(int [] coins,int blnce){
        if(blnce==0)return 0;
        if(blnce<0){return Integer.MIN_VALUE;}
        int ret=Integer.MAX_VALUE;
        for(int i=coins.length-1;i>=0;i--){
            ret=Math.min(1+coinChangHelp(coins,blnce-coins[i]),ret);
        }
        return ret;
    }

    // {20,18,4},{9,9,10}
    public int minCost(int[][] costs) {
        int len=costs.length;
        if(len==0)return 0;
        return Math.min(Math.min((costs[0][1]+minCostHelper(costs,1,1)),(costs[0][2]+minCostHelper(costs,1,2))),
                (costs[0][0]+minCostHelper(costs,1,0)));
    }

    public int minCostHelper(int [][] costs,int i,int clr){
        int len =costs.length;
        if(i >= len)return 0;
        int ret = 0;
        if(clr==0){
            ret = Math.min((costs[i][1]+minCostHelper(costs,i+1,1)),(costs[i][2]+minCostHelper(costs,i+1,2)));
        }else if(clr==1){
            ret = Math.min((costs[i][0]+minCostHelper(costs,i+1,0)),(costs[i][2]+minCostHelper(costs,i+1,2)));
        }else {
            ret = Math.min((costs[i][0]+minCostHelper(costs,i+1,0)),(costs[i][1]+minCostHelper(costs,i+1,1)));
        }
        System.out.println(i+" - - "+ret);
        return ret;
    }


    public String frequencySort(String s,int n) {
        HashMap<Character,Integer> mp =new HashMap<>();char c;
        for(int i=0;i<s.length();i++){
            c=s.charAt(i);
            mp.put(c,mp.getOrDefault(c,0)+1);
        }

        System.out.println(mp);

        int max=Integer.MIN_VALUE;
        for(int val:mp.values()){
            System.out.println(val);
            max=Math.max(max,val);
        }
        char []arr=new char[max+1];
        for(int j=0;j<max;j++)arr[j]='0';
        for(Map.Entry<Character, Integer> ret:mp.entrySet()){
            if(ret.getValue()==max){
                arr[ret.getValue()]=ret.getKey();
            }
        }

        StringBuilder st=new StringBuilder();int j=0;
        for(int i=arr.length-1;i>-1;i--){
            if(arr[i]!='0'){
                j=i;
                while(j>-1){
                    st.append(arr[i]);
                    j--;
                }
            }
        }

        return st.toString();
    }

    public List<Integer> topKFrequent(int[] nums, int k) {
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i:nums){
            mp.put(i,1+mp.getOrDefault(i,0));
        }
        List<Integer> ret=new ArrayList<>();
        List<Integer> mfs=new ArrayList<>();
        for(int mf:mp.values()){
            mfs.add(mf);
        }
        Collections.sort(mfs);
        int sz=Math.abs(mfs.size()-k);

        for(int lo=0;lo<sz;lo++){
            mfs.remove(0);
        }

        System.out.println(mfs);

        for(Map.Entry<Integer, Integer> l:mp.entrySet()){
                if(mfs.contains(l.getValue())){
                    ret.add(l.getKey());
                }
        }
        return ret;
    }

    public ListNode[] splitListToParts(ListNode root, int k) {
        ListNode nd=root;int cntr=0;
        ListNode[] ret=new ListNode[k];
        while (nd.next!=null){
            nd=nd.next;cntr++;
        }
        int frc=cntr/k;
        for(int i=0;i<k;i++){

        }
        return ret;
    }

    public int totalHammingDistance(int[] nums) {
        int ret=0;
        for(int i=0;i<nums.length;i++){
            for(int j=i+1;j<nums.length;j++){
                ret+=hammingDistance(nums[i],nums[j]);
            }
        }
        return ret;
    }
    public int hammingDistance(int x,int y){
        int n=x^y;
        int count = 0;
        while (n > 0)
        {
            count += n & 1;
            n >>= 1;
        }
        return count;
    }

    public void printArray(int []nums){
        for(int i=0;i<nums.length;i++){
            System.out.print(nums[i]+" , ");
        }System.out.println();
    }
    public void printArray(char []chars){
        for(int i=0;i<chars.length;i++){
            System.out.print(chars[i]+" , ");
        }System.out.println();
    }

    public void printArray(int [][]chars){
        for(int i=0;i<chars.length;i++) {System.out.println();
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]+" , ");
            }
        }System.out.println();
    }

    public void printArray(char [][]chars){
        for(int i=0;i<chars.length;i++) {System.out.println();
            for (int j = 0; j < chars[i].length; j++) {
                System.out.print(chars[i][j]+" , ");
            }
        }System.out.println();
    }






}
