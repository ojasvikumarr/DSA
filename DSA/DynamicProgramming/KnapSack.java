package DynamicProgramming;

public class KnapSack {
    public static int Sack(int val[], int wt[], int W, int idx, int[][] dp) {
        if (W == 0 || idx == 0) {
            return 0;
        }
        if (dp[idx][W] != -1) {
            return dp[idx][W];
        }
        if (W > wt[idx - 1]) {
            // include
            int ans1 = val[idx] + Sack(val, wt, W - wt[idx], idx - 1, dp);
            // exclude
            int ans2 = Sack(val, wt, W, idx - 1, dp);
            dp[idx][W] = Math.max(ans1, ans2);
            return dp[idx][W];
        } else {
            return Sack(val, wt, W, idx - 1, dp);
        }
    }

    public static int Tabulation(int val[], int wt[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 0;
        }
        for (int i = 0; i < W + 1; i++) {
            dp[0][i] = 0;
        }
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int v = val[i - 1];
                int w = wt[i - 1];
                if (w <= j) {
                    int incProfit = v + dp[i - 1][j - w];
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = Math.max(incProfit, excProfit);
                } else {
                    // w >= j
                    int excProfit = dp[i - 1][j];
                    dp[i][j] = excProfit;
                }
            }
        }
        return dp[n][W];
    }

    public static void main(String[] args) {
        int val[] = { 15, 14, 10, 45, 30 };
        int wt[] = { 2, 5, 1, 3, 4 };
        int W = 7;
        int dp[][] = new int[val.length + 1][W + 1];
        for (int i = 0; i < dp.length; i++) {
            for (int j = 0; j < dp[0].length; j++) {
                dp[i][j] = -1;
            }
        }
        System.out.println("The knapSack will be ; " + Sack(val, wt, W, val.length, dp));
    }


    public static int Knap(int idx , int w , int wt[] , int val[]){
        if(idx == 0){
            if(wt[idx] <= w){
                return val[idx];
            }
            else{
                return 0 ;
            }
        }
        int notTake = Knap(idx-1, w, wt, val);
        int take = Integer.MIN_VALUE ;
        if(val[idx] <= w){
            take = Knap(idx-1, w-wt[idx], wt, val) + val[idx];
        }
        return Integer.max(take , notTake);

    }
    public static int TabKnap (int w , int wt[] ,int val[]){
        int[][] dp = new int[wt.length][val.length];
        for(int i = 0 ; i < wt.length ; i++){
            dp[0][i] = 0 ; 
        }

        for(int idx = 1 ; idx < wt.length ; idx++){
            for(int wtt = 0 ; wtt < w ; wtt++){
                int notTake = 0 + dp[idx-1][w];
                int Take = Integer.MIN_VALUE;
                if(wtt > wt[idx]){
                    Take = val[idx]+ dp[idx-1][w];
                }
                dp[idx][wtt] = Integer.max(notTake , Take);
            }
        }
        return dp[wt.length-1][w];
    }
    public static int SpaceOptTabKnap (int w , int wt[] ,int val[]){
        int[] prev = new int[w+1];
        // int[] curr = new int[w+1];
        for(int i = 0 ; i < w+1 ; i++){
            prev[i] = val[i];
        }

        for(int idx = 1 ; idx < wt.length ; idx++){
            for(int wtt = 0 ; wtt < w ; wtt++){
                int notTake = 0 + prev[wtt];
                int Take = Integer.MIN_VALUE;
                if(wtt > wt[idx]){
                    Take = val[idx]+ prev[wtt - wt[idx]];
                }
                prev[wtt]  = Integer.max(notTake , Take);
            }
        }
        return prev[w];
    }

}
