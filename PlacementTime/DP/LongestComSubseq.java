package PlacementTime.DP;
import java.util.* ; 

class Solution {
    int[][] memo ; 
    public int longestCommonSubsequence(String s, String t) {
        // return tabulation(s , t);
        int n = s.length();
        int m = t.length();
        memo = new int[n][m];
        for(int[] row : memo) Arrays.fill(row ,-1); 
        return solve(s , t , n-1 , m-1 );
    }
    public int solve(String s, String t , int i , int j){
        if(i < 0 || j < 0){
            return 0 ; 
        }
        //one is that 
        //is the char matches , then 
        if(memo[i][j] != -1) return memo[i][j];
        int result = 0 ;
        if(s.charAt(i) == t.charAt(j)){
            // matched  
            result = 1 + solve(s , t , i-1 , j-1) ;
        }else{
            // notMatched 
            result =  Math.max(solve(s , t , i-1 , j ) , solve(s , t , i , j-1));
        }
        return memo[i][j] =  result;
    }
    public int tabulation(String s, String t){
        int n = s.length();
        int m = t.length();
        int[][] dp = new int[n+1][m+1];

        //     [0] [a] [b] [c] [d] [e]
        // [0] [0] [0] [0] [0] [0] [0]
        // [a] [0] [1] [1] [1] [1] [1]
        // [c] [0] [1] [1] [2] [2] [2]
        // [e] [0] [1] [1] [1] [1] [3] 3 is the length of common string
        // e -- c -- a == > a -- c -- e
        
        //base case will be that if 
        //the length of one of the string is zeero this wil eventually give
        //us the common sring between as zero 
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(s.charAt(i-1) == t.charAt(j-1)){
                    //this the diagonal case 
                    dp[i][j] = dp[i-1][j-1] + 1 ;
                }else{
                    dp[i][j] = Math.max(dp[i-1][j] , dp[i][j-1]);
                }
            }
        }
        return dp[n][m];
    }
}