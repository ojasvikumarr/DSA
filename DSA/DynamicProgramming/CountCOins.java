package DynamicProgramming;

public class CountCOins {
    class Solution {
        int[][] dp ; 
        public int change(int amount, int[] coins) {
            dp = new int[coins.length+1][amount+1];
            // for(int[] row : dp ) Arrays.fill(row , -1);
            for(int i = 0 ; i <= coins.length ; i++){
                dp[i][0] = 1; 
            }
            // dp[coins.length-1][0] = 1; 
    
            for(int idx = coins.length-1 ; idx >= 0 ; idx--){
                for(int sum = 0 ; sum <= amount ; sum++ ){
                    int pick = 0 ; 
                    if(sum - coins[idx] >= 0)
                        pick = dp[idx][sum - coins[idx]];
                    int notpick = dp[idx+1][sum];
                    dp[idx][sum] = pick + notpick ;
                }
            }
            return dp[0][amount] ;
        }
        public int solve(int[] coins , int idx, int sum ){
            if(sum < 0){
                return 0 ;
            }else if(sum == 0){
                return 1 ;
            }
            if(idx == coins.length){
                if(sum == 0){
                    return 1 ; 
                }else{
                    return 0 ; 
                }
            }
    
            if(dp[idx][sum] != -1) return dp[idx][sum];
    
            int pick = solve(coins , idx , sum - coins[idx]);
            int notpick = solve(coins , idx+1 , sum);
            return dp[idx][sum] = pick + notpick ;
        }
    }
}
