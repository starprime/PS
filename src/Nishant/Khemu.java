package Nishant;

import java.util.*;

public class Khemu {
    public static void main(String []args){
        System.out.println(LongestRepeating("APPLEHEQGHHIRKK"));
    }
    private static List<String> LongestRepeating(String str){
        Set<Character> st = new HashSet<>();
        int b = -1, r = 0;
        List<String> li = new LinkedList<>();
        int mx = 0;

        while(r < str.length()-1){
            b = r;
            st.add(str.charAt(b));
            while(r < str.length()-1){
                r++;
                if(st.contains(str.charAt(r)))break;
                else st.add(str.charAt(r));
            }
            if(mx > (r - b))continue;
            else if(mx < (r - b)){
                li.clear();
                li.add(str.substring(b, r -1));
                mx = r - b ;
            }
            else if(mx == (r - b)){
                li.add(str.substring(b, r -1));
            }
            st = new HashSet<>();
        }
        return li;
    }

    public String removeKdigits(String num, int k) {
        Stack<Character> st = new Stack<>();
        char[] arr = num.toCharArray();


        st.push(arr[0]);
        int i = 1;

        while(i < num.length()){
            int tmp = convert(arr[i]);
            while(!st.isEmpty() && k > 0 && tmp < convert(st.peek())){
                k--;
                st.pop();
            }
            st.push(arr[i]);
            i++;
        }

        StringBuilder sb = new StringBuilder();

        while(!st.isEmpty()){
            sb.append(st.pop());
        }

        sb.reverse();
        while (sb.length() > 0 && sb.charAt(0) == '0'){
            sb.deleteCharAt(0);
        }

        return sb.toString();

    }

    private int convert(char c){
        return Character.getNumericValue(c);
    }

}
