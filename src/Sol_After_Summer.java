import LeetCodeDesign.MyCircularQueue;

import java.lang.reflect.Array;
import java.util.*;
import java.util.stream.Collectors;

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
//        List<String> li = new numsayList<>();
//        String [] st = {"hot","dot","dog","lot","log","cog"};
//        for(String str : st){
//            li.add(str);
//        }
//        System.out.println(s.ladderLength("hit","cog",li));
        //int [] nums = {3,2,3,1,2,4,5,5,6};
        //System.out.println(s.findKthLargest(nums,4));
//        List<Interval> intervals = new numsayList<>();
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
        //int [] nums = {-2,-1,0,3,6,7,8,8,8};
        //             0, 1,2,3,4,5,6,7,8
        //System.out.print(indexEqualsValueSearch(nums));
        // System.out.println(s.isIsomorphic("aaa".toString(),"aab".toString()));
        int[] nums = {0,0,1,2,3,3,4,7,7,8};
                    //0,1,2,3,4,5,6,7,8
        //System.out.println(shiftednumsSearch(nums,2));

        int[] duplicate = {1, 6, 5, 2, 4, 2, 3};

        //System.out.println(findDuplicate(duplicate));
        //System.out.println(root(7,3));
        //System.out.println(s.combinationSum(nums,7));
        //System.out.println(s.letterCombinationsBFS2("235"));
        //System.out.println(s.findClosestElements(nums,3,5));
        //String str = "aedbdeddac";
        //System.out.println(s.partitionLabels(str));
        //System.out.println(s.generateParenthesis(3));
        //String [] wordList = new String[]{"hot","dot","dog","lot","log","cog"};
        //List<String> li = new ArrayList<>();li.add("hot");li.add("dot");li.add("dog");li.add("lot");li.add("log");li.add("cog");
        //System.out.println(s.ladderLength("hit","dot",li));
//
//        int [][] arr = {{1, 10}, {2, 7}, {3, 19}, {8, 12}, {10, 20}, {11, 30}};
//        Interval [] intervals = new Interval[arr.length];
//
//        for(int i=0; i < intervals.length;i++){
//            intervals[i] = new Interval(arr[i][0],arr[i][1]);
//        }
//        System.out.println(s.minMeetingRooms(intervals));

        //System.out.println(s.reorganizeString("aaab"));
        List<Integer> pid = new ArrayList<>();pid.add(1);pid.add(3);pid.add(10);pid.add(5);
        List<Integer> ppid = new ArrayList<>();ppid.add(3);ppid.add(0);ppid.add(5);ppid.add(3);
        //System.out.println(s.killProcess(pid,ppid,5));

//        MyCircularQueue queue = new MyCircularQueue(3);
//        queue.enQueue(6);
//        System.out.println(queue.Rear());
//        System.out.println(queue.deQueue());

