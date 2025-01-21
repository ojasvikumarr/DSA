public class Day107 {
    class Solution {
        public long gridGame(int[][] grid) {
            int m = grid[0].length ;
            long totalSum = 0 ; 
            for(Integer it : grid[0]) totalSum += it ;
    
            long maxi = Long.MAX_VALUE ; 
            long secondSum = 0 ; 
            for(int i = 0 ;i < m ;i++){
                totalSum -= grid[0][i];
                maxi = Math.min(maxi , Math.max(totalSum , secondSum));
                secondSum += grid[1][i];
            }
            return maxi ;
        }
    
        public long gridGameIII(int[][] grid) {
            int n = 2 ; 
            int m = grid[0].length ; 
            maxSum(grid);
            return maxSum(grid);
        }
    
        public long maxSum(int[][] grid){
            int m = grid[0].length ; 
            int[] preSum = new int[m];
            preSum[0] = grid[0][0];
            int[] sufSum = new int[m];
            sufSum[m-1] = grid[1][m-1];
    
            for(int i = 1 ; i < m ; i++){
                preSum[i] = (preSum[i-1]+grid[0][i]);
                sufSum[m-i-1] = (sufSum[m-i-1+1] + grid[1][m-i-1]);
            }
    
            int maxIdx = 0 ; 
            int maxi = -1 ;  
            for(int i = 0 ; i < m ; i++){
                if( maxi < preSum[i] + sufSum[i]){
                    maxi = preSum[i] + sufSum[i];
                    maxIdx = i ; 
                }
            }
    
            //Now we'll be making the path 0 in the grid
            for(int i = 0 ; i < m ; i++ ){
                if( i < maxIdx ){
                    grid[0][i] = 0 ; 
                }else if(i == maxIdx){
                    grid[0][i] = 0 ; 
                    grid[1][i] = 0 ; 
                }else if(i > maxIdx){
                    grid[1][i] = 0 ; 
                }
            }
            return maxi ; 
        }
    
        public long gridGameII(int[][] grid) {
            int n = grid.length;
            int m = grid[0].length;
            
            // First Player's Turn
            long[][] memo1 = new long[n][m];
            for (long[] row : memo1) Arrays.fill(row, -1);
            long firstPlayerScore = solve(grid, 0, 0, memo1);
            
            // Track the path
            List<int[]> path = new ArrayList<>();
            int row = 0, col = 0;
            while (row < n - 1 || col < m - 1) {
                path.add(new int[]{row, col});
                if (row < n - 1 && memo1[row][col] == grid[row][col] + memo1[row + 1][col]) {
                    row++;
                } else if (col < m - 1 && memo1[row][col] == grid[row][col] + memo1[row][col + 1]) {
                    col++;
                }
            }
            path.add(new int[]{n - 1, m - 1});
            
            // Set the cells of the first player's path to 0
            for (int[] cell : path) {
                grid[cell[0]][cell[1]] = 0;
            }
            
            // Second Player's Turn
            long[][] memo2 = new long[n][m];
            for (long[] row2 : memo2) Arrays.fill(row2, -1);
            return solve(grid, 0, 0, memo2);
        }
    
        public long solve(int[][] grid, int i, int j, long[][] memo) {
            int n = grid.length;
            int m = grid[0].length;
            if (i == n - 1 && j == m - 1) {
                return grid[i][j];
            }
            if (i >= n || j >= m) {
                return Long.MIN_VALUE;
            }
            if (memo[i][j] != -1) {
                return memo[i][j];
            }
            long right = solve(grid, i, j + 1, memo);
            long down = solve(grid, i + 1 , j, memo);
            return memo[i][j] = grid[i][j] + Math.max(right, down);
        }
    }
}
