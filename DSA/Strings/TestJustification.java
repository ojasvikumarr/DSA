package Strings;

import java.util.ArrayList;
import java.util.List;

public class TestJustification {
    class Solution {
    public List<String> fullJustify(String[] words, int maxWidth) {
        List<String> result = new ArrayList<>();
        //Approach will be to add all possible words in the set 
        //then adjust spaces between them as needed 
        //we aill add one extra space with the words 
        //We will calculate the no. of words that cna be inserted in the line beforeHand 
        //then we will add the desired words with the required spacing it 

        //While dividing the extra space we will be dividing the space between 
        //desired words -1 
        //as we are making justified alignment 

        int n = words.length ; 
        int i = 0 ; 
        while( i < n ){
            //Calculate numbre of words that can fit maxWidth
            int sumLen = 0 ; 
            int j = i ; 
            while( j < n && sumLen + words[j].length() + (j - i) <= maxWidth){
                sumLen += words[j].length() ; 
                j++ ;
            }
            //Now we know the length 
            //Either we can include the last word 
            //Or we need to exclude the last word completely 
            //And adjust the length in spaces 
            int spaces = maxWidth - sumLen ; 
            int numWords = j - i ;

            StringBuilder sb = new StringBuilder();
            //If it is the last line or there is only a single word in the line
            if(j == n || numWords == 1){
                for(int k = i ; k < j ; k++){
                    sb.append(words[k]);
                    if(k < j-1) sb.append(" ");
                }
                while(sb.length() < maxWidth) sb.append(" ");
            }else{
            //Else we need to distribute the spaces evenly between the words selected 
                int spacesPerWord = spaces / (numWords - 1);
                int extraSpaces = spaces % (numWords-1);

                for(int k = i ; k < j ; k++){
                    sb.append(words[k]);
                    if(k < j-1){
                        for(int h = 0 ; h < spacesPerWord ; h++){
                            sb.append(" ");
                            if(extraSpaces > 0){
                                sb.append(" ");
                                extraSpaces-- ;
                            }
                        }
                    }
                }
            }

            result.add(sb.toString());
            i = j ; 

            
        }
        return result ;
    }
}
}
