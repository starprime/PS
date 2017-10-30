import java.util.*;

public class Solution {
    public int k;
    public boolean isHappy(int n) {
        int x=0,total=0;
        Set<Integer> alrd=new HashSet<>();
        while(true){
            total=0;
            while(n!=0){
                x=n%10;
                total+=Math.pow(x,2);
                n=n/10;
            }

            System.out.println(total);
            if(total==1){return true;}
            else if(alrd.contains(total)){return false;}
            alrd.add(total);
            n=total;
        }
    }
    public static void main(String []args){
        Solution s=new Solution();
//        System.out.println(s.isHappy(1111111));
        //LexicographicalNumbers ln=new LexicographicalNumbers();
        //List<Integer> l=ln.lexicalOrder(10);
        //System.out.println("--"+-3%2);
        //System.out.println("--"+-3/2);

        //System.out.print(s.mypow(2,-3));

        //System.out.println(s.wordPattern("abbddc","haha hehe hehe huhu huhu lol"));
        System.out.println(s.isIsomorphic("egg","tff"));
        System.out.println(s.isIsomorphic("egg","trf"));

        //            System.out.println(s.longestPalindrome("ccc"));
    }
    public int longestPalindrome(String s){
        Map<Character,Integer> hm=new HashMap<Character, Integer>();
        char k='c';int cnt=0,ret=0;
        for(int i=0;i<s.length();i++){
            k=s.charAt(i);
            if(hm.containsKey(k)){
                hm.remove(k);
                cnt++;
            }else{
                hm.put(k,1);
            }
        }
        return cnt*2+1;
    }

    public double mypow(double x,int n){
        //int k=Math.abs(n);
        double[] arr=new double[k+1];
        for(int i=0;i<n;i++){
            arr[i]=0;
        }
        return mypwH(x,n);
    }

    public double mypwH(double x,int n){
        if(n==1) return x;
        if(n==-1) return 1/x;
        if(n>0) {
            if (n % 2 == 1) {
                return mypwH(x, n / 2) * mypwH(x, (n / 2) + 1);
                //System.out.println(arr[n]);
            } else {
                return mypwH(x, n / 2) * mypwH(x, n / 2);
                //System.out.println(arr[n]);
            }
        }
        else {
            if (n % 2 == -1) {
                return mypwH(x, n / 2) * mypwH(x, (n / 2) + 1);
                //System.out.println(arr[n]);
            } else {
                return mypwH(x, n / 2) * mypwH(x, n / 2);
                //System.out.println(arr[n]);
            }
        }
    }

    public boolean wordPattern(String pattern, String str) {
        String []strL=str.split("\\s",0);
        int pl=pattern.length();
        if(pl!=strL.length)return false;

        Map<Character,String> mp=new HashMap<>();

        char c;
        for(int i=0;i<pl;i++){
            c=pattern.charAt(i);
            if(mp.containsKey(c)){
                if(!mp.get(c).equals(strL[i])){
                    return false;
                }
            }else{
                if(mp.containsValue(strL[i])){
                    return false;
                }
                mp.put(c,strL[i]);
            }
        }
        return true;
    }

    public boolean isIsomorphic(String s, String t) {
        if(s.length()!=t.length())return false;
        Map<Character,Character> mp=new HashMap<>();
        char kc,vc;

        for(int i=0;i<s.length();i++){
            kc=s.charAt(i);
            vc=t.charAt(i);
            if(mp.containsKey(kc)){
                if(mp.get(kc)!=vc){
                    return false;
                }
            }
            else {
                if(mp.containsValue(vc)){
                    return false;
                }
                mp.put(kc,vc);
            }
        }
        return true;
    }

    public List<Integer> findAnagrams(String s, String p) {
        List<Integer> ret=new ArrayList<>();
        if(s.length()<p.length())return ret;


    }
}