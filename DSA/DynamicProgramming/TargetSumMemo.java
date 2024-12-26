package DynamicProgramming;

import java.util.Arrays;

public class TargetSumMemo {
    class Solution {
    int[][] memo ;
    static int mod = (int) (Math.pow(10, 9) + 7);
    public int findTargetSumWays(int[] num, int targetsum) {
        int n = num.length;
        int sum = 0 ; 
        for(Integer nu : num){
            sum += nu ;
        }
        if ((sum - targetsum) < 0 || (sum - targetsum) % 2 != 0) return 0;
        int tar = (sum - targetsum)/2 ;

        int[][] dp = new int[n][tar + 1];

        if (num[0] == 0)
            dp[0][0] = 2; 
        else
            dp[0][0] = 1; 

        if (num[0] != 0 && num[0] <= tar)
            dp[0][num[0]] = 1; 

        for (int ind = 1; ind < n; ind++) {
            for (int target = 0; target <= tar; target++) {
                int notTaken = dp[ind - 1][target];

                int taken = 0;
                if (num[ind] <= target)
                    taken = dp[ind - 1][target - num[ind]];

                dp[ind][target] = (notTaken + taken) % mod;
            }
        }

        return dp[n - 1][tar];
    }
    public int findTargetSumWaysII(int[] nums, int target) {
        int sum = 0 ;
        for(Integer num : nums){
            sum += num ;
        }
        //We need to find that x = 1/2*(sum - target)
        // if((sum-target)/2 != (double)(sum - target)/2) return 0 ;
        if(sum < target || (sum-target)%2 != 0) return 0;

        int tarSum = (sum-target)/2 ;

        memo = new int[nums.length+1][tarSum+1];
        for(int[] row : memo) Arrays.fill(row , -1);
        return solve(nums , 0 , tarSum);
    }
    public int solve(int[] nums , int idx , int sum){
        if(sum < 0) return 0 ; 
        if(idx == nums.length){
            if(sum == 0) return 1 ;
            else{
                return 0 ;
            }
        }
        if(memo[idx][sum] != -1) return memo[idx][sum];

        int pick = solve(nums , idx+1 , sum - nums[idx]);
        int notpick = solve(nums , idx+1 , sum);

        return memo[idx][sum] = pick + notpick ;
    }
}
}
