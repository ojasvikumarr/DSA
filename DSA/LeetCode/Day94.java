package LeetCode;

public class Day94 {
    class Solution {
        // public int countPrefixSuffixPairs(String[] words) {
        //     TrieNode prefixTree = buildPrefixTree(words);
        //     TrieNode suffixTree = buildSuffixTree(words);
        //     for()
        // }
    
        public int countPrefixSuffixPairs(String[] words) {
            int count = 0 ; 
            for(int i = 0 ; i < words.length ; i++){
                for(int j = i+1 ; j < words.length ; j++){
                    if(isPrefixAndSuffixII(words[i] , words[j])){
                        count++ ;
                    }
                }
            }
            return count ;
        }
    
        class TrieNode{
            TrieNode[] next = new TrieNode[26];
            String word ;
        }
    
        public TrieNode buildPrefixTree(String[] words){
            TrieNode root = new TrieNode();
            for(String w : words){
                TrieNode p = root ;
                for(Character c : w.toCharArray()){
                    int idx = c - 'a';
                    if(p.next[idx] == null){
                        p.next[idx] = new TrieNode();
                    }
                    p = p.next[idx] ;
                }
                p.word = w ;
            }
            return root ;
        }
        public TrieNode buildSuffixTree(String[] words){
            TrieNode root = new TrieNode();
            for(String w : words){
                StringBuilder sb = new StringBuilder(w);
                sb.reverse();
                String word = sb.toString();
                TrieNode p = root ;
                for(char c : word.toCharArray()){
                    int idx = c - 'a';
                    if(p.next[idx] == null){
                        p.next[idx] = new TrieNode();
                    }
                    p = p.next[idx];
                }
                p.word = word ;
            }
            return root ;
        }
    
        public boolean isPrefixAndSuffixIII(String pattern , String txt){
            return txt.startsWith(pattern) && txt.endsWith(pattern);
        }
        public boolean isPrefixAndSuffixII(String pattern , String txt){
            if(pattern.length() > txt.length()) return false ;
            int i = 0 ;
            int start = 0 ; 
            int end = txt.length() - 1;
            int n = pattern.length() ;
            while(i < pattern.length() && pattern.charAt(i) == txt.charAt(start)
                                       && pattern.charAt(n-i-1) == txt.charAt(end)){
                i++ ;
                start++ ; 
                end-- ;
            }
            return i == pattern.length();
        }
        public boolean isPrefixAndSuffix(String pattern , String txt){
            if(pattern.length() > txt.length()) return false ;
            int i = 0 ; 
            int j = 0 ; 
            while(i < pattern.length() && pattern.charAt(i) == txt.charAt(j)){
                i++ ;
                j++ ;
            }
            if(i != pattern.length()){
                return false ;
            }
            i = pattern.length() - 1 ;
            j = txt.length() - 1 ;
            while(i >= 0 && pattern.charAt(i) == txt.charAt(j)){
                i-- ;
                j-- ;
            }
            if(i != -1){
                return false ;
            }
            return true ;
        }
    }
}
