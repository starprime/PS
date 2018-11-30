import java.util.LinkedList;
import java.util.Queue;

class Solution {

    private class TrieNode{
        char c;
        boolean isEnd;
        TrieNode [] child = new TrieNode[26];
        public TrieNode(char c){
            this.c = c;
            this.isEnd = false;
            for(TrieNode t:child)t = null;
        }
        public TrieNode[] getChild(){
            return this.child;
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

            for(i = 0;i<str.length();i++){
                char c = str.charAt(i);
                if(tmp.child[c-'a']==null){
                    //if(!tmp.child.containsKey(c)){
                    TrieNode nd = new TrieNode(c);
                    tmp.child[c-'a'] = nd;
                    tmp = nd;
                }else{
                    tmp = tmp.child[c-'a'];
                }
            }
            tmp.isEnd = true;
        }

        public void printTrie(){
            int i;
            Queue<TrieNode> qu = new LinkedList<>();
            qu.add(root);

            while(!qu.isEmpty()){
                int sze = qu.size();
                for(i = 0;i<sze;i++){
                    TrieNode tmp = qu.poll();
                    //System.out.println(tmp.c);

                    if(!tmp.isEnd){
                        for(TrieNode n:tmp.child){
                            if(n!=null)qu.add(n);
                        }
                    }

                }
            }
        }

        private class Junk{
            String sb;
            TrieNode []t;
            public Junk(String st,TrieNode []t){
                this.sb = st;
                this.t = t;
            }
        }

        public String longWord(){
            String ans = "";
            Queue<Junk> qu = new LinkedList<>();

            for(TrieNode tr:root.child){
                if(tr != null && tr.isEnd){
                    qu.add(new Junk(String.valueOf(tr.c),tr.child));
                }
            }

            while(!qu.isEmpty()){
                int sze = qu.size();

                for(int i = 0;i<sze;i++){

                    Junk tmp = qu.poll();
                    StringBuilder sb = new StringBuilder();
                    sb.append(tmp.sb);

                    for(TrieNode tr:tmp.t){
                        if(tr!=null){
                            sb.append(String.valueOf(tr.c));

                            if(tr.isEnd){
                                if(ans.length()<sb.length())ans=sb.toString();
                                qu.add(new Junk(sb.toString(),tr.child));
                                sb.deleteCharAt(sb.length()-1);

                            }
                        }
                    }
                }
            }
            return ans;
        }
    }

    public String longestWord(String[] words) {
        Trie trie = new Trie();

        for(String st:words){
            trie.insert(st);
        }
        //trie.printTrie();

        return trie.longWord();
    }

}