package Strings;

public class checkString {
    class Solution {
        public boolean hasSameDigits(String S) {
            StringBuilder s = new StringBuilder(S);
            while(s.length() != 2){
                StringBuilder sb = new StringBuilder();
                for(int i = 0 ; i < s.length()-1 ; i++){
                    int a = s.charAt(i) - '0';
                    int b = s.charAt(i+1) - '0';
                    sb.append((a+b)%10);
                }
                // System.out.println(s);
                s = sb ; 
            }
            return s.charAt(0) == s.charAt(1);
        }
    }
}
