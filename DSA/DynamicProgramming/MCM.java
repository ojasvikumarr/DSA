package DynamicProgramming;

public class MCM {
    public static int recur(int i, int j, int n, int[] arr) {
        if (i == j)
            return 0;
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + recur(i, k, n, arr) + recur(k + 1, j, n, arr);
            if (min > steps) {
                min = steps;
            }
        }
        return min;
    }

    public static int DP(int i, int j, int[] arr, int[][] dp) {
        if (i == j)
            return 0;
        if (dp[i][j] != -1)
            return dp[i][j];
        int min = Integer.MAX_VALUE;
        for (int k = i; k < j; k++) {
            int steps = arr[i - 1] * arr[k] * arr[j] + DP(i, k, arr, dp) + DP(k + 1, j, arr, dp);
            if (min > steps) {
                min = steps;
            }
        }
        return dp[i][j] = min;
    }

    public static int Tab(int[] arr) {
        int[][] dp = new int[arr.length][arr.length];
        for (int i = 0; i < arr.length; i++)
            dp[i][i] = 0;

        for (int i = arr.length-1; i >= 1 + 1; i--) {
            for (int j = i+1; j < arr.length; j++) {
                int min = Integer.MAX_VALUE ;
                for(int k = i ; k < j ; k++){
                    int steps = arr[i - 1] * arr[k] * arr[j] + dp[i][k] + dp[k+1][j];
                    if (min > steps) {
                        min = steps;
                    }
                }
                dp[i][j] = min ;
            }
        }
        return dp[1][arr.length-1];                      
    }

    public static int mcm(int[]arr , int n ){
        // int dp[][] = new int[n][n] ; 
        // int ans = DP(1 , arr.length-1 , arr , dp);
        return recur(1 , arr.length-1 , n , arr);
    }

}
