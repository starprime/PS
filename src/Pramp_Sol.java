/**
 * Created by star on 8/17/18.
 */

/*

Getting a Different Number

# [0, 1, 2, 3, 500]
# n is the lenght of arr
#(1) if interger == 0:
#   change 0 th index to -n-2
#(2) if integer is in a range [1...n-1]:
#       change i'th index to -value of the i'th index
#(3) if integer >= n:
#        do nothing
#  [0, 2, 1, 3, 500]
#  [-7, -2, -1, -3, 500]

*/



import sun.plugin.javascript.navig.Array;

import java.util.*;

class Pramp_Sol {

    static int numOfPathsToDest(int n) {
        // your code goes here
        int[][] mem = new int[n][n];
        rec(mem, 0, n - 1);
        return mem[0][n - 1];

    }

    static void rec(int[][] mem, int i, int j) {
        if (j < 0 || i < j) return;
        mem[i][j] += 1;
        rec(mem, i + 1, j);
        rec(mem, i, j - 1);
        return;
    }

    static int[] sortKMessedArray(int[] arr, int k) {
        // your code goes here
        k = k + 1;
        TreeSet<Integer> mp = new TreeSet<Integer>();
        // insert first 3 elements 1, 4, 5
        for(int i = 0;i<k;i++){
            mp.add(arr[i]);
        }
        // [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
        //           i
        // we will store all the element unitl last in the map
        int i;
        // and keep updating the array with sorted values
        // [1, 4, 5, 2, 3, 7, 8, 6, 10, 9]
        //           i
        for(i = k;i<arr.length;i++){  // i = 9
            arr[i-k] = mp.first(); // arr[1]  = 6
            mp.add(arr[i]);  // 3
        }
        // the last 3 values will still in the map.
        // 10, 9 ,8
        i--;
        while(!mp.isEmpty()){
            arr[i - k] = mp.first();
            i++;
        }
        return arr;
    }

    static HashMap<String, String> flattenDictionary(HashMap<String, Object> dict) {
        // your code goes here
        HashMap<String,String> ret = new HashMap<>();

        for(Map.Entry<String,Object> entry : dict.entrySet()) {
            Object ob = entry.getValue();
            String ke = entry.getKey();
            if(ob instanceof String){
                ret.put(ke,(String)ob);
            }else{

                HashMap<String,Object> tmp;
                tmp = (HashMap<String,Object>) (ob);
                String topK = ke;
                Map<String,String> res = flattenDictionary(tmp);
                // a:2 b:3
                for(HashMap.Entry<String,String> en : res.entrySet()) {
                    Object obj = en.getValue();
                    String ket = en.getKey();
                    String f;

                    if(!ke.equals("")||ket!=null){
                        f = topK+"."+ket;
                    }else{
                        f = topK;
                    }
                    ret.put(f,(String)obj);
                }
            }
        }
        return ret;
    }

    static String[][] wordCountEngine(String document) {
        // your code goes here
        String []chunks = document.split(" ");

        for(int i = 0;i<chunks.length;i++){
            chunks[i] = removepunctuation(chunks[i]);
        }

        Map<String,int []> mp = new HashMap<String,int[]>();
        for(int i = 0;i<chunks.length;i++){

            String s = chunks[i];
            if(mp.containsKey(s)){
                int [] nt = mp.get(s);
                nt[1]++;
                mp.put(s,nt);
            }else{
                int [] nt = new int[2];
                nt[0] = i;
                nt[1] = 1;
                mp.put(s,nt);
            }
        }

        List<Map.Entry<String, int []>> list = new LinkedList<Map.Entry<String, int []>>(mp.entrySet());

        Collections.sort(list, new Comparator<Map.Entry<String, int []>>() {
            @Override
            public int compare(Map.Entry<String, int[]> o1, Map.Entry<String, int[]> o2) {
                    if(o2.getValue()[1] == o1.getValue()[1]){
                        return o1.getValue()[0] - o2.getValue()[0];
                    }else {
                        return o2.getValue()[1] - o1.getValue()[1];
                    }
            }

        });


        String[][] array = new String[list.size()][];
        String[] blankArray = new String[0];

        for (int i=0; i < list.size(); i++) {
            System.out.println(list.get(i));
        }

        System.out.println(list);

        return new String [0][0];



        }


    static String removepunctuation(String str){
        StringBuilder sb = new StringBuilder();
        for(char c:str.toCharArray()){
            if(96 < c && c < 123){
                sb.append(c);
            }else if( 64 < c && c < 91){
                sb.append(Character.toString ((char) (c + 32)));
            }else{
                continue;
            }
        }
        return sb.toString();
    }

