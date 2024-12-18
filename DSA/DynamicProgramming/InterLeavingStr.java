package DynamicProgramming;

import java.util.Arrays;

public class InterLeavingStr {
    class Solution {
    public boolean isInterleaveII(String s1, String s2, String s3) {
        int i = 0 ; 
        int j = 0 ; 
        int k = 0 ; 
        while(k < s3.length()){
            if(i < s1.length() && s1.charAt(i) == s3.charAt(k)){
                i++ ; 
                k++ ;
            }else if(j < s2.length() && s2.charAt(j) == s3.charAt(k)){
                j++ ; 
                k++ ;
            }else{
                return false ;
            }
        }
        if(i == s1.length()-1 && j == s2.length()-1 && k == s3.length()-1){
            return true ;
        }
        return false ;
    }

    public boolean isInterleave(String s1, String s2, String s3) {
        if(s1.length() + s2.length() != s3.length()) return false ;
        int[][][] dp = new int[s1.length()+1][s2.length()+1][s3.length()+1];
        for(int[][] matrix : dp){
            for(int[] row : matrix) Arrays.fill(row , -1);
        }
        return helper(s1 , s2 , s3 , 0 , 0 , 0 , dp);
    }
    public boolean helper(String s1 , String s2 , String s3 , int i , int j , int k , int[][][] dp){
        if(i == s1.length() && j == s2.length() && k == s3.length()){
            return true ;
        }

        if(dp[i][j][k] != -1) return dp[i][j][k] == 1 ? true : false;

        boolean pickS1 = false ;
        if(i < s1.length() && s1.charAt(i) == s3.charAt(k)) 
            pickS1 = helper(s1 , s2 , s3 , i+1 , j , k+1 , dp);
        boolean pickS2 = false ;
        if(j < s2.length() && s2.charAt(j) == s3.charAt(k)) 
            pickS2 = helper(s1 , s2 , s3 , i , j+1 , k+1 , dp);
        dp[i][j][k] = pickS1 || pickS2 ? 1 : 0 ;
        return dp[i][j][k] == 1 ? true : false;
    }
}
}
