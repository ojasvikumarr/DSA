package ClassImplementation;

public class PrefixTree {
    class Trie {
        class TrieNode{
            TrieNode[] next = new TrieNode[26];
            String word ; 
            // public TrieNode(){
    //No need as default constructore will be used 
            // }
        }
        TrieNode root ;
        public Trie() {
            root = new TrieNode();
        }
        
        public void insert(String word) {
            TrieNode p = root ; //This will be the iterator 
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                if(p.next[idx] == null){
                    //This means we need to add the node 
                    p.next[idx] = new TrieNode();
                }
                //we move the iterator forward
                p = p.next[idx];
            }
            p.word = word ;//we mark the end of the word and store it in the node fo reasy access 
        }
        
        public boolean search(String word) {
            TrieNode p = root ;//This is the iterator 
            for(char c : word.toCharArray()){
                int idx = c - 'a';
                if(p.next[idx] == null){
                    return false ;
                }else{
                    p = p.next[idx];
                }
            }
            if(p.word != null && p.word.equals(word)) return true ;
            return false ;
        }
        
        public boolean startsWith(String prefix) {
            TrieNode p = root ; 
            for(char c : prefix.toCharArray()){
                int idx = c - 'a';
                if(p.next[idx] == null){
                    return false;
                }
                p = p.next[idx];
            }
            return true ;
        }
    }
    
    /**
     * Your Trie object will be instantiated and called as such:
     * Trie obj = new Trie();
     * obj.insert(word);
     * boolean param_2 = obj.search(word);
     * boolean param_3 = obj.startsWith(prefix);
     */
}
