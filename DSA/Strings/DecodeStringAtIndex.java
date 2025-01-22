package Strings;

public class DecodeStringAtIndex {
    class Solution {
        public String decodeAtIndex(String s, int K) {
            long size = 0 ; 
            //is alphabet then add 1 if number then multiply with it 
            int n = s.length();
            for(int i = 0 ; i < n ; i++){
                if(isDigit(s.charAt(i))){
                    size *= (s.charAt(i)-'0');
                }else{
                    size++ ;
                }
            }
            long k = K ;
            for(int i = n-1 ; i >= 0 ; i--){
                k = k%size ; 
                char c = s.charAt(i);
                if(k == 0 && isAlpha(c)){
                    return ""+c ;
                }
                if(isAlpha(c)){
                    size-- ;
                }
                if(isDigit(c)){
                    size = size/(c-'0');
                }
            }
    
            return "";
        }
        public boolean isAlpha(Character c){
            return (c-'a' >= 0) && (c-'a' <= 25);
        }
        public boolean isDigit(Character c){
            return( c-'0' <= 9) &&( c-'0' >= 0) ;
        }
    }
}