    static int[] spiralCopy(int[][] mat) {
        if(mat.length==0)return new int[0];
        boolean [][] seen = new boolean[mat.length][mat[0].length];

        int rL = mat[0].length;
        int dL = mat.length;

        boolean rig,dow = false,up = false,lef = false;
        rig = true;
        int x = 0, y = 0;
        int total = mat[0].length*mat.length;
        List<Integer> li = new ArrayList<>();

        while (total>0){

            if (rig){
                if(x<rL && !seen[x][y]){
                    li.add(mat[x][y]);
                    seen[x][y] = true;
                    y++;
                }else{
                    rig = false;
                    dow = true;
                    x++;
                }
            }else if (dow){
                if (y<dL && !seen[x][y]){
                    li.add(mat[x][y]);
                    seen[x][y] = true;
                    x++;
                }else{
                    dow = false;
                    lef = true;
                    y--;
                }
            }else if (lef){
                if(x>0 && !seen[x][y]){
                    li.add(mat[x][y]);
                    seen[x][y] = true;
                    y--;
                }else{
                    lef = false;
                    up = true;
                    x--;
                }
            }else if(up){
                if(y>0 && !seen[x][y]){
                    li.add(mat[x][y]);
                    seen[x][y] = true;
                    x--;
                }else{
                    up = false;
                    rig = true;
                    y++;
                }
            }

        }

        return li.stream().mapToInt(i->i).toArray();
    }

    static int[][] findPairsWithGivenDifference(int[] arr, int k) {
        // your code goes here

        List<int[]> li = new ArrayList<>();

        //if(arr.length == 0)return li.stream().mapToInt(i-> new int[]).toArray();

        Set<Integer> st = new HashSet<>();
        for (int i : arr) {
            st.add(i);
        }

        for (int i : arr) {
            if (st.contains(i + k)) {
                int[] num = {(i + k), i};
                li.add(li.size() - 1, num); //
            }
        }
        //return li.stream().mapToInt(i->i).toArray();
        return new int[0][0];  // temp

    }

    static int[] pancakeSort(int[] arr) {
        // your code goes here
        int ls = arr.length - 1;

        while (ls != 0) {
            int mx = findMaxIndx(arr, ls);

            // [10,9,8,7,6,5,4,3,2,1]
            flip(arr, mx + 1);
            flip(arr, ls + 1);
            ls--;
        }
        return arr;
    }

    static int findMaxIndx(int[] arr, int max) {
        int mxSf = Integer.MIN_VALUE;
        int ret = 0;
        for (int i = 0; i < max; i++) {
            if (mxSf < arr[i]) {
                ret = i;
                mxSf = arr[i];
            }
        }
        return ret;
    }

    static void flip(int[] arr, int k) {
        /// i = 0 , k = 1
        --k;
        int i = 0;
        while (i < k) {
            swap(arr, i++, k--);
        }
    }

    static void swap(int[] arr, int i, int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

    static boolean isMatch(String text, String pattern) {
        // your code goes here
        return recChk(text,0,pattern,0);

    }

    /*
    both consumed -> true
    t  a c d
    p  a . .

    t a b b b b
    p a b *
              j
    t   a d d c
    p   a e * d
              i

    # one index reaches the end of text or pattern

    # matching a char followed by *
    there is a matching char OR there is no matching char

    # matching  . or regular char



  t  b j
  p  b*
     i

    */
    static boolean recChk(String text,int i,String pat,int j){
        if(i==text.length() && j==pat.length()) return true;
        if(j==pat.length()) return false;
        //if(pat.charAt(j)=='*')return reChk(text,i,pat,j+1);

        if((text.charAt(i)==pat.charAt(j) || (pat.charAt(j)=='.')) && (pat.charAt(j+1)=='*')){
            return recChk(text,i+1,pat,j);
        }else if((text.charAt(i)!=pat.charAt(j)) && (pat.charAt(j+1)=='*'))
        { return recChk(text,i,pat,j+2);
        }

    else if((text.charAt(i)==pat.charAt(j)) || (pat.charAt(j)=='.')){
            return recChk(text,i+1,pat,j+1);
        }else{
            return false;
        }
    }

    public static void main(String[] args) {
        //int[] arr = {10, 9, 8, 7, 6, 5, 4, 3, 2, 1};
        //int[] res = pancakeSort(arr);
        //System.out.println(numOfPathsToDest(2));


//        HashMap<String, Object> mp = new HashMap<>();
//        mp.put("","lol");

        //int [] arr = {1, 4, 5, 2, 3, 7, 8, 6, 10, 9};
        //System.out.println(Arrays.toString(arr));

        int [] [] inputMatrix  = { {1,    2,   3,  4,    5},
                {6,    7,   8,  9,   10},
                {11,  12,  13,  14,  15},
                {16,  17,  18,  19,  20} };

        //System.out.println(Arrays.toString(spiralCopy(inputMatrix)));

        System.out.println(wordCountEngine(new String("Practice makes perfect. you'll only yet Perfect by practice. just practice!")));
        //System.out.println(removepunctuation(new String("Practice")));
    }

}

/*

*/