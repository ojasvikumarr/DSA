package Strings ; 
public class isCapital{
    class Solution {
        public boolean detectCapitalUse(String word) {
            //System.out.println('A'-'a'); --> -32 right 
            // And 'a' - 'z' == 25
            //COunt number of 35s coming the word willdetermine the answer 
            int count = 0 ; 
            String WORD = word.toUpperCase();
            for(int i = 0; i < word.length() ; i++){
                char c = word.charAt(i) ;
                char C = WORD.charAt(i) ;
                if((c - C) == 0) count++ ;
            }
    
            if(count == word.length() || count == 0){
                return true ;
            }else if(count == 1 && word.charAt(0) - WORD.charAt(0) == 0){
                return true ;
            }
            return false ;
        }
    }
}