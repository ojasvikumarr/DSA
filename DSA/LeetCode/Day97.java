package LeetCode;

import java.util.ArrayList;
import java.util.List;

public class Day97 {
    class Solution {
    public List<String> wordSubsets(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();
        int[] pattern = new int[26];
        for(String w : words2){
            int[] dummy = new int[26];
            countFreq(w , dummy);
            for(int i = 0 ; i < 26 ; i++){
                if(dummy[i] > pattern[i]) pattern[i] = dummy[i];
            }
        }
        for(String w : words1){
            int[] txt = new int[26];
            countFreq(w , txt);
            boolean flag = true ;
            for(int i = 0 ; i < 26 ; i++){
                if(txt[i] < pattern[i]) flag = false ;
            }
            if(flag == true) result.add(w);
        }
        return result ;
    }

    public void countFreq(String word , int[] arr){
        for(char c : word.toCharArray()){
            arr[c-'a']++;
        }
    }


    class TrieNode{
        TrieNode[] next = new TrieNode[26];
        String word ;
    }
    public TrieNode buildTree(String[] wordss){
        TrieNode root = new TrieNode();
        for(String word : wordss){
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

    public List<String> wordSubsetsII(String[] words1, String[] words2) {
        List<String> result = new ArrayList<>();

        for(String w : words1){
            int counter = 0; 
            for(String ww : words2){
                if(isSubset(ww,w)) counter++ ;
            }
            if(counter == words2.length) result.add(w);
        }
        return result ;
    }
    public boolean isSubset(String pattern , String txt){
        if(pattern.length() > txt.length()) return false ;
        for(char c : pattern.toCharArray()){
            if(txt.indexOf(c) == -1){
                return false ;
            }
        }
        return true ;
    }

}
}
