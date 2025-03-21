package PlacementTime.DP;

import java.util.Arrays;

public class CoinChange {
    class Solution {
    int[][] memo ; 
    public int coinChange(int[] coins, int amount) {
        Arrays.sort(coins);
        int n = coins.length ;
        
        memo = new int[n][amount+1];
        for(int[] row : memo) Arrays.fill(row , -1);

        // int res = solve(coins , n-1 , amount);
        // return res == 1e8 ? -1 : res ;
        if(n == 1){
            if(amount%coins[0] == 0){
                return amount/coins[0];
            }else{
                return -1 ;
            }
        }
        int res = tabulation(coins , amount);
        return res == 1e8 ? -1 : res ;
    }
    public int tabulation(int[] coins , int amt){
        int n = coins.length ; 
        // int[][] dp = new int[n][amt+1];
        int[] prev = new int[amt+1];
        int[] curr = new int[amt+1];
        //base case 
        for(int i = 0 ; i <= amt ; i++){
            if(i%coins[0] == 0){
                prev[i] = i/coins[0];
            }else{
                prev[i] = (int)1e8 ; 
            }
        }

        for(int i = 1 ; i < n ; i++){
            for(int tar = 1 ; tar <= amt ; tar++){
                int pick = (int)1e8 ; 
                if(tar >= coins[i]){
                    pick = 1 + curr[tar - coins[i]];
                }
                int notpick = prev[tar];
                curr[tar] = Math.min(pick , notpick);
            }
            prev = Arrays.copyOf(curr , amt+1);
        }
        return prev[amt];
    }
    public int solve(int[] coins , int idx , int amt){
        if(amt == 0){
            return 0 ; 
        }
        if(idx < 0){
            return (int)1e8 ;
        }
        if(memo[idx][amt] != -1) return memo[idx][amt];

        int pick = (int)1e8; 
        if(amt >= coins[idx]){
            // pick = (amt/coins[idx]) + solve(coins , idx-1 , amt%coins[idx]);
            pick = 1 + solve(coins , idx , amt - coins[idx]);
        }
        int notpick = solve(coins , idx-1 , amt);
        return memo[idx][amt] = Math.min(pick , notpick);
    }
}
}
