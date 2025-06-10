import java.nio.Buffer;
import java.io.* ;
import java.util.* ; 
import java.lang.StringBuilder ; 
import java.util.Arrays ;
public class cp108 {
   
    public long maximumProfit(int[] prices, int k) {
        // dp[i][j][k] = max profit that i can make till day i , using atmost k txn
        // with buy status of 0 1 2 
        // buy 
        // - 0 : we are in txn , buying
        // - 1 : we are in txn , selling
        // - 2 : we can start a new txn
        int n = prices.length ; 
        int[][][] dp = new int[n+1][3][k+1];
        for(int i = n-1 ; i >= 0 ; i--){
            for(int buy = 0 ; buy <= 2; buy++){
                for(int K = 1 ; K <= k ; K++){
                    int price = prices[i];
                    int pick = 0 ;
                    if(buy == 0){
                        //complete the txn , it a buy one , so rn sell it 
                        pick = price + dp[i+1][2][K-1];
                    }else if(buy == 1){
                        //complete the txn , it a sell one , so rn buy it
                        pick = -price + dp[i+1][2][K-1];
                    }else{
                        int buyy = -price + dp[i+1][0][K];
                        int sell = price + dp[i+1][1][K];
                        price = Math.max(buyy , sell);
                    }
                    int notpick = 0 + dp[i+1][buy][K];
                    dp[i][buy][K] = Math.max(pick , notpick);
                }
            }
        }
        return dp[0][2][k];
    }
}

