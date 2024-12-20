package DpOnDigits;

import java.util.Arrays;

public class COunt0s {
    class Solution {
    int[][][] dp ;
    public int countDigitOne(int n) {
        String s = String.valueOf(n);
        dp = new int[s.length()+1][2][s.length()+1];
        for(int[][] matrix : dp){
            for(int[] row : matrix) Arrays.fill(row , -1);
        }
        return Solve(s , 0 , true , 0);
    }
    public int Solve(String s , int idx , boolean flag , int cnt){
        if(idx == s.length()) return cnt ; 

        int flagIndex = flag ? 1 : 0 ; 
        if(dp[idx][flagIndex][cnt] != -1) return dp[idx][flagIndex][cnt];

        int limit = flag ? s.charAt(idx) - '0' : 9 ;
        int ans = 0 ; 
        for(int i = 0 ; i <= limit ; i++){
            int newCnt = cnt + (i == 1 ? 1 : 0);
            ans += Solve(s , idx+1 , flag && s.charAt(idx) - '0' == i, newCnt);
        }
        return dp[idx][flagIndex][cnt] = ans ;
    }
}
}
