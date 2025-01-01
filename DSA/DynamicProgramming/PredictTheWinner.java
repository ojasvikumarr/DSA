package DynamicProgramming;

import java.util.Arrays;

public class PredictTheWinner {
    class Solution {
    int[][] memo ;
    public boolean predictTheWinner(int[] nums) {
        if(nums.length == 1) return true ;
        memo = new int[nums.length][nums.length];
        for(int[] row : memo) Arrays.fill(row , -1);
        int sum = 0 ; 
        for(Integer num : nums) sum += num ;
        int playerI = solve(0 , nums.length-1 , nums);
        int playerII = sum - playerI ; 
        return playerI >= playerII ;
    }
    public int solve(int i , int j , int[] nums){
        if(i > j) return 0 ; 
        if(i == j) return nums[i];
        if(memo[i][j] != -1) return memo[i][j];
        int takeI = nums[i] + Math.min(solve(i+2 , j , nums) , solve(i+1 , j-1 , nums));
        int takeJ = nums[j] + Math.min(solve(i+1 , j-1 , nums) , solve(i , j-2 , nums));
        return memo[i][j] = Math.max(takeI , takeJ);
    }
}
}
