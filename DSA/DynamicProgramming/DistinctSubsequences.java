package DynamicProgramming;

public class DistinctSubsequences {
    public int recurr(int i , int j , char[] s , char[] t){
        if(i < 0){
            return 0 ;
        }
        if(j < 0){
            return 1 ;
        }
        if(s[i] == t[j]){
            return (recurr(i-1, j-1, s, t) + recurr(i-1, j, s, t));
        }else{
            return recurr(i-1 , j , s , t);
        }
    }
    public int DP(int i , int j , char[] s , char[] t , int[][] dp){
        if(i < 0){
            return 0 ;
        }
        if(j < 0){
            return 1 ;
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s[i] == t[j]){
            return dp[i][j] = (recurr(i-1, j-1, s, t) + recurr(i-1, j, s, t));
        }else{
            return dp[i][j] = recurr(i-1 , j , s , t);
        }
    }
    public int Tab(char[] s, char[] t){
        int[][] dp = new int[s.length + 1][t.length+1];
        for(int i = 0 ; i <= s.length ; i++){
            dp[i][0] = 0 ;
        }
        for(int i = 0 ; i <= t.length ; i++){
            dp[0][i] = 0 ;
        }
        
        for(int i = 1 ; i <= s.length ; i++){
            for(int j = 1 ; j <= t.length ; j++){
                if(s[i-1] == t[j-1]){
                    dp[i][j] = dp[i-1][j-1] + dp[i-1][j];
                }else{
                    dp[i][j] = dp[i-1][j];
                }
            }
        }
        return dp[s.length][t.length];
    }
    public int OptTab(String st,String str){
        char[] s = st.toCharArray();
        char[] t = str.toCharArray();
        // int[][] dp = new int[s.length + 1][t.length+1];
        int[] prev = new int[s.length+1];
        
        // for(int i = 0 ; i <= s.length ; i++){
        //     dp[i][0] = 1 ;
        // }
        // for(int i = 0 ; i <= t.length ; i++){
        //     dp[0][i] = 0 ;
        // }
        prev[0]=1 ;
        for(int i = 1 ; i <= s.length ; i++){
            for(int j =  t.length ; j >= 1 ; j--){
                if(s[i-1] == t[j-1]){
                    prev[j] = prev[j-1] + prev[j];
                }
            }
        }
        return prev[t.length];
    }
}



class Solution {
    public int numDistinct(String s, String t) {
        char[] str = s.toCharArray();
        char[] strr = t.toCharArray();
        int[][] dp = new int[str.length][strr.length];
        for(int i = 0 ; i < str.length ; i++){
            for(int j = 0 ; j < strr.length ; j++){
                dp[i][j] = -1 ;
            }
        }
        return recurr(str.length-1 , strr.length-1 , str , strr , dp);
    }
    public int recurr(int i , int j , char[] s , char[] t , int[][] dp){
        if(i < 0 && j > -1){
            return 0 ;
        }
        if(j < 0 && i > -1){
            return 1 ;
        }
        if(i == -1 && j == -1){
            return 1 ; 
        }
        if(dp[i][j] != -1){
            return dp[i][j];
        }
        if(s[i] == t[j]){
            return dp[i][j] = (recurr(i-1, j-1, s, t , dp) + recurr(i-1, j, s, t, dp));
        }else{
            return dp[i][j] = recurr(i-1 , j , s , t, dp);
        }
    }
}