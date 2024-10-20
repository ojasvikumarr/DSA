package DynamicProgramming;

public class UnboundedKnapSack {
    public static int unboundedSack(int wt[], int val[], int W) {
        int n = val.length;
        int dp[][] = new int[val.length + 1][wt.length + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                // include
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {
                    int incProfit = v + dp[i][j - w];// the only change is here as we are allowing the previous elements
                                                     // to be selected numerous numbers of time
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    // exclude
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {

    }

    public static int recurr(int[] wt , int[] val , int idx , int w){
        if(idx == 0){
                return (val[idx]/wt[idx])*w ;
        }
        int notPick = recurr(wt, val, idx, w);
        int Pick = Integer.MIN_VALUE ;
        if(wt[idx] <= w){
            Pick = recurr(wt, val, idx, w - wt[idx]) + val[idx];
        }
        return Math.max(notPick , Pick);
    }

    public static int Tab(int[] wt , int[] val , int W){
        int[][] dp = new int[wt.length+1][W];
        for(int i = 0 ; i <= wt.length ; i++){
            dp[0][i] = (val[i]/wt[i])*W ;
        }
        for(int idx = 1 ; idx < wt.length ; idx++){
            for(int w = 0 ; w <= W ; w++){
                int notPick = 0 + dp[idx-1][w];
                int Pick = Integer.MIN_VALUE ;
                if(wt[idx] <= w){
                    Pick = val[idx] + dp[idx][w];
                }
                dp[idx][w] = Math.max(Pick , notPick);
            }
        }
        return dp[wt.length-1][W];
    }   
}
