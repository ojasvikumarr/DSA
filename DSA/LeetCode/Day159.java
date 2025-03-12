package LeetCode ; 
public class Day159 {
    class Solution {
        public int maximumCount(int[] nums) {
            int pos = 0 ; 
            int neg = 0 ; 
            for(Integer it : nums){
                if(it > 0) pos++ ; 
                else if(it < 0) neg++ ;
            }
            return Math.max(pos , neg);
        }
    }
}
