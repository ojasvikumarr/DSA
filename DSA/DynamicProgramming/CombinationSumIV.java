package DynamicProgramming;

import java.util.Arrays;

public class CombinationSumIV {
    class Solution {
    int[] memo ;
    public int combinationSum4(int[] nums, int target) {
        memo = new int[target + 1];
        Arrays.fill(memo , -1);
        return solve(nums , target);
    }
    public int solve(int[] nums, int target){
        if(target == 0) return 1 ;
        if(target < 0) return 0 ;
        if(memo[target] != -1) return memo[target];
        int ans = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            ans += solve(nums , target - nums[i]);
        }
        return memo[target] =  ans ;
    }
}
}
