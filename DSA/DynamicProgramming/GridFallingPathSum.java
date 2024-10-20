package DynamicProgramming;

import java.util.Arrays;

public class GridFallingPathSum {
    public static int Recursion(int[][] matrix , int i , int j , int n , int m ){
        if(i == 0){
            return matrix[i][j];
        }
        if(j < 0 || j > m){
            return Integer.MAX_VALUE ;
        }
        int up = matrix[i][j] + Recursion(matrix, i-1, j, n, m);
        int diagonalLeft = matrix[i][j] + Recursion(matrix, i-1, j-1, n, m);
        int diagonalRight = matrix[i][j] + Recursion(matrix, i-1, j+1, n, m);

        return Math.min(up , Math.min(diagonalLeft , diagonalRight));
    }

     public int minFallingPathSum(int[][] matrix) {
        int m = matrix.length;
        int n = matrix[0].length;

        if (m == 1 || n == 1) return matrix[0][0];

        int[][] dp = new int[m][n];
        for (int[] row : dp) {
            Arrays.fill(row, Integer.MAX_VALUE);
        }
        
        int ans = Integer.MAX_VALUE;

        for (int i = 0; i < matrix.length; ++i) {
            ans = Math.min(ans, minFallingPathSum(matrix, 0, i, dp));
        }

        return ans;
    }
    private int minFallingPathSum(int[][] A, int row, int col, int[][] dp) {
        int m = A.length;
        int n = A[0].length;

        if (dp[row][col] != Integer.MAX_VALUE) return dp[row][col];

        if (row == m - 1)
            return dp[row][col] = A[row][col];

        int left = Integer.MAX_VALUE, right = Integer.MAX_VALUE;

        if (col > 0)
            left = minFallingPathSum(A, row + 1, col - 1, dp);

        int straight = minFallingPathSum(A, row + 1, col, dp);

        if (col < n - 1)
            right = minFallingPathSum(A, row + 1, col + 1, dp);

        dp[row][col] = Math.min(left, Math.min(straight, right)) + A[row][col];

        return dp[row][col];
    }

    public int minFallingPathSumDP(int[][] matrix) {
        double min = 1e8 ;
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix[0].length ; i++){
           double val = Recursion(matrix , matrix.length-1 , i , matrix.length , matrix[0].length , dp);
            min = Math.min(val , min);
        }
        return (int)min ;
    }
    public static int Recursion(int[][] matrix , int i , int j , int n , int m , int[][] dp ){
        if(j < 0 || j >= m){
            return (int)1e8 ;
        }
        if(i == 0){
            return matrix[0][j];
        }
        if(dp[i][j] != 0){
            return dp[i][j];
        }
        int up = matrix[i][j] + Recursion(matrix, i-1, j, n, m , dp);
        int diagonalLeft = matrix[i][j] + Recursion(matrix, i-1, j-1, n, m , dp);
        int diagonalRight = matrix[i][j] + Recursion(matrix, i-1, j+1, n, m , dp);

        return dp[i][j] = Math.min(up , Math.min(diagonalLeft , diagonalRight));
    }

    public static int Tabulation(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        for(int i = 0 ; i < matrix[0].length ; i++){
            dp[0][i] = matrix[0][i];
        }
        int dgLeft = (int)1e8 ;
        int dgRight = (int)1e8 ;
        for(int i = 1 ; i < matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                int up = matrix[i][j] + dp[i-1][j];
                if(j-1 >= 0) dgLeft = matrix[i][j] + dp[i-1][j-1];
                else{
                    dgLeft = (int)1e8 ;
                }
                if(j+1 <= matrix[0].length) dgRight = matrix[i][j] + dp[i-1][j+1];
                else{
                    dgRight = (int)1e8 ;
                }
                dp[i][j] = Math.max(up , Math.max(dgLeft , dgRight));
            }
        }
        int min = (int)1e8 ;
        for(int i = 0 ; i < matrix[0].length ; i++){
            min = Math.min(min , dp[matrix.length-1][i]);
        }
        return min ;
    }
}
