package LeetCode;

public class Day117 {
    class Solution {
        public boolean check(int[] nums) {
            //we should encounter a step down only once 
            int count = 0 ; 
            int n = nums.length ;
            for(int i = 0 ; i < n ; i++){
                if(nums[i] > nums[(i+1)%n]) count++ ; 
            }
            return count <= 1 ;
        }
    }
}
