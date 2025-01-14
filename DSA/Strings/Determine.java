package Strings;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Determine {
    class Solution {
    public boolean closeStrings(String word1, String word2) {
        int n = word1.length();
        int m = word2.length();
        if (n != m) return false;

        int[] freq1 = new int[26];
        int[] freq2 = new int[26];
        Set<Character> set1 = new HashSet<>();
        Set<Character> set2 = new HashSet<>();

        // Calculate frequencies and unique characters
        // for (char c : word1.toCharArray()) {
        //     freq1[c - 'a']++;
        //     set1.add(c);
        // }
        // for (char c : word2.toCharArray()) {
        //     freq2[c - 'a']++;
        //     set2.add(c);
        // }
        for(int i = 0 ; i < n ; i++){
            freq1[word1.charAt(i)-'a']++;
            set1.add(word1.charAt(i));
            freq2[word2.charAt(i)-'a']++;
            set2.add(word2.charAt(i));
        }
        // Check if unique characters match
        if (!set1.equals(set2)) return false;

        // Check if sorted frequencies match
        Arrays.sort(freq1);
        Arrays.sort(freq2);
        return Arrays.equals(freq1, freq2);
    }
    public boolean closeStringsII(String word1, String word2) {
        int n = word1.length() ; 
        int m = word2.length() ; 

        if(n != m) return false ;

        int[] freq1 = new int[26] ;
        int[] freq2 = new int[26] ;
        List<Integer> ls = new ArrayList<>();
        for(int i = 0 ; i < n ; i++){
            freq1[word1.charAt(i)-'a']++;
            freq2[word2.charAt(i)-'a']++;
            ls.add(word1.charAt(i)-'a');
        }

        for(int i = 0 ; i < n ; i++){
            if(!ls.contains(word2.charAt(i)-'a')) return false ;
        }

        List<Integer> l1 = new ArrayList<>();
        List<Integer> l2 = new ArrayList<>();

        for(int i = 0 ; i < 26 ; i++){
            l1.add(freq1[i]);
        }
        for(int i = 0 ; i < 26 ; i++){
            l2.add(freq2[i]) ;
        }
        Collections.sort(l1);
        Collections.sort(l2);
        for(int i = 0 ; i < 26 ; i++){
            if(l1.get(i) != l2.get(i)) return false ;
        }
        return true ;
    }
} 
}
