package PlacementTime.DP;

import java.util.Arrays;

public class CoinChangeII {
    class Solution {
    int[][] memo ; 
    public int change(int amount, int[] coins) {
        //finding all possible ways that the amt can be made using the coins giving or not 
        int n = coins.length ;
        memo = new int[n][amount+1];
        for(int[] row : memo) Arrays.fill(row , -1);
        // return solve(coins , n-1 , amount);
        return tabulation(coins , amount);
    }
    //tabulation approach 
    public int tabulation(int[] coins , int amt){
        int n = coins.length ; 
        int[][] dp = new int[n][amt+1];
        //what will be the base case?
        //if our amt is 0 then we dont need to care 
        // for(int i = 0 ; i < n ; i++) dp[i][0] = 1; 
        //the tabulation table means that 
        //tab[idx][amt] 
        //is it possible to generate amt with coins that have appeared till index idx 
        //this means that at 0th idx if my amount is divisble by coins[0] then there is a way 
        //to generate the amount 
        for(int i = 0 ; i <= amt ; i++){
            if(i % coins[0] == 0){
                // dp[i][coins[0]] = i/coins[0] ;
                dp[0][i] = 1 ;//no. of ways we calculating not no. of coins
            }
        } 
        for(int i = 1 ; i < n ; i++){
            for(int tar = 0;  tar <= amt ; tar++){
                //we either pick it or skip it 
                int pick = 0 ; 
                if(tar >= coins[i]) pick = dp[i][tar-coins[i]];
                int skip = dp[i-1][tar];
                dp[i][tar] = pick + skip ; 
            }
        }
        return dp[n-1][amt];
    }
    public int solve(int[] coins , int idx , int amt){
        //what will be the base case??
        if(idx < 0){
            //no more coins left 
            //all possible combinations explored 
            //no w we check is our amount generated throguht the paths
            if(amt == 0){
                return 1; 
            }
            return 0 ; 
        }
        //top down approach 
        //what do we have?
        //we start from end 
        //we pick a coin and check can we use it to make the amount ?
        //if yes then pick it or dont pick , or we have an option to skip it 
        if(memo[idx][amt] != -1) return memo[idx][amt];
        int pick = 0 ; 
        if(amt >= coins[idx]){
            //that we can pick the coin
            pick = solve(coins , idx , amt - coins[idx]); // am eidx because 
            //we might pic the sam coin again to fulfill my amt 
            //or i skip this coin and use other to fulfill my amt 
        }
        int skipIt = solve(coins , idx-1 , amt);
        return memo[idx][amt] = pick + skipIt ; 
    }
}
}
