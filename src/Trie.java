
import java.util.*;


public class Trie{

    private class TrieNode {
        Map<Character, TrieNode> child;
        Boolean eow;

        public TrieNode() {
            child = new HashMap<>();
            eow = false;
        }
    }
    private final TrieNode root;
    private Trie(){
        root=new TrieNode();
    }
    public static void main(String [] args){
        String word="lolmax";
        Trie t=new Trie();
        t.insert(word);
//      System.out.println(t.search(word));
//      System.out.println(t.searchRec(word));
//      t.delWord(word);
//      System.out.println(t.searchRec(word));

        System.out.println(t.searchReg("lol..."));
    }


    public void insert(String word){
        TrieNode currnt=root;
        char ch;
        for(int i=0;i<word.length();i++){
            ch=word.charAt(i);
            TrieNode nd=currnt.child.get(ch);
            if(nd==null){
                nd =new TrieNode();
                currnt.child.put(ch,nd);
            }currnt=nd;
        }currnt.eow=true;
    }
    public void recInsert(String word){
        recInsert(root,word,0);
    }
    public void recInsert(TrieNode current,String word,int indx){
        if(indx==word.length()){current.eow=true;return;}
        char ch=word.charAt(indx);
        TrieNode nd=current.child.get(ch);
        if(nd==null){
            nd=new TrieNode();
            current.child.put(ch,nd);
        }
        recInsert(nd,word,indx+1);
    }
    public boolean searchRec(String word){
        return searchRec(root,word,0);
    }
    public boolean searchRec(TrieNode current,String word,int index){
        if(word.length()==index){return current.eow;}
        char ch=word.charAt(index);
        TrieNode nd=current.child.get(ch);
        if(nd==null){
            return false;
        }
        return searchRec(nd,word,index+1);
    }
    public boolean delRec(String word){
        return true;//delRec(root,word,0);
    }
    public boolean delWord(TrieNode current,String word,int index) {
        if (word.length() == index) {
            if (!current.eow) {
                return false;
            }
            current.eow = false;
            return current.child.size() == 0;
        }
        char ch;
            ch = word.charAt(index);
            TrieNode nd = current.child.get(ch);
            if(nd==null){return false;}
            current = nd;
            boolean shldDelCurrntNode=delWord(current,word,index+1);
            if(shldDelCurrntNode){
                current.child.remove(ch);
                return current.eow;
            }return true;
    }

    public boolean search(String word){
        TrieNode cur=root;char ch;
        for(int i=0;i<word.length();i++){
            ch=word.charAt(i);
            TrieNode nd=cur.child.get(ch);
            if(nd==null){
                return false;
            }
            cur=nd;
        }return cur.eow;
    }
    public boolean searchReg(String str) {
        return searchReg(str,root);
    }
    public boolean searchReg(String str,TrieNode nd){
        TrieNode cur = nd;

        for(int i = 0;i<str.length();i++){
            char c = str.charAt(i);
            if(c=='.'){

                if(str.length() == 1)return cur.eow;
                // using for-each loop for iteration over Map.entrySet()
                for (Map.Entry<Character,TrieNode> entry : cur.child.entrySet()){

                    if(i+1<str.length() && searchReg(str.substring(i),entry.getValue())){
                        return true;
                    }

                }

            }else{
                TrieNode temp = cur.child.get(c);{
                    if(temp == null){
                        return false;
                    }else {
                        cur = temp;
                    }
                }
            }
        }

        return cur.eow;
    }


    public boolean startsWith(String word) {
        TrieNode tmp = root;
        TrieNode nd;
        char ch;
        int i;

        for(i = 0;i < word.length();i++){

            ch = word.charAt(i);
            nd = tmp.child.get(ch);

            if(nd == null){
                return false;
            }
            tmp = nd;
        }

        return true;
    }

}
