package Strings;

public class LargestVariance {
    class Solution {
        public int largestVariance(String s) {
            //Freq array to check whether the character exists in the string or not 
            // int n = s.length() ; 
            int[] freq = new int[26];
            for(char c : s.toCharArray()) freq[c-'a']++ ;
    
            //Now we will try to make all possible pairs in alphabets and chek 
            //If they exits in the string or not 
            int result = 0 ; 
    
            for(int i = 0 ; i < 26 ; i++){
                for(int j = 0 ; j < 26 ; j++){
                    if(freq[i] != 0 && freq[j] != 0){
                        //This means that the characters exists 
                        //Now we need to traverse the string and count the freq
                        int firstCount = 0 ; //For i
                        int secCount = 0 ;  // For j
                        boolean seenBefore = false ;
                        for(char c : s.toCharArray()){
                            if((c-'a') == i){
                                firstCount++ ;
                            }
                            if((c-'a') == j){
                                secCount++ ;
                            }
                            if(secCount > 0){
                                //This means that the second character is present 
                                //As the string having only single char will have 
                                //0 variance 
                                result = Math.max(result , firstCount - secCount);
                            }else if(seenBefore == true && firstCount > 0 && secCount == 0){
                                result = Math.max(result , firstCount - 1);
                            }
                            if(secCount > firstCount){
                                seenBefore = true ; 
                                secCount = 0 ; 
                                firstCount = 0 ; 
                            }
                        }
    
                    }
                }
            }
            return result ;
        }
    }
}
