///**
// * Created by star on 8/17/18.
// */
//
///*
//
//Getting a Different Number
//
//# [0, 1, 2, 3, 500]
//# n is the lenght of arr
//#(1) if interger == 0:
//#   change 0 th index to -n-2
//#(2) if integer is in a range [1...n-1]:
//#       change i'th index to -value of the i'th index
//#(3) if integer >= n:
//#        do nothing
//#  [0, 2, 1, 3, 500]
//#  [-7, -2, -1, -3, 500]
//
//*/
//
//
//
//import sun.plugin.javascript.navig.Array;
//
//import java.util.*;
//
//class Pramp_Sol {
//
//    static int numOfPathsToDest(int n) {
//        // your code goes here
//        int[][] mem = new int[n][n];
//        rec(mem, 0, n - 1);
//        return mem[0][n - 1];
//
//    }
//
//    static void rec(int[][] mem, int i, int j) {
//        if (j < 0 || i < j) return;
//        mem[i][j] += 1;
//        rec(mem, i + 1, j);
//        rec(mem, i, j - 1);
//        return;
//    }
//
//    static int[] sortKMessedArray(int[] arr, int k) {
//        // your code goes here
//        k = k + 1;
//        TreeSet<Integer> mp = new TreeSet<Integer>();
//        // insert first 3 elements 1, 4, 5
//        for(int i = 0;i<k;i++){
//            mp.add(arr[i]);
//        }
//        // [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
//        //           i
//        // we will store all the element unitl last in the map
//        int i;
//        // and keep updating the array with sorted values
//        // [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
//        //           i
//        for(i = k;i<arr.length;i++){  // i = 9
//            arr[i-k] = mp.first(); // arr[1]  = 6
//            mp.add(arr[i]);  // 3
//        }
//        // the last 3 values will still in the map.
//        // 10, 9 ,8
//        i--;
//        while(!mp.isEmpty()){
//            arr[i - k] = mp.first();
//            i++;
//        }
//        return arr;
//    }
//
//    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
//        // your code goes here
//        HashMap<String,String> ret = new HashMap<>();
//
//        for(Map.Entry<String,Object> entry : dict.entrySet()) {
//            Object ob = entry.getValue();
//            String ke = entry.getKey();
//            if(ob instanceof String){
//                ret.put(ke,(String)ob);
//            }else{
//
//                HashMap<String,Object> tmp;
//                tmp = (HashMap<String,Object>) (ob);
//                String topK = ke;
//                Map<String,String> res = flattenDictionary(tmp);
//                // a:2 b:3
//                for(HashMap.Entry<String,String> en : res.entrySet()) {
//                    Object obj = en.getValue();
//                    String ket = en.getKey();
//                    String f;
//
//                    if(!ke.equals("")||ket!=null){
//                        f = topK+"."+ket;
//                    }else{
//                        f = topK;
//                    }
//                    ret.put(f,(String)obj);
//                }
//            }
//        }
//        return ret;
//    }
//
//    static String[][] wordCountEngine(String document) {
//        // your code goes here
//        String []chunks = document.split(" ");
//        PrintArray.printArray(chunks);
//        for(int i = 0;i<chunks.length;i++){
//            chunks[i] = removepunctuation(chunks[i]);
//        }
//
//        Map<String,int []> mp = new HashMap<String,int[]>();
//        for(int i = 0;i<chunks.length;i++){
//
//            String s = chunks[i];
//            if (s.isEmpty())continue;
//            if(mp.containsKey(s)){
//                int [] nt = mp.get(s);
//                nt[1]++;
//                mp.put(s,nt);
//            }else{
//                int [] nt = new int[2];
//                nt[0] = i;
//                nt[1] = 1;
//                mp.put(s,nt);
//            }
//        }
//
//        List<Map.Entry<String, int []>> list = new LinkedList<Map.Entry<String, int []>>(mp.entrySet());
//
//        Collections.sort(list, new Comparator<Map.Entry<String, int []>>() {
//            @Override
//            public int compare(Map.Entry<String, int[]> o1, Map.Entry<String, int[]> o2) {
//                    if(o2.getValue()[1] == o1.getValue()[1]){
//                        return o1.getValue()[0] - o2.getValue()[0];
//                    }else {
//                        return o2.getValue()[1] - o1.getValue()[1];
//                    }
//            }
//        });
//
//
//        String[][] array = new String[list.size()][2];
//        String[] blankArray = new String[0];
//
//        for (int i=0; i < list.size(); i++) {
//            array[i][0] = list.get(i).getKey();
//            array[i][1] = Integer.toString(list.get(i).getValue()[1]);
//        }
//        PrintArray.printArray(array);
//        return array;
//
//        }
//    static String removepunctuation(String str){
//        StringBuilder sb = new StringBuilder();
//        for(char c:str.toCharArray()){
//            if(96 < c && c < 123){
//                sb.append(c);
//            }else if( 64 < c && c < 91){
//                sb.append(Character.toString ((char) (c + 32)));
//            }else{
//                continue;
//            }
//        }
//        return sb.toString();
//    }
//
//    static int[] spiralCopy(int[][] mat) {
//        if(mat.length==0)return new int[0];
//        boolean [][] seen = new boolean[mat.length][mat[0].length];
//
//        int rL = mat[0].length;
//        int dL = mat.length;
//
//        boolean rig,dow = false,up = false,lef = false;
//        rig = true;
//        int x = 0, y = 0;
//        int total = mat[0].length*mat.length;
//        List<Integer> li = new ArrayList<>();
//
//        while (total>0){
//
//            if (rig){
//                if(x<rL && !seen[x][y]){
//                    li.add(mat[x][y]);
//                    seen[x][y] = true;
//                    y++;
//                }else{
//                    rig = false;
//                    dow = true;
//                    x++;
//                }
//            }else if (dow){
//                if (y<dL && !seen[x][y]){
//                    li.add(mat[x][y]);
//                    seen[x][y] = true;
//                    x++;
//                }else{
//                    dow = false;
//                    lef = true;
//                    y--;
//                }
//            }else if (lef){
//                if(x>0 && !seen[x][y]){
//                    li.add(mat[x][y]);
//                    seen[x][y] = true;
//                    y--;
//                }else{
//                    lef = false;
//                    up = true;
//                    x--;
//                }
//            }else if(up){
//                if(y>0 && !seen[x][y]){
//                    li.add(mat[x][y]);
//                    seen[x][y] = true;
//                    x--;
//                }else{
//                    up = false;
//                    rig = true;
//                    y++;
//                }
//            }
//
//        }
//
//        return li.stream().mapToInt(i->i).toArray();
//    }
//
//    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
//        // your code goes here
//
//        List<int[]> li = new ArrayList<>();
//
//        //if(arr.length == 0)return li.stream().mapToInt(i-> new int[]).toArray();
//
//        Set<Integer> st = new HashSet<>();
//        for (int i : arr) {
//            st.add(i);
//        }
//
//        for (int i : arr) {
//            if (st.contains(i + k)) {
//                int[] num = {(i + k), i};
//                li.add(li.size() - 1, num); //
//            }
//        }
//        //return li.stream().mapToInt(i->i).toArray();
//        return new int[0][0];  // temp
//
//    }
//
//    static int[] pancakeSort(int[] arr) {
//        // your code goes here
//        int ls = arr.length - 1;
//
//        while (ls != 0) {
//            int mx = findMaxIndx(arr, ls);
//
//            // [10,9,8,7,6,5,4,3,2,1]
//            flip(arr, mx + 1);
//            flip(arr, ls + 1);
//            ls--;
//        }
//        return arr;
//    }
//
//    static int findMaxIndx(int[] arr, int max) {
//        int mxSf = Integer.MIN_VALUE;
//        int ret = 0;
//        for (int i = 0; i < max; i++) {
//            if (mxSf < arr[i]) {
//                ret = i;
//                mxSf = arr[i];
//            }
//        }
//        return ret;
//    }
//
//    static void flip(int[] arr, int k) {
//        /// i = 0 , k = 1
//        --k;
//        int i = 0;
//        while (i < k) {
//            swap(arr, i++, k--);
//        }
//    }
//
//    static void swap(int[] arr, int i, int j) {
//        int tmp = arr[i];
//        arr[i] = arr[j];
//        arr[j] = tmp;
//    }
//
//    static boolean isMatch(String text, String pattern) {
//        // your code goes here
//        return recChk(text,0,pattern,0);
//
//    }
//
//    /**
//    both consumed -> true
//    t  a c d
//    p  a . .
//
//    t a b b b b
//    p a b *
//              j
//    t   a d d c
//    p   a e * d
//              i
//
//    # one index reaches the end of text or pattern
//
//    # matching a char followed by *
//    there is a matching char OR there is no matching char
//
//    # matching  . or regular char
//
//
//
//  t  b j
//  p  b*
//     i
//
//    */
//    static boolean recChk(String text,int i,String pat,int j){
//
//        if ( i==text.length() && j==pat.length()) return true;
//        if ( j==pat.length()) return false;
//        if (pat.charAt(j)=='*') return recChk(text,i,pat,j+1);
//
//        if (( text.charAt(i) == pat.charAt(j) || ( pat.charAt(j) == '.')) && ( (pat.charAt(j+1) == '*') ) ){
//            if(i == text.length()-1)return true;
//            return recChk(text,i+1,pat,j);
//        } else if((text.charAt(i)!=pat.charAt (j)) && ((j<pat.length() -2) && (pat.charAt(j+1)=='*'))) {
//            return recChk(text,i,pat,j+2);
//        }
//
//        else if ((text.charAt(i)==pat.charAt(j)) || (pat.charAt(j)=='.')) {
//            return recChk(text,i+1,pat,j+1);
//            }
//        else{
//            return false;
//        }
//
//    }
//
////    static String getShortestUniqueSubstring(char[] arr, String str) {
////        // your code goes here
////        Set<Character> set = new HashSet<>();
////        for(char c:arr){
////            set.add(c);
////        }
////
////        Hashtable<Character, Integer> mp = new Hashtable<>();
////        int len = arr.length;
////        int i = 0, j = 1;
////        int uniq = 0;
////    /**
////    arr: [x,a,y,z]
////    x x b x a a a x x x y y y y y z  a y z y y y x a  a a
////          i
////                              j
////    if curr is getting new
////    when to update tail
////
////    // when next and presnt are same
////    // when next and presnt are different
////
////    find element which is not present arr
////
////    when counter is 0
////       x x b y x a a a x x x y y y y y z  a y z y y y x a  a a
////       i                       j
////    */
////        int strt = 0;
////        while(uniq < arr.length){
////
////            char ic = str.charAt(i);  //tailIndex
////            char curr = str.charAt(j);  //headIndex
////            char prv = str.charAt(j - 1);
////            if(curr == prv){  //     when both are same
////
////            }else{
////                uniq++;
////
////                if(mp.containsKey(curr)){
////
////                }
////
////                if(set.contains(jc)){
////                    mp.put(jc,j - 1);
////                }
////
////            }
////
////
////        }
////
////    }
//    static int[] meetingPlanner(int[][] slotsA, int[][] slotsB, int dur) {
//        // your code goes here
//        int lenA = slotsA.length;
//        int lenB = slotsB.length;
//
//        int i = 0, j = 0;
//
//        while (i<lenA && j<lenB){
//
//            int []slt = checkSlot(slotsA[i],slotsB[j],dur);
//            if(slt[0]!=Integer.MIN_VALUE)return slt;
//            else{ // increment index with condition
//                if(slotsA[i][1]>slotsB[j][1]){
//                    j++;
//                }else{
//                    i++;
//                }
//            }
//        }
//
//        return null;
//    }
//
//    static public int[] checkSlot(int [] A,int []B,int dur){
//
//        int start = Math.max(A[0],B[0]);
//        int end = Math.min(A[1],B[1]);
//
//        int []ret = {Integer.MIN_VALUE,Integer.MIN_VALUE};
//        if (end - start >= dur){
//            ret[0] = start;
//            ret[1] = end;
//        }
//        return ret;
//
//    }
//
//    static int[] findDuplicates(int[] arr1, int[] arr2) {
//
//    // your code goes here
//    int len1 = arr1.length;
//    int len2 = arr2.length;
//
//
//    if(len1 > len2){
//
//        if ((Math.log(len1)*len2) >(len1 + len2)){
//            return simple(arr1,arr2);
//        }else{
//            return binary(arr1,arr2);
//        }
//    }else {
//        if ((Math.log(len2)*len1) >(len1 + len2)){
//            return simple(arr1,arr2);
//        }else{
//            return binary(arr2,arr1);
//        }
//    }
//
//
//}
//
//    static int [] simple(int []arr1,int [] arr2){
//        List<Integer> li = new ArrayList<>();
//        int i = 0, j = 0;
//        System.out.println("In Simple");
//        while(i < arr1.length && j < arr2.length){
//            if(arr1[i]==arr2[j]){
//                li.add(arr1[i]);
//                i++;j++;
//            }else if (arr1[i] > arr2[j]){
//                j++;
//            }else{
//                i++;
//            }
//        }
//        System.out.println(li);
//        int [] ret = new int[li.size()];
//
//        for(int k = 0; k <li.size(); k++){
//            ret[k] = li.get(k);
//        }
//        return ret;
//
//    }
//
//    static int[] binary(int [] arr1, int[] arr2){
//        List<Integer> li = new ArrayList<>();
//        System.out.println("In Binary");
//
//
//        for(int i=0;i<arr1.length;i++){
//            int val = arr1[i];
//
//            if(Arrays.binarySearch(arr2, val)>=0){
//                li.add(val);
//            }
//
//        }
//        int [] ret = new int[li.size()];
//        for(int i = 0;i<li.size();i++){
//            ret[i] = li.get(i);
//        }
//        return ret;
//
//    }
//
//    static void print(Object o){
//        System.out.println(o);
//    }
//
//    public static void main(String[] args) {
//
////        int []arr1 = {1,2,3,5,6,7};
////        int []arr2 = {7,8,9,10,11,12};
////        int []res = findDuplicates(arr1,arr2);
////        if(res!=null)PrintArray.printArray(res);
////        else System.out.println(res);
//        //System.out.println(isMatch(new String("aa"),new String("a")));
//
//        //int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
//        //int[] res = pancakeSort(arr);
//        //System.out.println(numOfPathsToDest(2));
//
//
////        HashMap<String, Object> mp = new HashMap<>();
////        mp.put("","lol");
//
//        //int [] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
//        //System.out.println(Arrays.toString(arr));
//
////        int [] [] inputMatrix  = { {1,    2,   3,  4,    5},
////                {6,    7,   8,  9,   10},
////                {11,  12,  13,  14,  15},
////                {16,  17,  18,  19,  20} };
//
//        //System.out.println(Arrays.toString(spiralCopy(inputMatrix)));
////        int [][] slotsA = {{10, 50}, {60, 120}, {140, 210}};
////        int [][] slotsB =  {{0, 15}, {60, 70}};
////
////        int [] res = meetingPlanner(slotsA,slotsB,80);
////        if(res!=null)System.out.println(res[0]+" , "+res[1]);
////        else System.out.println(res);
//
////        System.out.println(wordCountEngine(new String(
////                "Every book is a quotation; and every house is a quotation out of all forests, and mines, and stone quarries; and every man is a quotation from all his ancestors. ")));
//        //System.out.println(removepunctuation(new String("Practice")));
//
//        TreeSet<Integer> st = new TreeSet<>();
//        int [] nums = {1,5,9,1,5,9,};
//        for(int i:nums)st.add(i);
//        // print(st.size());
//        print(st.ceiling(3));
//        System.out.println(st);
//    }
//
//}
//
///*
//
//*/