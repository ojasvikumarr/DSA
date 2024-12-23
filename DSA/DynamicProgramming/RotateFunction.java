package DynamicProgramming;

public class RotateFunction {
    class Solution {
        public int maxRotateFunction(int[] nums) {
            //tabulation 
            int n = nums.length ;
            int[] dp = new int[n+1];
            int F0 = 0 ; 
            int sum = 0 ; 
            for(int i = 0 ; i < n ; i++){
                sum += nums[i];
                F0 += i*nums[i];
            }
            dp[0] = F0 ;
            int maxi = Integer.MIN_VALUE ;
            for(int i = 1 ; i <= n ; i++){
                dp[i] = dp[i-1] + sum - n*nums[n-i];
                maxi = Math.max(maxi , dp[i]);
            }
            return maxi == Integer.MIN_VALUE ? 0 : maxi ;
        }
    }
}
