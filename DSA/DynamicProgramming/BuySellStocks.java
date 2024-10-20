package DynamicProgramming;

import java.util.Arrays;

public class BuySellStocks {
    public int maxProfit(int[] prices) {
        int[][] dp = new int[prices.length][2];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j] = -1;
            }
        }
        return recurr(prices, 0, 1, dp);
    }

    public int recurr(int[] prices, int idx, int buy, int[][] dp) {
        if (idx == prices.length) {
            return 0;
        }
        if (dp[idx][buy] != -1) {
            return dp[idx][buy];
        }
        int profit = 0;
        if (buy == 1) {
            profit = Math.max(-prices[idx] + recurr(prices, idx + 1, 0, dp), 0 + recurr(prices, idx + 1, 1, dp));
        } else {
            profit = Math.max(prices[idx] + recurr(prices, idx + 1, 1, dp), 0 + recurr(prices, idx + 1, 0, dp));
        }
        return dp[idx][buy] = profit;
    }

    public int Tab(int[] prices) {
        int[] back = new int[2];
        int[] front = new int[2];
        back[0] = back[1] = 0; // bottom up
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                int profit = 0;
                if (buy == 1) {
                    profit = Math.max(-prices[idx] + back[0],
                            0 + back[1]);
                } else {
                    profit = Math.max(prices[idx] + back[1], 0 + back[0]);
                }
                front[buy] = profit;
            }
            back[0] = front[0];
            back[1] = front[1];
        }
        return back[1];
    }

    // buy and sell stock III

    public int maxxProfit(int[] prices) {
        int[][][] dp = new int[prices.length][2][3];
        for (int i = 0; i < prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }
        return Dp(prices, 0, 1, 4, dp);
    }

    public static int Dp(int[] prices, int idx, int buy, int count, int[][][] dp) {
        if (idx == prices.length) {
            return 0;
        }
        if (dp[idx][buy][count] != -1) {
            return dp[idx][buy][count];
        }
        if (buy == 1 && count > 0) {
            return dp[idx][buy][count] = Math.max(-prices[idx] + Dp(prices, idx + 1, 0, count, dp),
                    0 + Dp(prices, idx + 1, 1, count, dp));
        }
        return dp[idx][buy][count] = Math.max(+prices[idx] + Dp(prices, idx + 1, 1, count - 1, dp),
                0 + Dp(prices, idx + 1, 0, count, dp));

    }

    public int maxxxProfit(int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n][2][3]
        int[][][] dp = new int[n][2][3];

        // Initialize the dp array with -1
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 2; j++) {
                Arrays.fill(dp[i][j], -1);
            }
        }

        // Calculate and return the maximum profit
        return getAns(prices, n, 0, 0, 2, dp);
    }

    public int getAns(int[] Arr, int n, int ind, int buy, int cap, int[][][] dp) {
        // Base case: If we have processed all stocks or have no capital left, return 0
        // profit
        if (ind == n || cap == 0)
            return 0;

        // If the result for this state is already calculated, return it
        if (dp[ind][buy][cap] != -1)
            return dp[ind][buy][cap];

        int profit = 0;

        if (buy == 0) { // We can buy the stock
            profit = Math.max(0 + getAns(Arr, n, ind + 1, 0, cap, dp),
                    -Arr[ind] + getAns(Arr, n, ind + 1, 1, cap, dp));
        }

        if (buy == 1) { // We can sell the stock
            profit = Math.max(0 + getAns(Arr, n, ind + 1, 1, cap, dp),
                    Arr[ind] + getAns(Arr, n, ind + 1, 0, cap - 1, dp));
        }

        // Store the calculated profit in the dp array and return it
        return dp[ind][buy][cap] = profit;
    }

    public static int WrondoneTaboolation(int[] prices) {
        int[][][] dp = new int[prices.length + 1][2][3];// 2+1
        // cap = 0
        for (int i = 0; i <= prices.length; i++) {
            for (int j = 0; j < 2; j++) {
                dp[i][j][0] = 0;
            }
        }
        // idx = 0
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j <= 2; j++) {
                dp[0][i][j] = 0;
            }
        }
        for (int idx = prices.length - 1; idx >= 0; idx--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {
                    int profit = 0;

                    if (buy == 0) { // We can buy the stock
                        profit = Math.max(0 + dp[idx + 1][0][cap],
                                -prices[idx] + dp[idx + 1][1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        profit = Math.max(0 + dp[idx + 1][1][cap],
                                prices[idx] + dp[idx + 1][0][cap - 1]);
                    }

                    // Store the calculated profit in the dp array and return it
                    dp[idx][buy][cap] = profit;
                }
            }
        }
        return dp[0][0][2];
    }


    public int CoreectedOnemaxProfit(int[] prices) {
        int n = prices.length;

        // Creating a 3D dp array of size [n+1][2][3] initialized to 0
        int[][][] dp = new int[n + 1][2][3];

        // Loop through the dp array, starting from the second last stock (ind=n-1)
        for (int ind = n - 1; ind >= 0; ind--) {
            for (int buy = 0; buy <= 1; buy++) {
                for (int cap = 1; cap <= 2; cap++) {

                    if (buy == 0) { // We can buy the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][0][cap],
                                -prices[ind] + dp[ind + 1][1][cap]);
                    }

                    if (buy == 1) { // We can sell the stock
                        dp[ind][buy][cap] = Math.max(0 + dp[ind + 1][1][cap],
                                prices[ind] + dp[ind + 1][0][cap - 1]);
                    }
                }
            }
        }

        // The maximum profit with 2 transactions is stored in dp[0][0][2]
        return dp[0][0][2];

    }

    

}
