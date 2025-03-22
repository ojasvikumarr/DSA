package PlacementTime.DP;

public class LongestComSubseq {
    class Solution {
        public int longestCommonSubsequence(String text1, String text2) {
            return tabulation(text1 , text2);
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
}
