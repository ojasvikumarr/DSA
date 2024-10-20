package DynamicProgramming;

public class CoinChange {
    public static int Coins(int val[], int W) {
        int n = val.length;
        int dp[][] = new int[n + 1][W + 1];
        for (int i = 0; i < n + 1; i++) {
            dp[i][0] = 1;
        }
        for (int i = 1; i < W + 1; i++) {
            dp[0][i] = 0;
        }

        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < W + 1; j++) {
                int w = val[i - 1];
                if (w <= j) {
                    dp[i][j] += (dp[i][j - w] + dp[i - 1][j]);
                } else {
                    dp[i][j] += dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    public static void printAll(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void main(String[] args) {
        int coins[] = { 1, 2, 5, 10 };
        int sum = 40;
        System.out.println(Coins(coins, sum));
    }

}
