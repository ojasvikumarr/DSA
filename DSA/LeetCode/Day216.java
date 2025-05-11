package LeetCode;

public class Day216 {
    class Solution {
        public boolean threeConsecutiveOdds(int[] arr) {
            int count = 0 ; 
            int maxi = 0 ; 
            for(int ele : arr){
                if(ele % 2 != 0){
                    count++ ; 
                }else{
                    count = 0 ; 
                }
                maxi = Math.max(maxi , count);
            }
            return maxi >= 3 ; 
        }
    }
}
