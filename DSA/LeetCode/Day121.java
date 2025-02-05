package LeetCode;

public class Day121 {
    class Solution {
        public boolean areAlmostEqual(String s1, String s2) {
            int[] freqA = new int[26];
            int[] freqB = new int[26];
    
            int n = s1.length();
            int m = s2.length();
            if(n != m) return false ;
            int count = 0 ; 
            for(int i = 0 ; i < n ; i++){
                if(s1.charAt(i) != s2.charAt(i)) count++ ; 
    
                freqA[s1.charAt(i)-'a']++ ;
                freqB[s2.charAt(i)-'a']++ ;
            }
    
            for(int i = 0 ; i < 26 ; i++){
                if(freqA[i] != freqB[i]) return false ;
            }
    
            return count == 2|| count == 0 ? true : false ;
        }
    }
}
