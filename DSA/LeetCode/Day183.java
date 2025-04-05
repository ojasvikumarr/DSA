package LeetCode;

public class Day183 {
    class Solution {
        public int subsetXORSum(int[] nums) {
            return solve(nums , nums.length-1 , 0);
        }
        public int solve(int[] nums , int idx , int xor){
            if(idx < 0){
                return xor ; 
            }
            //pick 
            int pick = solve(nums , idx-1 , xor^nums[idx]);
            //not pick 
            int notPick = solve(nums , idx-1 , xor);
            return pick + notPick ; 
        }
    }
}
