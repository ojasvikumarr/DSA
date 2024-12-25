package DynamicProgramming;

public class WrapAroundStr {
    class Solution {
        public int findSubstringInWraproundString(String p) {
            int[] freq = new int[26];
            int maxLength = 0 ; 
            for(int i = 0 ; i < p.length() ; i++){
                if( i > 0 && ( p.charAt(i) - p.charAt(i-1) == 1 || p.charAt(i) - p.charAt(i-1) == -25)){
                    maxLength++ ;
                }else{
                    maxLength = 1 ;
                }
                int idx = p.charAt(i) - 'a';
                //Storing the freq that is maximum , either a prev calculated substring is longer or the 
                //current one is longer (longer substr will contain the shorter substr as they       end              withsame char)
                freq[idx] = Math.max(freq[idx] , maxLength);
            }
            int sum = 0 ; 
            for(int i = 0 ; i < 26 ; i++){
                sum += freq[i];
            }
            return sum ;
        }
    }
}
