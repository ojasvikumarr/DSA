package PlacementTime.DP;

import java.util.Arrays;

public class RightDOwnWithObstacle {
    class Solution {
    int[][] memo ; 
    public int uniquePathsWithObstacles(int[][] grid) {
        //so we can go right and down 
        //ther are obstacles in the grid given repreented by 1 
        //ill go by top down approach 
        //that is reaching the starting position from the destinatio itself 
        int n = grid.length ; 
        int m = grid[0].length ;
        memo = new int[n][m];
        for(int[] row : memo){
            Arrays.fill(row , -1);
        }
        return solve(grid , n , m , n-1 , m-1);
    }
    public int solve(int[][] grid , int n , int m , int i , int j){
        //we can move right and down if we were at origin 
        //but here we are the destination first 
        //thus we move up and left 
        //what will we be the bae case 
        if(i < 0 || j < 0){
            return 0 ; 
        }else if(grid[i][j] == 1){
            return 0 ; 
        }else if(i == 0 && j == 0){
            return 1 ; 
        }
        if(memo[i][j] != -1) return memo[i][j];
        int up = solve(grid , n , m , i-1 , j) ;
        int down = solve(grid , n , m , i , j-1);
        return memo[i][j] = up + down ; 
    }
    public int tabulation(int[][] grid){
        int n = grid.length ; 
        int m = grid[0].length ; 
        // int[][] tab = new int[n+1][m+1];
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        //base case to destination 
        //what will be the base case ?
        // [][][][][][]
        // [][1][1][1][1][1]
        // [][1][2][X][1][2]
        // [][1][3][3][4][6]

        curr[1] = 1 ; 
        for(int i = 1 ; i <= n ; i++){
            for(int j = 1 ; j <= m ; j++){
                if(i == 1 && j == 1) continue ;
                if(grid[i][j] == 1) continue ; //tab[i][j] remains 0
                curr[j] = prev[j] + curr[j-1]; 
            }
            prev = Arrays.copyOf(curr, n+11);
        }

        return prev[m];
    }
}
}
