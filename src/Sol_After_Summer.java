import java.util.*;

/**
 * Created by star on 8/10/18.
 */
public class Sol_After_Summer {
    public static class Interval {
        int start;
        int end;
        Interval() { start = -1; end = -1; }
        Interval(int s, int e) { start = s; end = e; }
     }
    public static void main(String []args){
        Sol_After_Summer s = new Sol_After_Summer();
//        List<String> li = new ArrayList<>();
//        String [] st = {"hot","dot","dog","lot","log","cog"};
//        for(String str : st){
//            li.add(str);
//        }
//        System.out.println(s.ladderLength("hit","cog",li));
        //int [] nums = {3,2,3,1,2,4,5,5,6};
        //System.out.println(s.findKthLargest(nums,4));
//        List<Interval> intervals = new ArrayList<>();
//        intervals.add(new Interval(2,3));
//        intervals.add(new Interval(4,5));
//        intervals.add(new Interval(6,7));
//        intervals.add(new Interval(8,9));
//        intervals.add(new Interval(1,10));

        //System.out.println(s.merge2(intervals));
//        int [][] nums = {{7,10},{2,4}};
//        Interval [] intervals = new Interval[nums.length];
//        int i = 0;
//        for(int [] val:nums){
//            intervals[i++] = new Interval(val[0],val[1]);
//        }
//
//        System.out.println(s.canAttendMeetings(intervals));
          String strn = new String("ababcbacadefegdehijhklij");
        //System.out.println(s.partitionLabels(strn));
        //int [] arr = {-2,-1,0,3,6,7,8,8,8};
        //             0, 1,2,3,4,5,6,7,8
        //System.out.print(indexEqualsValueSearch(arr));
        System.out.println(s.isIsomorphic("aaa".toString(),"aab".toString()));
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        char [] sfill = new char[256];

        //for (int i = 0; i<sfill.length;i++)sfill[i] = '-';

        for(int i = 0;i<s.length();i++){
            char sc = s.charAt(i);
            char tc = t.charAt(i);
            System.out.println(sfill[tc]);
            if(sfill[tc]==0){
                sfill[tc] = sc;
            }else {
                if(sfill[tc] != sc)return false;
            }
        }
        return true;
    }

    static int indexEqualsValueSearch(int[] arr){

        int len = arr.length;
        int l = 0, r = len;
        int mid;
        int soFar = Integer.MAX_VALUE;

        while(l<=r){
            mid = l+(r - l)/2;
            if(mid==arr[mid]){
                soFar = Math.min(mid,soFar);
                r = mid - 1;
                l = 0;
            }else if(mid<arr[mid]){
                r = mid - 1;
            }else if(mid>arr[mid]){
                l = mid + 1;
            }
        }

        return (soFar==Integer.MAX_VALUE)?-1:soFar;

    }



    public List<Integer> partitionLabels(String S) {
        int [] start = new int[26];
        java.util.Arrays.fill(start,-1);
        int [] end = new int[26];
        java.util.Arrays.fill(end,-1);

        for(int i = 0;i<S.length();i++){
            end[S.charAt(i) - 'a'] = i;
        }

        for(int i = S.length()-1;i>=0;i--){
            start[S.charAt(i) - 'a'] = i;
        }

        List<List<Integer>> li = new ArrayList<>();

        int sp = start[0];
        int ep = end[0];

        return new ArrayList<>();
    }

    public boolean canAttendMeetings(Interval[] intervals) {

        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                return ((i1.start!=i2.start)?i1.start-i2.start:i1.end-i2.end);
            }
        });
        for(Interval il:intervals){
            System.out.println(il.start+" -- "+il.end);
        }

        for(int i = 1;i<intervals.length;i++){
            Interval curr = intervals[i - 1];
            Interval nxt = intervals[i];
            if(curr.end>nxt.start){
                return false;
            }
        }
        return true;
    }

    public List<Interval> merge2(List<Interval> intervals) {
        if(intervals.size()<=1)return intervals;
        int[] s = new int[intervals.size()];
        int[] e = new int[intervals.size()];
        int j = 0;

        for(Interval interval:intervals){
            s[j] = interval.start;
            e[j++] = interval.end;
        }

        Arrays.sort(s);
        Arrays.sort(e);

        List<Interval> res = new ArrayList<>();

        int strt = -1;
        int end = -1;
        // next item start is less than previous item end

        for(int i = 1;i<intervals.size();i++){
            if(s[i]<=e[i-1]){
                strt = (strt==-1)?s[i - 1]:strt;
                end = e[i];
            }else{
                strt = (strt==-1)?s[i - 1]:strt;
                end = (end==-1)?e[i - 1]:end;

                res.add(new Interval(strt,end));
                strt = -1;
                end = -1;

            }
        }

        // check for last instance
        if(e[e.length-2]>=s[s.length-1]){
            Interval in = (res.size()==1)?res.get(res.size()-1):new Interval(s[0],e[e.length-2]);
            if(res.size()>0)res.remove(res.size()-1);
            in.end = e[e.length-1];
            res.add(in);
        }else{
            res.add( new Interval(s[s.length-1],e[e.length-1]));
        }

        return res;

    }


    public List<Interval> merge(List<Interval> intervals) {
        if(intervals.size()<=1)return intervals;
        Collections.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval i1,Interval i2){
                return ((i1.start!=i2.start)?i1.start-i2.start:i1.end-i2.end);
            }
        });

        for(int i = 1;i<intervals.size();i++){
            if(intervals.get(i-1).end >= intervals.get(i).start && intervals.get(i-1).end <= intervals.get(i).end){
                intervals.get(i-1).end = intervals.get(i).end;
                intervals.remove(i);
                i--;
            }else if(intervals.get(i-1).end >= intervals.get(i).start && intervals.get(i-1).end >= intervals.get(i).end){
                intervals.remove(i);
                i--;
            }
        }
        return intervals;
    }

    Comparator<Interval> comp = new Comparator<Interval>(){
        @Override
        public int compare(Interval i1,Interval i2){
            return ((i1.start!=i2.start)?i1.start-i2.start:i1.end-i2.end);
        }
    };

    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> qu = new PriorityQueue<>();
        for(int n:nums){
            qu.add(n);
        }
        int n = nums.length - k;
        while (n>0){
            qu.poll();
            n--;
        }
        return qu.poll();
    }
        public int ladderLength(String beginWord, String endWord, List<String> wordList) {
        if(!wordList.contains(endWord)||(beginWord.length()!=endWord.length())){
            return 0;
        }
        Set<Character> chrs = new HashSet();
        for(String s:wordList){
            for(char c:s.toCharArray()){
                chrs.add(c);
            }
        }
        Set<String> visited = new HashSet();
        LinkedList<String> qu = new LinkedList<>();
        qu.add(beginWord);
        int ret = 0;
        while(qu.size()>0){
            int sz = qu.size();
            while(sz>0){
                ret++;
                String wrd = qu.poll();
                visited.add(wrd);
                StringBuilder nm;
                for(int j=0;j<wrd.length();j++){
                    nm = new StringBuilder(wrd);
                    for(char c:chrs){
                        nm.setCharAt(j,c);
                        String st = nm.toString();
                        if(st.equals(endWord))break;
                        if(wordList.contains(st)&&!visited.contains(st)){
                            qu.add(st);
                        }
                    }

                }

            }
        }
        return ret;
    }

}
