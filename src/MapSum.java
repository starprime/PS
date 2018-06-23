import java.util.HashMap;
import java.util.Map;

class MapSum {

    public static void main(String []args){
        MapSum ms=new MapSum();
        ms.insert("apple",3);
        System.out.println(ms.sum("apple"));
        ms.insert("app",2);
        System.out.println(ms.sum("ap"));

    }

    MapSum() {
        nd=new TrieNode();
    }

    private class TrieNode{
        Map<Character,TrieNode> mp;
        boolean eow;
        int val;
        public TrieNode(){
            mp=new HashMap<>();
            eow = false;
            val=Integer.MIN_VALUE;
        }
    }

    private final TrieNode nd;
    /** Initialize your data structure here. */
    public void insert(String key, int val) {
        TrieNode cur=nd;char c;
        for(int i=0;i<key.length();i++){
            c=key.charAt(i);
            TrieNode nd=cur.mp.get(c);
            if(nd==null){
                nd=new TrieNode();
                nd.eow=false;
                nd.val=0;
                cur.mp.put(c,nd);
            }
            cur=nd;
        }cur.eow=true;
        cur.val=val;
    }

    public int sum(String prefix) {
        int sum=0;
        TrieNode curr=nd;char c;
        for(int i=0;i<prefix.length();i++){
            c=prefix.charAt(i);
            TrieNode nd=curr.mp.get(c);
            if(nd==null){
                return 0;
            }
            curr=nd;
        }
        return recSum(curr)+curr.val;
    }

    public int recSum(TrieNode curr){
        int sum=0;
        for(Map.Entry<Character, TrieNode> k :curr.mp.entrySet()){
            TrieNode nd=k.getValue();
            sum+=nd.val;
            sum+=recSum(nd);
        }
        return sum;
    }
}

/**
 * Your MapSum object will be instantiated and called as such:
 * MapSum obj = new MapSum();
 * obj.insert(key,val);
 * int param_2 = obj.sum(prefix);
 */