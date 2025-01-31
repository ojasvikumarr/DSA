package DynamicProgramming;

public class pickCherries {
    class Solution {
        Integer[][][][] dp ; 
        public int cherryPickup(int[][] grid) {
            //Two times DFS 
            // int n = grid.length ;
            // boolean[][] visited = new boolean[n][n];
            // int result = grid[0][0] + solve(grid , 0 , 0 , visited);
            // //If Didnt reach the n-1 n-1 block therefore no path available 
            // if(!visited[n-1][n-1]) return 0 ; 
            // for(int[] row : grid) {
            //     for(int i = 0 ; i < n ; i++){
            //         System.out.print(row[i]);
            //     }
            //     System.out.println();
            // }
            // result += solve(grid , 0 , 0 , new boolean[n][n]);
            // return result == Integer.MIN_VALUE ? 0 : result;
            int N = grid.length ; 
            dp = new Integer[N][N][N][N];
            return Math.max( 0 , solve(grid , grid.length , 0 , 0 ,0 , 0)) ;
        }
        @SuppressWarnings("removal")
        public int solve(int[][] grid , int n ,int r1 , int c1 , int r2 , int c2 ){
            if(r1 >= n || c1 >= n || r2 >= n || c2 >= n || grid[r1][c1] == -1 || grid[r2][c2] == -1){
                return Integer.MIN_VALUE ;
            }
            if(dp[r1][c1][r2][c2] != null){
                return dp[r1][c1][r2][c2] ;
            }
            if(r1 == n-1 && c1 == n-1){
                return grid[r1][c1];
            }
    
            if(r2 == n-1 && c2 == n-1){
                return grid[r2][c2];
            }
    
            int cherries = 0 ; 
            if(r1 == r2 && c1 == c2){
                cherries = grid[r1][c2];
            }
            else{
                cherries = grid[r1][c1] + grid[r2][c2];
            }
    
            cherries += Math.max(
                Math.max(solve(grid , n , r1 + 1 , c1 , r2 + 1 , c2 ) , solve(grid , n , r1 + 1 , c1 , r2 , c2 + 1)) , 
                Math.max(solve(grid , n , r1 , c1 +1 , r2 + 1 , c2 ) , solve(grid , n , r1 , c1 + 1 , r2 , c2 + 1))) ;
            dp[r1][c1][r2][c2] = new Integer(cherries);
            return dp[r1][c1][r2][c2] ; 
        }
    
    
    
        public int solveIIII(int[][] grid , int i , int j , boolean[][] visited ){
            int n = grid.length ; 
            visited[i][j] = true ; 
            if(i == n-1 && j == n-1){
                int result = grid[i][j] ;
                grid[i][j] = 0 ;
                return result ; 
            } 
            int right = Integer.MIN_VALUE ; 
            int result = grid[i][j] ;
            grid[i][j] = 0 ; 
            if(j+1 < n && grid[i][j+1] != -1){
                right = result + solveIIII(grid , i , j+1 , visited);
            }
            int down = Integer.MIN_VALUE ; 
            if( i + 1 < n && grid[i+1][j] != -1){
                down = result + solveIIII(grid , i+1 , j , visited);
            }
            
            return Math.max(right , down); 
        }
    
    
    
    
    
    
        public int solveIII(int[][] grid , int i , int j , boolean[][] visited ){
            int n = grid.length ; 
            visited[i][j] = true ; 
            if(i == n-1 && j == n-1){
                return 0 ; 
            } 
            int right = Integer.MIN_VALUE ; 
            if(j+1 < n && grid[i][j+1] != -1){
                int result = grid[i][j+1] ;
                grid[i][j+1] = 0 ; 
                right = result + solveIII(grid , i , j+1 , visited);
            }
            int down = Integer.MIN_VALUE ; 
            if( i + 1 < n && grid[i+1][j] != -1){
                int result = grid[i+1][j] ;
                grid[i+1][j] = 0 ;
                down = result + solveIII(grid , i+1 , j , visited);
            }
            
            return Math.max(right , down); 
        }
    
    
    
    
    
    
    
        int[][] directions = {{0 , 1} , {1 , 0}};
    
        public int solveII(int[][] grid , int i , int j , boolean[][] visited ){
            int n = grid.length ; 
            if(i == n-1 && j == n-1){
                return 0 ; 
            }
    
            int ans = 0 ; 
            for(int dir = 0 ; dir < 2 ;dir++){
                int row = i + directions[dir][0];
                int col = j + directions[dir][1];
                if(row >= 0 && col >= 0 && row < n && col < n && visited[row][col] == false && grid[row][col] != -1){
                    visited[row][col] = true ; 
                    ans = Math.max(ans , grid[row][col] + solveII(grid , row , col , visited));
                    grid[row][col] = 0 ; 
                }
            }
            return ans; 
        }
        
    }
}
