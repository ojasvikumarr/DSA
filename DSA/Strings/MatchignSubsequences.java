package Strings;

import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.* ; 

public class MatchignSubsequences {
    class Solution {
    public class Pair{
        int idx ; 
        int ptr ; 
        public Pair(int i , int p){
            this.idx = i ; 
            this.ptr = p ; 
        }
    }

    @SuppressWarnings("unchecked")
    public int numMatchingSubseq(String s, String[] words) {
        int result = 0 ; 
        List<StringBuilder>[] waiting = new List[128];
        for(int c = 0 ; c <= 'z' ; c++){
            waiting[c] = new ArrayList<>();
        }
        for(String w : words){
            waiting[w.charAt(0)].add(new StringBuilder(w));
        }
        for(char c : s.toCharArray()){
            List<StringBuilder> advance = waiting[c];

            waiting[c] = new ArrayList<>();

            for(StringBuilder it : advance){
                it.deleteCharAt(0);
                if(it.length() != 0){
                    waiting[it.charAt(0)].add(it);
                }else{
                    result++ ;
                }
            }
        }
        return result ;
    }
    public int numMatchingSubseqII(String s, String[] words) {
        int n = words.length ;
        int[] pointers = new int[n];
        int result = 0 ; 
        Queue<Pair> q = new LinkedList<>();
        for(int i = 0 ; i < n ; i++){
            q.add(new Pair(i , 0));
        }
        for(char c : s.toCharArray()){
            int size = q.size();
            for(int i = 0 ; i < size && !q.isEmpty() ; i++){
                Pair p = q.poll();
                int j = p.idx; 
                int pointer = p.ptr ;
                String word = words[j];
                if(c == word.charAt(pointer)){
                    pointer++ ; 
                }
                if(pointer == word.length()){
                    result++ ; 
                    continue ; 
                }
                q.add(new Pair(j , pointer));
            }
        }
        return result ; 
    } 
    public int numMatchingSubseqI(String s, String[] words) {
        int n = words.length ;
        int[] pointers = new int[n];
        int result = 0 ; 
        for(char c : s.toCharArray()){
            for(int j = 0 ; j < n ; j++){
                String word = words[j];
                if(pointers[j] != -1 && c == word.charAt(pointers[j])){
                    pointers[j]++ ; 
                }
                if(pointers[j] == word.length()){
                    pointers[j] = -1 ; 
                    result++ ; 
                }
            }
        }
        return result ; 
    } 
}
}
