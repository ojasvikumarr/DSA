package DynamicProgramming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class PartitionSubstring {
    class Solution {
    public int solve(String s) {
        int n = s.length();
        int[] t = new int[n];
        boolean[][] P = new boolean[n][n];

        // Length = 1 substrings are always palindromes
        for (int i = 0; i < n; i++) {
            P[i][i] = true;
        }

        // Length = 2+ substrings
        for (int L = 2; L <= n; L++) {
            for (int i = 0; i < n - L + 1; i++) {
                int j = i + L - 1;

                if (L == 2) {
                    P[i][j] = (s.charAt(i) == s.charAt(j));
                } else {
                    P[i][j] = (s.charAt(i) == s.charAt(j)) && P[i + 1][j - 1];
                }
            }
        }

        // Compute minimum cuts using dynamic programming
        for (int i = 0; i < n; i++) {
            if (P[0][i]) {
                t[i] = 0;
            } else {
                t[i] = Integer.MAX_VALUE;
                for (int k = 0; k < i; k++) {
                    if (P[k + 1][i] && 1 + t[k] < t[i]) {
                        t[i] = 1 + t[k];
                    }
                }
            }
        }

        return t[n - 1];
    }

    public int minCut(String s) {
        int n = s.length();
        if (n == 0 || n == 1) {
            return 0;
        }

        return solve(s);
    }

    public int minCutIII(String s) {
        int[][] dp = new int[s.length()+1][s.length()+1];
        for(int[] row : dp )
            Arrays.fill(row , -1);
        return recur(s, 0 , s.length()-1 , dp);
    }

    public int recur(String s , int i , int j , int[][] dp){
        if( i >= j ) return 0 ;
        if(isPalindrome(s.substring(i , j+1))) return 0 ; 

        if(dp[i][j] != -1) return dp[i][j];
        int min = Integer.MAX_VALUE ;
        for(int k = i ; k < j ; k++){
            int result = 1 + recur(s , i , k , dp) + recur(s , k+1 , j , dp);
            min = Math.min(min , result);
        }
        return dp[i][j] = min ;
    }
    public boolean isPalindrome(String str){
        int i = 0 ; 
        while( i < str.length()/2){
            if(str.charAt(i) != str.charAt(str.length()-i-1)) return false ; 
            i++ ;
        }
        return true ;
    }
    int mini ; 
    public int minCutII(String s) {
        mini = Integer.MAX_VALUE ;
        int[] dp = new int[s.length()+11];
        Arrays.fill(dp , -1);
        return backTrack(s , 0 , new ArrayList<>() , dp) - 1;
    }
    public int backTrack(String s , int idx , List<String> ls , int[] dp){
        if(idx == s.length()){
            return 0;
        }
        if(dp[idx] != -1) return dp[idx];

        for(int i = idx ; i < s.length() ; i++){
            if(isPalindrome(s.substring(idx , i+1))){
                mini = Math.min(mini ,1 + backTrack(s , i+1 , ls , dp));
            }
        }
        return dp[idx] = mini; 
    }
    
}
}
