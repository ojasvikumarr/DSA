package DynamicProgramming;

public class KnightProb {
    class Solution {
        double[][][] dp ; 
        public double knightProbability(int n, int kk, int row, int column) {
            dp = new double[kk+1][n][n];
            // for(double[][] mat : dp){
            //     for(double[] rooow : mat) Arrays.fill(rooow , -1);
            // }
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    dp[0][i][j] = 1 ;
                }
            }
    
            int[][] directions = {{1 , 2} , {1 , -2} , {-1 , 2} , {-1 , -2} , {2 , 1} , {2 , -1} , {-2 , 1} , {-2  , -1}};
            for(int k = 1 ; k <= kk ; k++){
                for(int i = 0 ; i < n ; i++){
                    for(int j = 0 ; j < n ; j++){
                        for(int[] direc : directions){
                            int prevI = i - direc[0];
                            int prevJ = j - direc[1];
                            if(prevI >= 0 && prevI < n && prevJ >= 0 && prevJ < n){
                                dp[k][i][j] += (dp[k-1][prevI][prevJ] / 8.0) ;
                            }
                        }
                    }
                }
            }
            return dp[kk][row][column] ;
        }
        public double solve(int n , int k , int i , int j){
            if(i >= n || j >= n || i < 0 || j < 0){
                return 0 ; 
            }
            if( k == 0 ){
                return 1 ;
            }
            if(dp[k][i][j] != -1) return dp[k][i][j] ;
            double result = (solve(n , k-1 , i-2 , j+1) + 
                         solve(n , k-1 , i-2 , j-1) +
                         solve(n , k-1 , i+2 , j-1) +
                         solve(n , k-1 , i+2 , j+1) +
                         solve(n , k-1 , i+1 , j-2) +
                         solve(n , k-1 , i-1 , j-2) +
                         solve(n , k-1 , i-1 , j+2) +
                         solve(n , k-1 , i+1 , j+2) );
            return dp[k][i][j] =(result/8) ;
                         
        }
    }
}
