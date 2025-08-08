class Solution {
    public double soupServings(int n) {
        int m = (int)Math.ceil(n/25.0) ;
        if(m > 250) return 1.0 ;
        double[][] dp = new double[m+1][m+1];
        for(int i = 1 ; i <= m ; i++){
            dp[0][i] = 1.0; 
            dp[i][0] = 0.0; 
        }
        dp[0][0] = 0.5 ; 
        for(int i = 1 ; i <= m; i++){
            for(int j = 1 ; j <= m ; j++){
                dp[i][j] = 0.25*(
                    dp[Math.max(0 , i-4)][j]+
                    dp[Math.max(0 , i-3)][Math.max(0 , j-1)]+
                    dp[Math.max(0 , i-2)][Math.max(0 , j-2)]+
                    dp[Math.max(0 , i-1)][Math.max(0 , j-3)]
                ) ;
            }
        }
        // /heelo
        return dp[m][m];
    }
}