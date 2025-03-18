package PlacementTime.DP;

import java.util.Arrays;

public class RightDown {
    class Solution {
    int[][] memo ; 
    public int uniquePaths(int m, int n) {
    // so there will be so many paths from 0, to n-1 m-1 
    //therefore we need to return all possible paths in the grid 
    //for that we can take help of recursion to explore all the paths 
    //ill be using top down approach to build recursion from the destination towards the origin 
    //O(2^(m*n)) exponential time complexity thus 
    memo = new int[m][n];
    for(int[] row : memo) Arrays.fill(row , -1);
    // return solve(m , n , m-1 , n-1);
    return tabulation(m , n);
    }
    public int solve(int m , int n , int i , int j){
        //as we are going from n-1, m-1 cell to 0 , 0 thus our 
        //movement changed to up and left 
        // that is i-1 or j-1
        if(i < 0 || j < 0){
            return 0 ; 
        }else if(i == 0 && j == 0){
            return 1 ; 
        }
        if(memo[i][j] != -1) return memo[i][j];
        int up = solve(m , n , i-1 , j);
        int left = solve(m , n , i , j-1);
        //we are asked to return all possible ways 
        return memo[i][j] = up + left ; 
    }
    public int tabulation(int m , int n ){
        // int[][] tab = new int[m+1][n+1];
        int[] prev = new int[n+1];
        int[] curr = new int[n+1];
        //(0 , 0) --> (m-1 , n-1)
        // [][][][][]
        // [][1][1][1]
        // [][1][2][3]
        // [][1][3][6]

        // tab[1][1] = 1 ; 
        curr[1] = 1 ;
        for(int i = 1 ; i <= m ; i++){
            for(int j = 1 ; j <= n ; j++){
                if(i == 1 && j == 1) continue ; 
                curr[j] = prev[j] + curr[j-1];
            }
            prev = Arrays.copyOf(curr , n+1);
        }
        return prev[n];
    }
}
}
