package SlidingWindow;

public class countBinaryStringsJPMC {
    class Solution {
        public int countBinarySubstrings(String s) {
            int i = 0 ; 
            int n = s.length();
            int zero = 0 ; 
            int one = 0 ; 
            int res = 0 ; 
            while(i < n){
                if(s.charAt(i) == '0') zero++ ; 
                else one++ ; 
                i++ ; 
                while(i < n && s.charAt(i) == s.charAt(i-1)){
                    if(s.charAt(i) == '0') zero++ ; 
                    else one++ ; 
                    i++ ;
                }
                if(zero != 0 && one != 0){
                    res += Math.min(zero , one);
                    if(s.charAt(i-1) == '0'){
                        one = 0 ; 
                    }else{
                        zero = 0 ; 
                    }
                }
            }
            return res ; 
        }
    }
}
