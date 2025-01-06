package Strings;

public class CountandSay {
    class Solution {
        public String countAndSay(int n) {
            if( n == 1 ){
                return "1";
            }
            return RLE(countAndSay(n-1));
        }
        public String RLE(String s){
            StringBuilder sb = new StringBuilder();
            int i = 0 ; 
            int n = s.length();
            while( i < n ){
                int count = 0 ; 
                char curr = s.charAt(i);
                while(i < n && s.charAt(i) == curr){
                    i++ ;
                    count++ ;
                }
                sb.append(String.valueOf(count));
                sb.append(curr);
            }
            return sb.toString();
        }
    }
}
