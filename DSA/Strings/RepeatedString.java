package Strings;

public class RepeatedString {
    class Solution {
        public boolean repeatedSubstringPattern(String s) {
            // if(s.length() % 2 != 0) return false ;
            int n = s.length() ;
            StringBuilder sb = new StringBuilder();
            for(int i = 0 ; i < n/2 ; i++){
                sb.append(s.charAt(i));
                int prevLength = sb.length(); //for backup if we need to revert 
                if(s.length() % sb.length() == 0){
                    int multiply = (s.length()/sb.length()) -1 ; 
                    //-1 because one time its already there
                    String pattern = sb.toString();
                    while(multiply-- > 0){
                        sb.append(pattern);
                    }
                    //Now the string is ready 
                    //check 
                    if(s.equals(sb.toString())){
                        return true ;
                    }else{
                        sb.setLength(prevLength);
                    }
                }
            }
            return false ;
        }
    
    }
}
