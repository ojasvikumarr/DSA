package LeetCode ; 

public class Day98{
    class Solution {
        public boolean canConstruct(String s, int k) {
            if(k > s.length()) return false ;
            if(k == s.length()) return true ;
            int[] freqArr = new int[26];
            int bitFreq = 0 ; 
            for(char c : s.toCharArray()){
                freqArr[c-'a']++ ;
                bitFreq ^= 1<<(c-'a');
            }
            int odds = 0 ; 
            for(int i = 0; i < 26 ; i++){
                if(freqArr[i] % 2 != 0) odds++ ;
            }
            // return odds <= k ;
            return Integer.bitCount(bitFreq) <= k ;
        }
    }
}