package PlacementTime.DP;

import java.util.Arrays;

public class CherryPick {
    class Solution {
    int[][][] memo ; 
    public int solve(int n, int m, int grid[][]) {
        // Code here
        //top down approach 
        //from the orign to the destination i am going
        memo = new int[n][m][m] ;
        for(int[][] mat : memo){
            for(int[] row : mat) Arrays.fill(row , -1);
        }
        // return DP(grid , 0 , 0 , m-1);
        return tabulation(grid , n , m);
    }
    int[] dir = {-1 , 0 , 1} ; 
    public int tabulation(int[][] grid , int n , int m ){
        int[][][] tab = new int[n][m][m];
        //base case 
        //to fill the last ro wwith all possible outcomes 
        for(int dj1 = 0 ; dj1 < m ; dj1++){
            for(int dj2 = 0 ; dj2 < m ; dj2++){
                if(dj1 == dj2){
                    tab[n-1][dj1][dj2] = grid[n-1][dj1];
                }else{
                    tab[n-1][dj1][dj2] = grid[n-1][dj1] + grid[n-1][dj2];
                }
            }
        }
        //now we traverse the tabulation upwards 
        for(int i = n-2 ; i >= 0 ; i--){
            for(int j1 = 0 ; j1 < m ; j1++){
                for(int j2 = 0 ; j2 < m ; j2++){
                    int maxi = Integer.MIN_VALUE ;
                    for(int dj1 = -1 ; dj1 <= 1 ; dj1++){
                        for(int dj2 = -1 ; dj2 <= 1 ; dj2++){
                            int value = 0; 
                            if(j1 == j2) value += grid[i][j1] ; 
                            else value += grid[i][j1] + grid[i][j2];
                            if(j1+dj1 >= 0 && j1+dj1 < m && j2+dj2 >= 0 && j2+dj2 < m)
                            maxi = Math.max(maxi , tab[i+1][j1+dj1][j2+dj2] + value);
                             
                        }
                    }
                    tab[i][j1][j2] = maxi ; 
                }
            }
        }
        return tab[0][0][m-1];
    }
    public int DP(int[][] grid , int i , int j1 , int j2 ){
        // i can go down in three directions 
        // for every movement of a we have three movements of B
        int n = grid.length ; 
        int m = grid[0].length ; 
        if(j1 < 0 || j1 >= m || j2 < 0 || j2 >= m){
            return -(int)1e8 ;
        }
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1];
            }else{
                return grid[i][j1] + grid[i][j2];
            }
        }
       
       if(memo[i][j1][j2] != -1) return memo[i][j1][j2];
        int maxi = Integer.MIN_VALUE ;
        for(int p = 0 ; p < 3 ; p++){
            int inter = Integer.MIN_VALUE ;
            for(int q = 0 ; q < 3 ; q++){
                if(j1 == j2){
                    inter = Math.max(inter , DP(grid, i+1 , j1+dir[p] , j2+ dir[q]) + grid[i][j1]);
                }else{
                    inter = Math.max(inter , DP(grid, i+1 , j1+dir[p] , j2+ dir[q]) + grid[i][j1] + grid[i][j2]);
                }
            }
            maxi = Math.max(maxi , inter);
        }
        return memo[i][j1][j2] = maxi ; 
    }
}
}
