package DynamicProgramming;

public class Coins {
    public static int Recurr(int[] coins , int target , int idx){
        if(idx == 0){
            if(target%coins[idx] == 0){
                return target%coins[idx];
            }else{
                return (int)1e9 ;
            }
        }
        int notTake = 0 + Recurr(coins, target, idx-1);
        int Take = Integer.MAX_VALUE ;
        if(coins[idx] <= target){
            Take = 1 + Recurr(coins, target - coins[idx], idx-1);
        }

        return Math.min(Take , notTake);
    }
    public static int Dp(int[] coins , int target , int idx , int[][] DP){
        if(idx == 0){
            if(target%coins[idx] == 0){
                return target/coins[idx];
            }else{
                return (int)1e9 ;
            }
        }
        if(DP[idx][target] != -1){
            return DP[idx][target];
        }
        int notTake = 0 + Dp(coins, target, idx-1 , DP);
        int Take = Integer.MAX_VALUE ;
        if(coins[idx] <= target){
            Take = 1 + Dp(coins, target - coins[idx], idx-1 , DP);
        }

        return DP[idx][target] = Math.min(Take , notTake);
    }
    

    public static int Tab(int[] coins ,int target){
        int[][] dp = new int[coins.length+1][target+1];
        for(int i = 0 ; i <= coins.length ; i++){
            dp[0][i] = 0 ; 
        }
        for(int idx = 1 ; idx <= coins.length ; idx++){
            for(int T = 0 ; T <= target ; T++){
                int notTake = 0 + dp[idx-1][T];
                int Take = Integer.MAX_VALUE ;
                if(coins[idx] <= T){
                    Take = dp[idx][T-coins[idx]] + 1 ;
                }
                dp[idx][T] = Math.max(notTake , Take);
            }
        }
        return dp[coins.length-1][target];
    }


    public static int spaceOptTab(int[] coins ,int target){

        int[] prev = new int[coins.length];
        int[] curr = new int[coins.length];

        for(int i = 0 ; i <= coins.length ; i++){
            prev[i] = 0 ; 
        }
        for(int idx = 1 ; idx <= coins.length ; idx++){
            for(int T = 0 ; T <= target ; T++){
                int notTake = 0 + prev[T];
                int Take = Integer.MAX_VALUE ;
                if(coins[idx] <= T){
                    Take = prev[T-coins[idx]] + 1 ;
                }
                curr[T] = Math.max(notTake , Take);
            }
            prev = curr ;
        }
        return prev[target];
    }
    public static int SuperSpaceOptTab(int[] coins ,int target){

        int[] prev = new int[coins.length];
        // int[] curr = new int[coins.length];

        for(int i = 0 ; i <= coins.length ; i++){
            prev[i] = 0 ; 
        }
        for(int idx = 1 ; idx <= coins.length ; idx++){
            for(int T = 0 ; T <= target ; T++){
                int notTake = 0 + prev[T];
                int Take = Integer.MAX_VALUE ;
                if(coins[idx] <= T){
                    Take = prev[T-coins[idx]] + 1 ;
                }
                prev[T] = Math.max(notTake , Take);
            }
        }
        return prev[target];
    }
}
