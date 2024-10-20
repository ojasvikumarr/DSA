package DynamicProgramming;

public class GridTriangle {
    public static int Recursion(int i , int j , int[][] triangle , int n){
        if(i == n-1){
            return triangle[n-1][j];
        }

        int down = Recursion(i+1, j, triangle, n) + triangle[i][j];
        int diagonal = Recursion(i+1, j+1, triangle, n) + triangle[i][j];

        return Math.min(down , diagonal);
    }

    public static int Dp(int i , int j , int[][] triangle , int[][] dp){
        if(i == triangle.length-1){
            return triangle[i][j];
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        int down = Dp(i+1, j, triangle, dp) + triangle[i][j];
        int diagonal = Dp(i+1, j+1, triangle, dp) + triangle[i][j];

        return dp[i][j] = Math.min(down , diagonal);
    }

    public static int Tabulation(int[][] triangle){
        // int[][] dp = new int[triangle.length][triangle]
        int n = triangle.length ;
        int dp[][] = new int[n][n];

        // Initialize the bottom row of dp with the values from the bottom row of the triangle
        for (int j = 0; j < n; j++) {
            dp[n - 1][j] = triangle[n - 1][j];
        }

        // Starting from the second to last row, calculate the minimum path sum for each element
        for (int i = n - 2; i >= 0; i--) {
            for (int j = i; j >= 0; j--) {
                // Calculate the two possible paths: moving down or moving diagonally
                int down = triangle[i][j] + dp[i + 1][j];
                int diagonal = triangle[i][j] + dp[i + 1][j + 1];

                // Store the minimum of the two paths in dp
                dp[i][j] = Math.min(down, diagonal);
            }
        }

        // The result is stored at the top of dp array
        return dp[0][0];
    }
}
