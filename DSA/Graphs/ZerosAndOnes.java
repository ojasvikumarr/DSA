package Graphs;

import java.util.Arrays;

public class ZerosAndOnes {
    class Solution {
    int[][][] memo ;
    public int findMaxForm(String[] strs, int m, int n) {
        memo = new int[m+1][n+1][strs.length+1];
        for(int[][] matrix : memo)
            for(int[] row : matrix) 
                Arrays.fill(row , -1);
        return solve(strs , m , n , 0);
    }

    public int solve(String[] strs , int m , int n , int idx ){
        if(idx == strs.length || m < 0 || n < 0){
            return 0 ; 
        }
        if(memo[m][n][idx] != -1) return memo[m][n][idx];
        int i = m ; 
        int j = n ; 
        for(int k = 0 ; k < strs[idx].length() ; k++){
            if(strs[idx].charAt(k) == '0') i-- ;
            else j-- ;
        }
        int pick = 0 ; 
        if(i >= 0 && j >= 0)
            pick = 1 + solve(strs , i , j , idx+1);
        int notpick = solve(strs , m , n ,idx+1);
        return memo[m][n][idx] = Math.max(pick , notpick);
    }
    public int findMaxFormII(String[] strs, int m, int n) {
        int maxi = 0 ; 
        int zeros = 0 ; 
        int ones = 0 ; 
        int l = 0 ; 
        for(int r = 0 ; r < strs.length ; r++){
            
            for(int j = 0 ; j < strs[r].length() ; j++){
                if(strs[r].charAt(j) == '0') zeros++ ;
                else ones++ ;
            }
            while(zeros > m || ones > n){
                for(int j = 0 ; j < strs[l].length() ; j++){
                    if(strs[l].charAt(j) == '0') zeros-- ;
                    else ones-- ;
                }
                l++ ;
            }
            maxi = Math.max(maxi , r-l+1);
        }
        return maxi ;
    }
}
}
