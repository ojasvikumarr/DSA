package Graphs;

import java.util.Arrays;

public class HouseRobberII {
    class Solution {
    private int[][] dp ;
    public int rob(int[] nums) {
        dp = new int[nums.length][2];
        if(nums.length == 1) return nums[0];
        for(int[] row : dp) Arrays.fill(row , -1);
        int firstHouse = solve(0 , nums , 1);
        int secHouse = solve(1 , nums , 0);
        return Math.max(firstHouse , secHouse);
    }
    public int solve(int idx, int[] nums ,int house){
        if(idx >= nums.length - house) return 0 ; 
        if(dp[idx][house] != -1) return dp[idx][house];
        int pick = nums[idx] + solve(idx+2 , nums , house);
        int notPick = solve(idx+1 , nums , house);
        return dp[idx][house] = Math.max(pick , notPick);
    }

}
}
