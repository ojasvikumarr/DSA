package PlacementTime.DP;

import java.util.ArrayList;
import java.util.List;

public class printALLSubs {
    class Main {
    List<String> res ; 
    public List<String> all_longest_common_subsequences(String s, String t) {
        // Code here
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
        //now we have created the tab table 
        //we will backtrack it 
        res = new ArrayList<>();
        dfs(dp , s , t , n , m , new StringBuilder());
        return res ; 
    }
    public void dfs(int[][] dp , String s , String t , int i , int j , StringBuilder sb){
        if(i == 0 && j == 0){
            res.add(sb.reverse().toString());
            return ; 
        }
        if(s.charAt(i-1) == s.charAt(j-1)){
            sb.append(s.charAt(i));
            dfs(dp , s, t , i-1 , j-1 , sb);
        }else{
            if(dp[i][j] == dp[i-1][j] && dp[i][j] == dp[i][j-1]){
                dfs(dp , s , t , i-1 , j , sb);
                dfs(dp , s , t , i , j-1 , sb);
            }else if(dp[i][j] == dp[i][j-1]){
                dfs(dp , s , t , i , j-1 , sb);
            }else{
                dfs(dp , s , t , i-1 , j , sb);
            }
        }
    }
}
}
