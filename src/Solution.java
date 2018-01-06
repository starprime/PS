import java.util.*;

public class Solution {

    public static void main(String []args){
        Solution s=new Solution();
        //System.out.print(s.lengthOfLastWord("Note: is Run Code inconsistent with Submit Solution? If you are using global variables or C/C++, check this out."));
        //System.out.println(s.lengthOfLastWord("   "));
        //System.out.println(s.numDecodings("418913"));
        List<List<Integer>> li=new ArrayList<>();
        List<Integer> lo=new ArrayList<>();
        //lo.add(-1);li.add(lo);
        //lo=new ArrayList<>();lo.add(-2);lo.add(-3);li.add(lo);
        //lo=new ArrayList<>();lo.add(-3);lo.add(1);lo.add(-1);li.add(lo);
//    [-1]
//   [3,2]
// [-3,1,-1]

        //System.out.println(li);
        //System.out.println(s.minimumTotal(li));
        //System.out.println(s.pivotIndex(new int[]{1, 7, 3, 6, 5, 6}));

        //System.out.println(s.removeDuplicates(new int[]{1, 2,2,3,4,5,5,6}));
        //int[] nums=new int[]{1,1,2};
        //s.removeDuplicates(nums);
        //System.out.println("pwo "+s.myPow(3,2));
        //System.out.println(s.numberOfBoomerangs(new int[][]{{0,0},{1,0},{-1,0},{0,1},{0,-1}}));
        //System.out.println(s.triangleNumber(new int[]{1,2,3,4,5,6}));
        //System.out.println(s.triangleNumber2(new int[]{1,2,3,4,5,6}));
        //System.out.println(s.uniquePaths(23,12));
        //lo.add(1);lo.add(2);lo.add(3);lo.add(4);lo.add(5);
        //System.out.println(s.findClosestElements(lo,4,-1));
        //int []arr=new int[]{ 10, 20, 80, 100, 200, 400, 500, 3, 2, 1};
        //System.out.println(s.UniModMax(arr,0,arr.length-1));
        //int []arr=new int[]{ 4,3,2,7,8,2,3,1};
        //System.out.println(s.findDuplicates(arr));
        int []arr=new int[]{ 1,2,1};
        //System.out.println(s.subsets(arr));
        //System.out.println(s.reconstructQueue(new int[][]{{7,0}, {4,4}, {7,1}, {5,0}, {6,1}, {5,2}}));

        //System.out.println(s.isAnagram("cat","rat"));
        //System.out.println(s.permuteUnique(arr));
        //System.out.println(s.longestPalindrome("abca"));
        //System.out.println(s.reverseWords("ds asasds jdsfd"));
        //System.out.println(s.countBinarySubstrings("00110011"));
        System.out.println(s.canConstruct("aaa", "aab"));

    }
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> res=new ArrayList<>();
        Arrays.sort(nums);
        subSetHelp(res,new ArrayList<Integer>(),0,nums);
        return res;
    }

    public void subSetHelp(List<List<Integer>> res,List<Integer> e,int lo,int []nums){
        if(e.size()==nums.length){
        res.add(new ArrayList<>(e));}
        for(int i=lo;i<nums.length;i++){
            if(i>lo&&nums[i]==nums[i-1])continue;
            e.add(nums[i]);
            subSetHelp(res,e,i+1,nums);
            if(e.size()>0)e.remove(e.size()-1);
        }
    }

    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> res = new ArrayList<>();
        for (int i = 0; i < nums.length; ++i) {
            int index = Math.abs(nums[i])-1;
            if (nums[index] < 0)
                res.add(Math.abs(index+1));
            nums[index] = -nums[index];
        }
        return res;
    }
    public int UniModMax(int []arr,int lo,int hi){
        if(lo==hi)return arr[lo];
        int mid=(lo+hi)/2;

        if(lo+1==hi){
            return (arr[lo]>arr[hi])?arr[lo]:arr[hi];
        }

        if(arr[mid]>arr[mid-1]&&arr[mid]>arr[mid+1]){
            return arr[mid];
        }
        if(arr[mid]<arr[mid+1]&&arr[mid]>arr[mid-1]){
            return UniModMax(arr,mid+1,hi);
        }else {
            return UniModMax(arr,lo,mid-1);
        }
    }


    public List<Integer> findClosestElements(List<Integer> arr, int k, int x) {
        List<Integer> res=new ArrayList();
        int ind=arr.indexOf(x);
        int i=Math.max(0,ind-1);
        int j=Math.min(ind+1,arr.size());
        res.add(x);
        while(k>res.size()&&j<arr.size()&&i>=0){
            System.out.println(i+"-"+j+"-"+ind);
            if(Math.abs(arr.get(ind)-arr.get(i))<=Math.abs(arr.get(ind)-arr.get(j))){
                res.add(arr.get(i));i--;
            }else{
                res.add(arr.get(j));j++;
            }
        }Collections.sort(res);
        return res;
    }

    public int triangleNumber(int[] nums) {
        Arrays.sort(nums);
        //a+b>c
        int j,k,ret=0;
        for(int i=0;i<nums.length;i++){
            int a=nums[i];
            j=i+1;k=i+2;
            while (k<nums.length){
                if(k==j){k++;continue;}
                if(nums[k]<nums[j]+a){
                    System.out.println(a+" - "+nums[j]+" - "+nums[k]);
                    ret++;
                    j++;
                    k++;
                }else{
                    j++;
                }
            }
        }
        return ret;
    }

    public int uniquePaths(int m, int n) {
        int [][]dp=new int[m+1][n+1];
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                dp[i][j]=0;
            }
        }
        return uniquePathshelper(m,n,dp);

    }

    public int uniquePathshelper(int m, int n,int [][]dp) {
        if(m==1)return 1;
        if(n==1)return 1;
        if(dp[m-1][n]==0)dp[m-1][n]=uniquePathshelper(m-1,n,dp);
        if(dp[m][n-1]==0)dp[m][n-1]=uniquePathshelper(m,n-1,dp);
        return dp[m-1][n]+dp[m][n-1];
    }


    public int triangleNumber2(int[] nums) {
        Arrays.sort(nums);
        //a+b>c
        int j,k,ret=0;
        for(int i=2;i<nums.length;i++){
            int c=nums[i];
            j=0;k=i-1;
            while (k>j){
                int a=nums[j];
                int b=nums[k];
                if(c<b+a){
                    System.out.println(a+" - "+b+" - "+c+" --> "+(k-j));
                    ret+=k-j;
                    k--;
                }else{
                    j++;
                }
            }
        }
        return ret;
    }

    public int numberOfBoomerangs(int[][] points) {
        int ret=0;int dist;
        int []iit;
        int []jit;
        Map<Integer,Integer> mp=new HashMap<>();
        for(int i=0;i<points.length;i++){
            iit=points[i];
            for(int j=0;j<points.length;j++){
                if(i==j)continue;;
                dist=0;
                jit=points[j];
                if(iit[0]==jit[0]&&iit[1]==jit[1]){continue;}
                dist=getDist(iit,jit);
                mp.put(dist,mp.getOrDefault(dist,0)+1);
            }
            System.out.println(mp);
            for(int val:mp.values()){
                ret+=val*(val-1);
            }
            mp.clear();
        }
        return ret;
    }

    public int getDist(int []i,int []j){
        int dist;
        int id=Math.abs(i[0]-j[0]);
        int jd=Math.abs(i[1]-j[1]);
        id=id*id;
        jd=jd*jd;
        dist=id+jd;
        return dist;
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

    public int[][] reconstructQueue(int[][] people) {
        if( people==null || people.length==0 || people[0].length==0 ){
            return new int[0][0];
        }

        Arrays.sort(people, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if(o2[0]==o1[0])return o1[1]-o2[1];
                return o2[0]-o1[0];
            }
        });
        int n=people.length;
        ArrayList<int[]> li=new ArrayList<>();

        for(int i=0;i<n;i++){
            li.add(people[i][1],new int[]{people[i][0],people[i][1]});
        }

        int[][] ret=new int[people.length][2];
        int i=0;
        for(int k[]:li){
            ret[i][0]=k[0];
            ret[i][1]=k[1];
            i++;
        }
        return ret;
    }

    int sum=0;
    HashSet<Integer> st=new HashSet<>();
    public int getImportance(List<Employee> employees, int id) {


        employees.forEach(employee -> {if(employee.id==id){
            sum+=employee.importance;
            List<Integer> li=employee.subordinates;
            for(int l : li){
                getImportanceHelper(employees,l);
            }
        }
        });
        return sum;
    }

    public void getImportanceHelper(List<Employee> employees, int id){
        if(!st.contains(id)){
            employees.forEach(employee -> {if(employee.id==id){
                st.add(id);
                sum+=employee.importance;
                List<Integer> li=employee.subordinates;
                for(int l : li){
                    getImportanceHelper(employees,l);
                }
            }
            });
        }
    }

    class Employee {

        public int id;

        public int importance;

        public List<Integer> subordinates;
    }

    public List<List<Integer>> permuteUnique(int[] nums) {
        List<List<Integer>> li=new ArrayList<>();
        Arrays.sort(nums);
        backTrack(li,new ArrayList<Integer>(),nums,new boolean[nums.length]);
        return li;
    }

    public void backTrack(List<List<Integer>> li,List<Integer> temp,int []nums,boolean [] used){

        if(temp.size()==nums.length){
            li.add(new ArrayList<>(temp));
        }
        else {
            for (int i = 0; i < nums.length; i++) {
                if (used[i]) continue;
                temp.add(nums[i]);
                backTrack(li, temp, nums, used);
                temp.remove(temp.size() - 1);
            }
        }

    }

    int max=0,lo=0;String ret;

    public String longestPalindrome(String s) {
        int  len = s.length();
        if(len<2)return s;
        for(int i=0;i<len-1;i++){
            palindromeHelper(s,i,i+1);
            palindromeHelper(s,i,i);
        }

        return s.substring(lo,max+lo);
    }

    public void palindromeHelper(String s,int x,int y){
        while(x>=0 && y<s.length() && s.charAt(x)==s.charAt(y)){
            x--;
            y++;
        }
        if(y-x-1>max){
            max=y-x-1;
            lo=x+1;
        }
    }

    int ntMaCnt=0;

    public boolean validPalindrome(String s) {
        int len =s.length();
        if(len<2)return true;

        for(int i=0;i<len/2;i++){
            return validPalindromeHelper(s,i,len-i)||validPalindromeHelper(s,i+1,len-i+1);
        }
        return true;
    }
    public boolean validPalindromeHelper(String s,int i,int j){
        return true;
    }

    public String reverseWords(String s) {
        int len=s.length();
        Stack<String> stc=new Stack<String>();
        StringBuilder sb = new StringBuilder(len);
        for(int i=len-1;i>=0;i--){
            sb.append(s.charAt(i));
        }
        String str=sb.toString();
        String []at=str.split(" ");
        for(String st:at){
            stc.push(st);
        }
        System.out.println(stc);

        StringBuilder ret=new StringBuilder(len);

        while(!stc.empty()){
            ret.append(stc.pop());
            ret.append(" ");
        }
        String re= ret.toString();
        return re.substring(0,re.length()-1);
    }

    int noi=0;
    public int islandPerimeter(int[][] grid) {
        if(grid.length==0)return 0;
        int m=grid.length;
        int n=grid[0].length;
        for(int i=0;i<m;i++){
            for(int j=0;j<n;j++){
                if(grid[i][j]==1){
                    islnadBFS(grid,i,j);
                }
            }
        }
        return noi;

    }

    public void islnadBFS(int [][] grid,int i,int j){
        if(i<0||j<0)return;
        if(i>=grid.length||j>=grid[0].length)return;
        if(grid[i][j]==0)return;
        int lo=4;
    }

    public int countBinarySubstrings(String s) {
        int len=s.length();
        int cnt=0,ret=0;
        for(int i=1;i<len;i++){
            if(s.charAt(i)!=s.charAt(i-1)){
                ret+=Math.abs(cnt);
                cnt=0;
            }

                if(s.charAt(i)=='0'){
                    cnt--;
                }
                if(s.charAt(i)=='1'){
                    cnt++;
                }


        }
        return ret;
    }
    public boolean canConstruct(String ransomNote, String magazine) {
        int []arr=new int[26];

        for(int i=0;i<magazine.length();i++){
            arr[magazine.charAt(i)-'a']++;
        }

        for(int i=0;i<ransomNote.length();i++){
            arr[ransomNote.charAt(i)-'a']--;
        }

        for(int i=0;i<26;i++){
            if(arr[i]<0)return false;
        }
        return true;
    }

}