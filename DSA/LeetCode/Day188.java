package LeetCode;

public class Day188 {
    class Solution {
        public int countSymmetricIntegers(int low, int high) {
            int ans = 0 ; 
            for(int i = low ; i <= high ; i++){
                StringBuilder sb = new StringBuilder(String.valueOf(i));
                if(sb.length() % 2 != 0) continue ; 
                int front =0 ; 
                int back = 0 ; 
                for(int j = 0 ; j < sb.length()/2 ; j++){
                    front += sb.charAt(j)-'0';
                    back += sb.charAt(sb.length()-j-1)-'0';
                }
                if(front == back) ans++ ; 
            }
            return ans ; 
        }
    }
}
