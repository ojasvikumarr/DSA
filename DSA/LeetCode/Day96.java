package LeetCode ;

public class Day96 {
    class Solution {
        class TrieNode{
            TrieNode[] next = new TrieNode[26];
            boolean isTerminal ; 
            int count ;
            public TrieNode(){
                count = 0;
            }
        }
        public TrieNode buildTrie(String[] words){
            TrieNode root = new TrieNode();
            for(String w : words){
                TrieNode p = root ; 
                for(char c : w.toCharArray()){
                    int idx = c - 'a';
                    if(p.next[idx] == null){
                        p.next[idx] = new TrieNode();
                    }
                    p = p.next[idx];
                }
                p.isTerminal = true ;
                p.count += 1 ;
            }
            return root ;
        }
        public int countPrefix(TrieNode root , String pref ){
            int ans = 0 ; 
            TrieNode p = root ;
            for(int i = 0 ; i < pref.length() ; i++){
                char c = pref.charAt(i);
                int idx = c - 'a';
                if(p.next[idx] != null){
                    p = p.next[idx] ;
                }else{
                    return 0 ;
                }
            }
            //Now we have the TrieNode p pointing to the last leeter of the prefix
            //Now we need to start the BFS/DFS of all the nodes after it and search for terminals 
            //For every terminal count++ and return addition of all terminals 
            ans = solve(p);
            return ans ;
        }
        public int solve(TrieNode root){
            if(root == null) return 0 ;
            int ans = 0 ; 
            if(root.isTerminal == true){
                ans += root.count ; 
            }
            for(int i = 0 ; i < 26 ; i++){
                if(root.next[i] != null){
                    ans += solve(root.next[i]) ;
                }
            }
            return ans ;
        }
        public int prefixCount(String[] words, String pref) {
            TrieNode root = buildTrie(words);
            return countPrefix(root ,pref );
        }
    }
}
