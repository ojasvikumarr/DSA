package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Day91 {
    class Solution {
    @SuppressWarnings({ "unchecked", "rawtypes" })
    public int countPalindromicSubsequence(String s) {
        Set<Character> letters = new HashSet();
        for (Character c: s.toCharArray()) {
            letters.add(c);
        }
        
        int ans = 0;
        for (Character letter : letters) {
            int i = -1;
            int j = 0;
            
            for (int k = 0; k < s.length(); k++) {
                if (s.charAt(k) == letter) {
                    if (i == -1) {
                        i = k;
                    }
                    
                    j = k;
                }
            }
            
            Set<Character> between = new HashSet();
            for (int k = i + 1; k < j; k++) {
                between.add(s.charAt(k));
            }
            
            ans += between.size();
        }
        
        return ans;
    }

    public int countPalindromicSubsequenceII(String s) {
        // int counter = 0 ; 
        int n = s.length();
        Set<String> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j = i+2 ; j < n ; j++){
                if(s.charAt(i) == s.charAt(j)){
                    for(int k = i+1 ; k < j ; k++){
                        String key = s.charAt(i) +","+ s.charAt(k) +","+ s.charAt(j);
                        if(!set.contains(key)) set.add(key);
                    }
                }
            }
        }
        return set.size();
    }
}
}
