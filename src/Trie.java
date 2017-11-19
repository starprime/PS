import com.sun.corba.se.impl.orbutil.ObjectUtility;

import java.util.HashMap;
import java.util.Map;


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
    public Trie(){
        root=new TrieNode();
    }
    public static void main(String [] args){
        String word="lolmax";
        Trie t=new Trie();
        t.recInsert(word);
        System.out.println(t.search(word));
        System.out.println(t.searchRec(word));
        //t.delWord(word);
        System.out.println(t.searchRec(word));
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
    public boolean search(String word){
        TrieNode cur=root;char ch;
        for(int i=1;i<word.length();i++){
            ch=word.charAt(i);
            TrieNode nd=cur.child.get(ch);
            if(nd==null){
                return false;
            }
            cur=nd;
        }return cur.eow;
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
}
