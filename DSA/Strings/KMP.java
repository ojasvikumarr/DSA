package Strings;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

public class KMP {
    class Solution {
    public List<String> stringMatching(String[] words) {
        int n = words.length ;
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if( i == j ) continue ;
                // if(words[j].contains(words[i])){
                if(KMP(words[i] , words[j])){
                    set.add(words[i]);
                }
            }
        }
        for(String str : set) ans.add(str);
        return ans ;

    }
    public List<String> stringMatchingIII(String[] words) {
        int n = words.length ;
        List<String> ans = new ArrayList<>();
        HashSet<String> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if( i == j ) continue ;
                if(words[j].contains(words[i])){
                    set.add(words[i]);
                }
            }
        }
        for(String str : set) ans.add(str);
        return ans ;
    }
    public boolean find(String s , String p){
        if(s.length() > p.length()) return false;
        // if(s.equals(p)) return true ; As all words are unique 
        int i = 0 ; 
        int j = 0 ; 
        while(i < s.length() && j < p.length()){
            int posi = j ;
            while(i < s.length() && j < p.length() && s.charAt(i) == p.charAt(j)){
                i++ ;
                j++ ;
            }
            if(i == s.length()) break ;
            else{
                i = 0 ;
                j = posi ;
            }
            j++ ;
        }
        return i == s.length() ? true : false ;
    }
    public boolean KMP(String pattern , String txt){
        int[] lps = new int[pattern.length()];
        constructLps(pattern , lps);
        int i = 0 ; 
        int j = 0 ; 
        while( i < txt.length() ){
            if(pattern.charAt(j) == txt.charAt(i)){
                i++ ; 
                j++ ; 
                if( j == pattern.length() ){
                    return true ; 
                }
            }else{
                if(j != 0){
                    j = lps[j-1];
                }else{
                    i++ ;
                }
            }
        }
        return false ;
    }
    public void constructLps(String pattern , int[] lps){
        lps[0] = 0 ; 
        int len = 0 ; 
        int i = 1 ;
        while(i < pattern.length()){
            if(pattern.charAt(i) == pattern.charAt(len)){
                len++ ;
                lps[i] = len ;
                i++ ;
            }else{
                if(len != 0){
                    len = lps[len-1];
                }else{
                    lps[i] = 0 ; 
                    i++ ; 
                }
            }
        }
    }
}
}
