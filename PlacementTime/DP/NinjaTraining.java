package PlacementTime.DP;

import java.util.Arrays;

public class NinjaTraining {
    class Solution {
    int[][] dp ; 
    public int maximumPoints(int arr[][]) {
        // code here
        int n = arr.length ;
        dp = new int[n][4];
        for(int[] row : dp) Arrays.fill(row , -1);
        // return solve(arr , arr.length-1 , 3);
        return tabulation(arr);
    }
    public int spaceOptimized(int[][] arr){
        int[] prev = new int[3];
        int[] curr = new int[3];
        int n = arr.length;
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < 3 ; j++){
                int maxi = Integer.MIN_VALUE ; 
                for(int k = 0 ; k < 3 ; k++){
                    if(j == k) continue ;
                    maxi = Math.max(maxi , prev[k] + arr[i-1][k]);
                }
                curr[j] = maxi ;
            }
            prev = Arrays.copyOf(curr , 3);
        } 
        return Math.max(prev[0] , Math.max(prev[1] , prev[2]));
    }
    public int tabulation(int[][] arr){
        int n = arr.length ; 
        int[][] tab = new int[n+1][3];
        //bottom up 
        //going from the base case to the required case 
        //what will be the base case in this 
        // /at idx 0 i cant know whic path i would hae take already 
        // [.][][]
        // [][][.]
        //intially my tabulation table is zero 
        for(int i = 1 ; i <= n ; i++){
            for(int j = 0 ; j < 3 ; j++){
                int maxi = Integer.MIN_VALUE ; 
                for(int k = 0 ; k < 3 ; k++){
                    if(j == k) continue ; 
                    maxi = Math.max(maxi ,tab[i-1][k] + arr[i-1][k]);
                }
                tab[i][j] = maxi ; 
            }
        }
        return Math.max(tab[n][0] , Math.max(tab[n][1] , tab[n][2]));
    }
    public int solve(int[][] arr , int idx , int prev){
        if(idx == 0){
            int interRes = 0 ; 
            for(int i = 0 ; i < 3 ; i++){
                if(i == prev) continue ; 
                interRes = Math.max(arr[0][i] , interRes);
            }
            return interRes ; 
        }
        if(dp[idx][prev] != -1) return dp[idx][prev];
        int maxi = Integer.MIN_VALUE ; 
        for(int i = 0 ; i < 3 ; i++){
            if(i == prev) continue ; //skip this one 
            maxi = Math.max(maxi , solve(arr , idx-1 , i) + arr[idx][i]);
        }
        return dp[idx][prev] = maxi ; 
    }
}
}
