package LeetCode;

public class Day101 {
    class Solution {
        public int minimizeXor(int num1, int num2) {
            int n1 = Integer.bitCount(num1);
            int n2 = Integer.bitCount(num2);
            // System.out.println(n1 + " " + n2);
            if(n1 == n2){
                return num1 ;
            }
            if(n1 > n2){
                int rem = n1 - n2 ;
                for(int i = 0 ; i <32; i++){
                    if(rem == 0) return num1 ; 
                    if(((1<<i) & num1) > 0){
                        num1 = (1<<i)^ num1 ; 
                        rem-- ;
                    }
                }
                return num1 ;
            }
            if(n1 < n2){
                int remainginBits = n2 - n1 ; 
                for(int i = 0 ; i < 32  ; i++){
                    if(remainginBits == 0) return num1 ;
                    if(((1<<i) & num1) == 0){
                        num1 = (1<<i) | num1; 
                        remainginBits-- ;
                    }
                    // System.out.println(num1);
                }
                return num1 ;
            }
            return -1 ;
        }
    }
}
