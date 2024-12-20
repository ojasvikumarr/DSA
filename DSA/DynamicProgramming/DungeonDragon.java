package DynamicProgramming;

public class DungeonDragon {
    class Solution {
        public int calculateMinimumHP(int[][] dungeon) {
            int m = dungeon.length ;
            int n = dungeon[0].length ;
            int[][] dp = new int[m+1][n+1];
            for(int i = 0 ; i <= m ; i++){
                dp[i][n] = Integer.MAX_VALUE ;
            }
            for(int j = 0 ; j <= n ; j++){
                dp[m][j] = Integer.MAX_VALUE ;
            }
            dp[m][n-1] = 1 ; dp[m-1][n] = 1 ;
    
            for(int i = m-1 ; i >= 0 ; i--){
                for(int j = n-1 ; j >= 0 ; j--){
                    // if the cell is havig power up then ill be able to cancel it out with 1 
                    // else negatives will be converted to positive to have minimum health 
                    dp[i][j] = Math.max(Math.min(dp[i][j+1] , dp[i+1][j])-dungeon[i][j] , 1);
                }
            }
            return dp[0][0] ;
        }
        public int calculateMinimumHPII(int[][] dungeon) {
            int ans = solve(dungeon , 0 , 0);
            return ans >= 0 ? 1 : Math.abs(ans)+1 ;
        }
        public int solve(int[][] dungeon , int i , int j){
            if(i == dungeon.length-1 && j == dungeon[0].length-1) return dungeon[i][j];
            if(i >= dungeon.length || j >= dungeon[0].length) return 0 ; 
    
            int right = solve(dungeon , i , j+1);
            int down = solve(dungeon , i+1 , j);
    
            return dungeon[i][j] + Math.max(right , down);
        }
    }
}
