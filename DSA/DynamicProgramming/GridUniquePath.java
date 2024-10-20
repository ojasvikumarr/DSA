package DynamicProgramming;

public class GridUniquePath {
    public static int UniquePaths(int i , int j ){
        if(i < 0 || j < 0 ){
            return 0 ;
        }
        if(i == 0 && j == 0){
            return 1 ;
        }

        int up = UniquePaths(i-1, j);
        int left = UniquePaths(i, j-1);

        return up + left ;
    }
    public static int UniquePathsDp(int i , int j , int[][] dp){ // TLE DEDEGA
        if(i < 0 || j < 0 ){
            return 0 ;
        }
        if(i == 0 && j == 0){
            return 1 ;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }

        int up = UniquePathsDp(i-1, j, dp);
        int left = UniquePathsDp(i, j-1, dp);

        return dp[i][j] = up + left ;
    }
    public static int UniquePathsTab(int[][] matrix){
        int[][] dp = new int[matrix.length][matrix[0].length];
        dp[0][0] = 1 ;
        int down = 0 ;
        int right = 0 ; 
        for(int i = 0 ; i< matrix.length ; i++){
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(i > 0){
                    down = dp[i-1][j] ;
                }
                if(j > 0){
                    right = dp[i][j-1];
                }
                dp[i][j] = down + right ;
            }
        }
        return dp[matrix.length-1][matrix[0].length-1];
    }
    public static int UniquePathsTabOpt(int[][] matrix){
        int[] dp = new int[matrix.length];
        for(int i = 0 ; i < matrix.length ; i++){
            dp[i] = 0 ;
        }
        int down = 0 ;
        int right = 0 ; 
        for(int i = 0 ; i< matrix.length ; i++){
            int[] temp = new int[matrix.length];
            for(int j = 0 ; j < matrix[0].length ; j++){
                if(i > 0){
                    down = dp[j] ;
                }
                if(j > 0){
                    right = temp[i-1];
                }
                temp[j] = down + right ;
            }
            dp = temp ;
        }
        return dp[matrix.length-1];
    }

    public static int UniquePathDeadCells(int n , int m , int[][] arr){
        if(arr[n][m] == -1){
            return 0 ;
        }
        if(n < 0 || m < 0){
            return 0 ;
        }
        if(n == 0 && m == 0){
            return 1 ;
        }
        int up = UniquePathDeadCells(n-1, m, arr);
        int left = UniquePathDeadCells(n, m-1, arr);

        return up + left ;
    }
}
 