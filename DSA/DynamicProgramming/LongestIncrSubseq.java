class LongestincrSubseq {
    public int rec(int[] arr, int idx, int prev) {
        if (idx == arr.length) {
            return 0;
        }
        int notTake = rec(arr, idx + 1, prev);
        int Take = Integer.MIN_VALUE;
        if (prev == -1 || arr[idx] < arr[prev]) {
            Take = 1 + rec(arr, idx + 1, idx);
        }
        return Math.max(notTake, Take);
    }

    public int Dp(int[] arr, int idx, int prev, int[][] dp) {
        if (idx == arr.length) {
            return 0;
        }
        if (dp[idx][prev] != -1) {
            return dp[idx][prev];
        }
        int notTake = Dp(arr, idx + 1, prev, dp);
        int Take = Integer.MIN_VALUE;
        if (prev == -1 || arr[idx] < arr[prev]) {
            Take = 1 + rec(arr, idx + 1, idx);
        }
        return dp[idx][prev] = Math.max(notTake, Take);
    }

    public int Tabulation(int[] arr) {
        int[][] dp = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            if (arr[i - 1] > arr[i] && i > 0) {
                dp[0][i] = 1;
            } else {
                dp[0][i] = 0;
            }
            dp[i][0] = 1;
        }
        for (int i = arr.length; i >= 0; i++) {
            for (int j = arr.length; j >= 0; j++) {
                int notTake = dp[i+1][j];
                int Take = Integer.MIN_VALUE;
                if (j == -1 || arr[i] < arr[j]) {
                    Take = 1 + dp[i+1][i];
                }
                dp[i][j] = Math.max(notTake, Take);
            }
        }
        return dp[0][0];
    }
}