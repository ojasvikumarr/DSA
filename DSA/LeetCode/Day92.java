package LeetCode;

public class Day92 {
    class Solution {
        public String shiftingLetters(String s, int[][] shifts) {
            StringBuilder sb = new StringBuilder();
            int[] freqArr = new int[s.length()+1];
            // for(int[] shift : shifts){
            //     int start = shift[0];
            //     int end = shift[1];
            //     int direction = shift[2] == 0 ? -1 : 1 ;
            //     for(int i = start ; i <= end ; i++){
            //         freqArr[i] += direction ;
            //     }
            // }
            //optimized appraoch to note done frequencies 
            for(int[] shift : shifts){
                if(shift[2] == 1){
                    freqArr[shift[0]]++ ;
                    freqArr[shift[1]+1]-- ;
                }else{
                    freqArr[shift[0]]-- ;
                    freqArr[shift[1]+1]++;
                }
            }
            for(int i = 1 ; i < s.length() ; i++){
                freqArr[i] += freqArr[i-1];
            }
            for(int i = 0 ; i < s.length() ; i++){
                char c = s.charAt(i);
                int moves = freqArr[i];
                int newPos = (c - 'a' + moves%26 + 26) % 26 ;
                // sb.setCharAt(i , (char)('a' + newPos));
                sb.append((char)('a' + newPos));
            }
            return sb.toString();
        }
        public String shiftingLettersII(String s, int[][] shifts) {
            StringBuilder sb = new StringBuilder(s);
            for(int[] shift : shifts){
                int start = shift[0];
                int end = shift[1];
                int direction = shift[2];
                for(int i = start ; i <= end ; i++){
                    char c = sb.charAt(i);
                    if( c == 'z' && direction == 1){
                        sb.setCharAt(i , 'a') ;
                    }else if( c == 'a' && direction == 0){
                        sb.setCharAt(i , 'z') ;
                    }else{
                        sb.setCharAt(i , (char)(c + (direction == 1 ? 1 : -1) )) ;
                    }
                }
            }
            return sb.toString();
        }
    }
}