//        List<Integer> room = new ArrayList<>();
//        room.add(1);room.add(3);
//
//        List<List<Integer>> rooms = new ArrayList<>();
//
//        System.out.println(rooms.size());
//        rooms.add(room);room.clear();
//        System.out.println(rooms.size());
//        room.add(3);room.add(0);room.add(1);
//        rooms.add(room);room.clear();
//        System.out.println(rooms.size());
//        room.add(2);
//        rooms.add(room);room.clear();
//        System.out.println(rooms.size());
//        room.add(0);
//        rooms.add(room);room.clear();
//        System.out.println(rooms);
//        String [] words = {"2","1"};
//        //System.out.println(s.longestWord(words));
//        System.out.println(Arrays.toString(words));
//
//        Arrays.sort(words);
//        System.out.println(Arrays.toString(words));
        List<String> li = new ArrayList<>();
        List<List<String>> items  = new ArrayList<>();
        li.add("asd");
        li.add("1");
        li.add("3");
        items.add(li);
        li = new ArrayList<>();
        li.add("sew");
        li.add("4");
        li.add("3");
        items.add(li);
        li = new ArrayList<>();
        li.add("poasd");
        li.add("0");
        li.add("98327");
        items.add(li);
        li = new ArrayList<>();
        li.add("sumi");
        li.add("98374");
        li.add("232");
        items.add(li);
        li = new ArrayList<>();
        li.add("iru");
        li.add("253");
        li.add("64");
        items.add(li);
        System.out.println(items);
        System.out.println("aans "+fetchItemsToDisplay(items,1,0,2,0));
        // asd 1 3
        // seew 4 3
        // poasd 0 986273



        //System.out.println(s.canVisitAllRooms(rooms));
    }

    public static int deleteProducts(List<Integer> ids, int m) {
        // Write your code here
        HashMap<Integer, Integer> map = new HashMap<Integer, Integer>();
        for(int ele:ids){
            map.put(ele, map.getOrDefault(ele,0)+1);
        }
        List<Map.Entry<Integer, Integer>> list = new LinkedList<Map.Entry<Integer, Integer>>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<Integer, Integer> >() {
            public int compare(Map.Entry<Integer, Integer> o1,
                               Map.Entry<Integer, Integer> o2)
            {
                return (o1.getValue()).compareTo(o2.getValue());
            }
        });
        for(Map.Entry<Integer, Integer> entry:list){
            System.out.println(entry.getKey()+" "+entry.getValue());
            if(m>=entry.getValue()){
                map.remove(entry.getKey());
                m = m- entry.getValue();
            }
            else{
                map.put(entry.getKey(), entry.getValue()-m);
                m = entry.getValue()-m;
            }
            if(m<1)
                break;
        }

        return map.size();

    }

    public static List<String> fetchItemsToDisplay(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {
        // Write your code here
        Map<String,String> map = new HashMap<>();

        for(List<String> li:items){
            map.put(li.get(0),li.get(sortParameter));
        }

        List<Map.Entry<String, String>> list = new LinkedList<Map.Entry<String, String>>(map.entrySet());

        if(sortOrder == 0){
            Collections.sort(list, new Comparator<Map.Entry<String, String> >() {
                public int compare(Map.Entry<String, String> o1,
                                   Map.Entry<String, String> o2)
                {
                    if(sortParameter == 0){
                        return (o1.getValue()).compareTo(o2.getValue());
                    }else{
                        return Integer.parseInt(o1.getValue()) - Integer.parseInt(o2.getValue());
                    }

                }
            });
        }else{
            Collections.sort(list, new Comparator<Map.Entry<String, String> >() {
                public int compare(Map.Entry<String, String> o1,
                                   Map.Entry<String, String> o2)
                {
                    if(sortParameter == 0){
                        return (o2.getValue()).compareTo(o1.getValue());
                    }else{
                        return Integer.parseInt(o2.getValue()) - Integer.parseInt(o1.getValue());
                    }
                }
            });
        }

        System.out.println(list);

        List<String> result = new ArrayList<>();
        int index = (itemPerPage * pageNumber);
        System.out.println(index);
        for(int i = index;i<index+itemPerPage  && i < list.size();i++){
            result.add(list.get(i).getKey());
        }

        return result;
    }

    public static void fetch(List<List<String>> items, int sortParameter, int sortOrder, int itemPerPage, int pageNumber) {
        Map<String, String> treemap ;

        if(sortOrder == 0)
            treemap = new TreeMap<String, String>();
        else
            treemap = new TreeMap<String, String>(Collections.reverseOrder());
        for(List<String> item : items)
        {
            treemap.put(item.get(sortParameter) , item.get(0));
        }
        Set set = treemap.entrySet();
        Iterator i = set.iterator();
        // Display elements
        int noOfPreviousPages =  pageNumber;
        int discard = noOfPreviousPages * itemPerPage;
        int count = 0;
        while(i.hasNext()) {
            Map.Entry me = (Map.Entry)i.next();
            count++;
            if(count <= discard)
                continue;
            if(count > discard + itemPerPage)
                break;
            System.out.println(me.getValue());
        }

    }


    class TrieNode{
        char c;
        boolean isEnd;
        TreeMap<Character,TrieNode> child = new TreeMap<>();
        public TrieNode(char c){
            this.c = c;
            this.isEnd = false;
        }
    }

    class Trie{
        TrieNode root;

        public Trie(){
            root = new TrieNode('0');
        }

        public void insert(String str){

            TrieNode tmp = root;
            int i;
            for(i = 0;i<str.length()-1;i++){
                char c = str.charAt(i);
                if(!tmp.child.containsKey(c)){
                    TrieNode nd = new TrieNode(c);
                    tmp.child.put(c,nd);
                    tmp = nd;
                }else{
                    tmp = tmp.child.get(c);
                }
            }
            char c = str.charAt(i);
            if(!tmp.child.containsKey(c)){
                TrieNode nw = new TrieNode(c);
                nw.isEnd = true;
                tmp.child.put(c,nw);
            }else{
                TrieNode old = tmp.child.get(c);
                old.isEnd = true;
            }

        }

        public String dfs(){
            int mxL = 0;
            Queue<TrieNode> qu = new LinkedList<>();
            qu.add(root);
            StringBuilder sb = new StringBuilder();

            String ret="";

            while (!qu.isEmpty()){
                sb.append(root.c);
                TrieNode tmp = qu.poll();

                Iterator<TrieNode> it = root.child.values().iterator();

                while (it.hasNext()){
                    TrieNode nd = it.next();
                    qu.add(nd);
                }

                if(sb.length()>mxL){
                    mxL = sb.length();
                    ret = sb.toString();
                }
                sb.deleteCharAt(sb.length()-1);
            }
            return ret;

        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for(String st:words){
            trie.insert(st);
        }

        return trie.dfs();
    }

    public boolean canVisitAllRooms(List<List<Integer>> rooms) {
        Set<Integer> visited = new HashSet<>();

        roomsCheck(rooms,visited,0);
        if(rooms.size() == visited.size())return true;
        else return false;
    }
    public void roomsCheck(List<List<Integer>> rooms,Set<Integer> visited,int room){
        if(rooms.size() == visited.size())return;
        List<Integer> canG = rooms.get(room);
        for(int i = 0;i<canG.size();i++){
            roomsCheck(rooms,visited,canG.get(i));
            if(rooms.size() == visited.size())return;
        }
        return;
    }

    class MultiChar{
        char c;
        int val;
        public MultiChar(char c,int val){
            this.c = c;
            this.val = val;
        }
    }
    public String reorganizeString(String S) {
        int [] arr = new int[26];

        for(char c:S.toCharArray()){
            arr[c-'a']++;
        }

        PriorityQueue<MultiChar> tmp = new PriorityQueue<>((a,b) -> (a.val==b.val)?a.c - b.c:b.val-a.val);

        for(int i=0;i<arr.length;i++){
            if(arr[i]!=0){
                if(arr[i]>(S.length() + 1)/2)return "";
                tmp.add(new MultiChar((char)(i+'a'),arr[i]));
            }
        }

        StringBuilder sb = new StringBuilder();

        while (tmp.size()>=2){
            MultiChar c = tmp.poll();
            MultiChar d = tmp.poll();

            sb.append(c.c);
            sb.append(d.c);

            if(--c.val>0)tmp.add(c);
            if(--d.val>0)tmp.add(d);

        }

        if(tmp.size()>0)sb.append(tmp.poll().c);

        return sb.toString();

    }
    public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
        List<Integer> li = new ArrayList<>();
        int indx = findIndex(ppid,kill);
        li.add(kill);

        while(indx!=-1) {
            int ch = pid.get(indx);
            List<Integer> chK = killProcess(pid, ppid, ch);

            for (int i = 0; i < chK.size(); i++) {
                li.add(chK.get(i));
            }
            ppid.remove(indx);
            ppid.add(indx, -1);
            indx = findIndex(ppid, kill);
        }

        return li;

    }


    public int findIndex(List<Integer> list,int val){
        for(int i  = 0;i<list.size();i++){
            if(list.get(i)==val){
                return i;
            }
        }
        return -1;
    }


    public int minMeetingRooms(Interval[] intervals) {
        Queue<Integer> qu = new PriorityQueue<Integer>(intervals.length, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o1 - o2;
            }
        });

        qu.offer(intervals[0].end);

        Arrays.sort(intervals,new Comparator<Interval>(){
            public int compare(Interval a,Interval b){
                return a.start - b.start;
            }
        });

        for(int i = 1;i<intervals.length;i++){
            if(qu.peek()<=intervals[i].start){
                qu.poll();
                qu.offer(intervals[i].end);
            }else{
                qu.offer(intervals[i].end);
            }
        }

        return qu.size();
    }

    public int kthSmallest(int[][] matrix, int k) {

        int rows = matrix.length;
        int cols = matrix[0].length;

        boolean [][]visited = new boolean[rows][cols];
        PriorityQueue<coordinate> qu = new PriorityQueue<>((a,b)->(a.val - b.val));
        qu.offer(new coordinate(0,0,matrix[0][0]));

        int cnt = 0;
        while (!qu.isEmpty()){

            coordinate cor = qu.poll();

            if(++cnt==k){
                return cor.val;
            }

            visited[cor.x][cor.y] = true;

            if(!(visited[cor.x+1][cor.y]) && (cor.x+1<rows)){
                qu.offer(new coordinate(cor.x+1,cor.y,matrix[cor.x+1][cor.y]));
            }

            if(!(visited[cor.x][cor.y+1]) && (cor.y+1<cols)){
                qu.offer(new coordinate(cor.x,cor.y+1,matrix[cor.x][cor.y+1]));
            }

        }
        throw null;
    }

    class coordinate{
        int x;
        int y;
        int val;
        public coordinate(int _x,int _y,int _val){
            x=_x;
            y=_y;
            val=_val;
        }
    }

    public int ladderLength(String begin,String end,List<String> li){

        Map<String,Set<String>> grph = new HashMap<>();
        for(int i =0;i<li.size();i++)grph.put(li.get(i),new HashSet<>());
        grph.put(begin,new HashSet<>());

        for(String node1:grph.keySet()){
            for(String node2:grph.keySet()){
                if(!check1Diff(node1,node2)||node1.equals(node2))continue;
                grph.get(node1).add(node2);
            }
        }
        //System.out.println(grph);

        Queue<String> queue = new LinkedList<>();
        queue.add(begin);
        int cntr;

        Map<String,Integer> dist = new HashMap<>();
        dist.put(begin,0);

        bfs(begin,grph,dist);

        return (dist.containsKey(end))?dist.get(end)+1:0;

    }
    public void bfs(String begin,Map<String,Set<String>> grph,Map<String,Integer> dist){
        Queue<String> qu = new LinkedList<>();
        qu.add(begin);

        while (!qu.isEmpty()){
            String temp = qu.poll();
            Set<String> strSet = grph.get(temp);
            int sze = strSet.size();
            int distance = dist.get(temp);
            for(String nei:grph.get(temp)){
                if(dist.get(nei)==null){
                    qu.offer(nei);
                    dist.put(nei,distance+1);
                }
            }
        }
        //System.out.println(dist);

    }
    public boolean check1Diff(String st1,String st2){
        int cntr=0;
        for(int i = 0;i<st1.length();i++){
            if(cntr==2)return false;
            if(st1.charAt(i)!=st2.charAt(i))cntr++;
        }
        return cntr==1;
    }


    public List<String> generateParenthesis(int n) {
        List<String> li = new ArrayList<>();
        dfs("",li,n,n);
        return li;
    }

    public void dfs(String soFar,List<String> li,int left,int right){
        if(left>right)return;

        if(left > 0){
            dfs(soFar+"(",li,left - 1,right);
        }

        if(right > 0){
            dfs(soFar+")",li,left,right - 1);
        }

        if(left == 0 && right == 0){
            li.add(soFar);
            return;
        }
    }

    public List<Integer> partitionLabels(String S) {
        int [] start = new int[26];

        java.util.Arrays.fill(start,-1);
        int [] end = new int[26];
        java.util.Arrays.fill(end,-1);

        for(int i = 0;i<S.length();i++){
            end[S.charAt(i) - 'a'] = i;
        }
        List<Integer> li = new ArrayList<>();
        int anchor = 0;
        int lon = end[S.charAt(0) - 'a'];

        for(int i  = 0;i < S.length();i++) {
            int tlon = end[S.charAt(i) - 'a'];

            if((lon < tlon || lon > tlon ) && (i < lon )) {
                anchor = Math.min(anchor,i);
                lon = Math.max(lon,tlon);
            }

            else if(i == lon){
                li.add((lon - anchor) + 1);
                if ((i+1)==S.length()) break;
                anchor = i+1;
                lon = end[S.charAt(i+1) - 'a'];
            }
        }

        return li;
    }


    public List<String> topKFrequent(String[] words, int k) {
        Map<String,Integer> mp = new HashMap<>();
        for(String word:words){
            mp.put(word,mp.getOrDefault(word,0)+1);
        }
        Queue<Map.Entry<String,Integer>> qu = new PriorityQueue<>(
                (o1, o2) -> o1.getValue() == o2.getValue()?o1.getKey().compareTo(o2.getKey()):o2.getValue() - o1.getValue()
        );

        for(Map.Entry<String,Integer> entry : mp.entrySet()){
            qu.offer(entry);
        }
        List<String> result = new ArrayList<>();
        for(int i = 0;i < k;i++){
            result.add(qu.poll().getKey());
        }

        return result;

    }

    public List<Integer> findClosestElements(int[] arr, int k, int x) {
        List<Integer> li = new ArrayList<>();
        int indx = k;


        int xi = Arrays.binarySearch(arr, x);

        System.out.println(xi);

        if(xi<0){
            xi = -xi -1;
        }
        int lef = xi, rig = xi + 1;

        if(xi <= 0 || x < arr[0]){
            return arrToList(arr,0,k);
        }else if(xi == arr.length - 1 || x > arr[arr.length - 1]){
            return arrToList(arr,arr.length - k,arr.length);
        }
        while(indx > 0){
            indx--;

            if(lef<0){
                li.add(arr[rig]);rig++;continue;
            }
            else if(rig > arr.length-1){
                li.add(arr[lef]);lef--;continue;
            }else if(lef<0 && rig>arr.length-1){
                break;
            }
            int left = arr[lef];
            int right = arr[rig];

            if(Math.abs(x - left) > Math.abs(x - right)){
                li.add(right);rig++;
            }else{
                li.add(left);lef--;
            }
        }
        Collections.sort(li);
        return li;

    }

    public List<Integer> arrToList(int []arr,int start,int end){
        List<Integer> li = new ArrayList<>();
        for(int i = start;i<end;i++){
            li.add(arr[i]);
        }
        return li;
    }


    List<String> resuts;
    List<String> li;
    public List<String> letterCombinations(String digits) {
        resuts = new ArrayList<String>();
        li = new ArrayList<>();
        int c = 0;
        for(int i= 0 ;i<8;i++){
            StringBuilder st = new StringBuilder();
            for(int j =0;j<3;j++){
                st.append((char) (c+97));
                c++;
                if((char) (c+97) == 's'){
                    st.append('s');
                    c++;
                }

                if((char) (c+97) == 'z'){
                    st.append('z');
                    c++;
                }
            }
            li.add(st.toString());
        }
        helper(digits, new StringBuilder());
        return resuts;
    }

    public void helper(String digits,  StringBuilder sb){
        if(sb.length() == digits.length()){
            resuts.add(sb.toString());
            return;
        }

        int len = Integer.parseInt(String.valueOf(digits.charAt(sb.length())));

        for (int i = 0;i < li.get(len-2).length();i++){

            String s = li.get(len-2);
            sb.append(s.charAt(i));
            helper(digits,sb);
            sb.deleteCharAt(sb.length()-1);

        }
        return;
    }

    public List<String> letterCombinationsBFS(String digits) {
        //BFS

        LinkedList<String> res = new LinkedList<String>();

        if (digits.isEmpty()) return res;

        String[] ref = new String[] {"", "", "abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
        res.add("");

        while (res.peek().length() != digits.length()) {
            String pre = res.remove();
            String cur = ref[digits.charAt(pre.length()) - '0'];

            for (char c : cur.toCharArray()) {
                res.add(pre + c);
            }
        }
        return res;
    }

    public List<String> letterCombinationsBFS2(String digits) {
        List<String> rst = new ArrayList<String>();
        if (digits == null || digits.length() == 0) {
            return rst;
        }
        //Init map
        HashMap<Character, String> map = new HashMap<>();
        map.put('2',"abc");
        map.put('3',"def");
        map.put('4',"ghi");
        map.put('5',"jkl");
        map.put('6',"mno");
        map.put('7',"pqrs");
        map.put('8',"tuv");
        map.put('9',"wxyz");
        // Init 1 digits and the chars in queue
        Queue<String> queue = new LinkedList<String>();
        char c = digits.charAt(0);
        String s = map.get(c);
        for (int i = 0; i < s.length(); i++) {
            queue.offer(s.charAt(i) + "");
        }
        int size = 0;
        for (int i = 1; i < digits.length(); i++) {//iteratve all numbers
            c = digits.charAt(i);
            s = map.get(c);
            size = queue.size();
            for (int j = 0; j < size; j++) {//iteratve old queue
                String str = queue.poll();
                for (int k = 0; k < s.length(); k++) {//iteratve possibile chars per number key
                    queue.offer(str + s.charAt(k));
                }
            }
        }
        while (!queue.isEmpty()) {
            rst.add(queue.poll());
        }
        return rst;
    }

    List<List<Integer>> ret;
    public List<String> combinationSum(int[] candidates, int target) {
        ret = new ArrayList<>();
        int len = candidates.length;
        Arrays.sort(candidates);

        List<Integer> li = new ArrayList<>();
        helper(candidates,target,li,0);
        return new ArrayList<>();
    }

    public void helper(int[] candidates, int target, List<Integer> li, int currIndx){
        if(target == 0){
            ret.add(new ArrayList<>(li));
            return;
        }
        else {
            for(int i = currIndx;i<candidates.length;i++){
                if(candidates[i]>target)break;

                li.add(candidates[i]);
                helper(candidates,target - candidates[i],li,i);
                li.remove(li.size() - 1);
            }
        }
        return;
    }

    static int indexEqualsValueSearchRec(int[] arr) {
        // your code goes here
        int l = arr.length;
        return findSmallestMatch(arr, 0, l-1);

    }
    // cann you hear me? // l=0, r=4
    static int findSmallestMatch(int[] arr, int l , int r) {

        if(l == r) {
            return arr[l] == l ? l : -1;
        }
        if(l > r) {
            return -1;
        }

        int mid = (l+r)/2; // are you able to hear me ? I am able to hear you!!
        int left = findSmallestMatch(arr, l, mid);
        int right = findSmallestMatch(arr, mid+1, r);
        if(right == -1 || left < right)
            return left;
        else
            return right;
    }

    static double root(double x, int n) {
        // your code goes here
        // 9 2
        double ul = x / n;  // 4.5
        double ll = 0.0;
        double ret = 0.0;
        double hl = (ul+ll)/2;

        while( ll<ul ){
            double val = checkVal(n,hl);
            if(x - val <= 0.001){
                break;
            }
            else if(x > val){
                ll = hl;
            }else if(x < val){
                ul = hl;
            }

            hl = (ul + ll)/2;

        }
        return hl;
    }

    static double checkVal(int n,double num){
        return Math.pow(num,n);
    }

    static int findDuplicate(int[] arr) {
        int tort = arr[0];
        int hair = arr[0];

        do {
            tort = arr[tort];
            hair = arr[arr[hair]];
        } while (arr[tort] != arr[hair]);

        System.out.println("tort " + tort);
        System.out.println("hair " + hair);

        return arr[tort];
    }

    static int shiftednumsSearch(int[] nums, int num) {
        // your code goes here
        int l = 0;
        int r = nums.length - 1;
        int mid = l + (r - l) / 2;
        while (l <= r) {

            mid = l + (r - l) / 2;
            if ((nums[mid] < nums[mid - 1]) || mid == 0) {
                break;
            } else if (nums[mid] > nums[0]) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }

        l = 0;
        r = nums.length - 1;

        if (num >= nums[mid] && num <= nums[r]) {
            // binary search
            return binarySearch(nums, mid, r, num);
        } else {
            return binarySearch(nums, l, mid - 1, num);
        }

    }

    static int binarySearch(int[] nums, int l, int r, int num) {
        int mid = l + (r - l) / 2;
        while (l <= r) {
            mid = l + (r - l) / 2;
            if (nums[mid] == num) {
                return mid;
            } else if (nums[mid] < num) {
                l = mid + 1;
            } else {
                r = mid - 1;
            }
        }
        return -1;
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

    static int indexEqualsValueSearch(int[] nums) {

        int len = nums.length;
        int l = 0, r = len;
        int mid;
        int soFar = Integer.MAX_VALUE;

        while(l<=r){
            mid = l+(r - l)/2;
            if (mid == nums[mid]) {
                soFar = Math.min(mid,soFar);
                r = mid - 1;
                l = 0;
            } else if (mid < nums[mid]) {
                r = mid - 1;
            } else if (mid > nums[mid]) {
                l = mid + 1;
            }
        }

        return (soFar==Integer.MAX_VALUE)?-1:soFar;

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

//    public int ladderLength(String beginWord, String endWord, List<String> wordList) {
//        if(!wordList.contains(endWord)||(beginWord.length()!=endWord.length())){
//            return 0;
//        }
//        Set<Character> chrs = new HashSet();
//        // Create a set of words in wordList
//        for(String s:wordList){
//            for(char c:s.toCharArray()){
//                chrs.add(c);
//            }
//        }
//        //
//        Set<String> visited = new HashSet();
//        LinkedList<String> qu = new LinkedList<>();
//        qu.add(beginWord);
//
//        int ret = 0;
//        // BFS
//        while(qu.size()>0){
//            int sz = qu.size();
//            while(sz>0){
//                ret++;
//                String wrd = qu.poll();
//                visited.add(wrd);
//                StringBuilder nm;
//                for(int j=0;j<wrd.length();j++){
//                    nm = new StringBuilder(wrd);
//                    for(char c:chrs){
//                        nm.setCharAt(j,c);
//                        String st = nm.toString();
//                        if(st.equals(endWord))break;
//                        if(wordList.contains(st)&&!visited.contains(st)){
//                            qu.add(st);
//                        }
//                    }
//
//                }
//
//            }
//        }
//        return ret;
//    }

}
