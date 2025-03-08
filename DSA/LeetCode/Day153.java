package LeetCode;

public class Day153 {
    class Solution {
        public int minimumRecolors(String blocks, int k) {
            int Ws = 0 ; 
            for(int i = 0 ; i < k ; i++){
                char c = blocks.charAt(i) ;
                if(c == 'W') Ws++ ; 
            }
            
            int l = 0 ; 
            int r = k-1 ; 
            int mini = Ws ; 
            while(r+1 < blocks.length()){
                char last = blocks.charAt(r+1);
                char first = blocks.charAt(l);
                if(last == 'W'){
                    Ws++ ; 
                }
    
                if(first == 'W'){
                    Ws-- ; 
                }
                r++ ; 
                l++ ; 
                System.out.println(Ws);
                mini = Math.min(mini , Ws);
            }
            return mini ; 
        }
    }
}
