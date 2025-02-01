package Graphs;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class LargestPlus {
    class Solution {
    public int orderOfLargestPlusSignII(int N, int[][] mines) {
        Set<Integer> banned = new HashSet();
        int[][] dp = new int[N][N];
        
        for (int[] mine: mines)
            banned.add(mine[0] * N + mine[1]);
        int ans = 0, count;
        
        for (int r = 0; r < N; ++r) {
            count = 0;
            for (int c = 0; c < N; ++c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = count;
            }
            
            count = 0;
            for (int c = N-1; c >= 0; --c) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
        }
        
        for (int c = 0; c < N; ++c) {
            count = 0;
            for (int r = 0; r < N; ++r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
            }
            
            count = 0;
            for (int r = N-1; r >= 0; --r) {
                count = banned.contains(r*N + c) ? 0 : count + 1;
                dp[r][c] = Math.min(dp[r][c], count);
                ans = Math.max(ans, dp[r][c]);
            }
        }
        
        return ans;
    }
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] dp = new int[n][n];
        for(int[] row : dp) Arrays.fill(row , n);

        Set<Integer> set = new HashSet<>();
        for(int[] mine : mines){
            set.add(mine[0]*n + mine[1]);
        } 

        //Left & Right Traversal...
        for(int i = 0 ; i < n ; i++){
            int preSum = 0 ; 
            for(int j = 0 ; j < n ; j++){
                if(set.contains(i*n + j)){
                    preSum = 0 ; 
                }else{
                    preSum += 1 ; 
                }
                dp[i][j] = preSum ; 
            }
            int sufSum = 0 ; 
            for(int j = n-1 ; j >= 0 ; j--){
                if(set.contains(i*n + j)){
                    sufSum = 0 ; 
                }else{
                    sufSum += 1 ; 
                }
                dp[i][j] = Math.min(dp[i][j] , sufSum);
            }
        }
        int result = 0 ;
        //Up and Down Traversal...
        for(int j = 0 ; j < n ; j++){
            int preSum = 0 ; 
            for(int i = 0 ; i < n; i++){
                if(set.contains(i*n + j)){
                    preSum = 0 ; 
                }else{
                    preSum += 1 ; 
                }
                dp[i][j] = Math.min(dp[i][j] , preSum);
            }
            int sufSum = 0 ; 
            for(int i = n-1 ; i >= 0 ; i--){
                if(set.contains(i*n + j)){
                    sufSum = 0 ; 
                }else{
                    sufSum += 1; 
                }
                dp[i][j] = Math.min(dp[i][j] , sufSum);
                result = Math.max(result , dp[i][j]);
            }
        }

        //We need to find the maximum plus sign from the grid 
         return result ; 
    }
    public int orderOfLargestPlusSignI(int n, int[][] mines) {
        int[][] grid = new int[n][n] ; 
        for(int[] row : grid) Arrays.fill(row , 1);
        for(int[] mine : mines){
            grid[mine[0]][mine[1]] = 0 ;
        }

        int result = 0 ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    int plus = 1 ; 
                    plus += solve(grid , i , j);
                    result = Math.max(plus , result);
                }
            }
        }
        return result ; 
    }
    //Lets first make the recursive four directions iteration 
    public int solve(int[][] grid , int i , int j){
        //we need to traverse all four directions 
        int n = grid.length ;

        int up = i-1 ; 
        int left = j-1 ; 
        int down = i+1 ; 
        int right = j+1 ; 

        // going up...
        int countUp = 0; 
        while(up >= 0){
            if(grid[up][j] == 0) break ; 
            countUp++ ;
            up-- ; 
        }
        // going left...
        int countLeft = 0; 
        while(left >= 0){
            if(grid[i][left] == 0 || countLeft > countUp) break ; 
            countLeft++ ;
            left-- ; 
        }
        // going down...
        int countDown = 0; 
        while(down < n){
            if(grid[down][j] == 0 || countDown > countLeft) break ; 
            countDown++ ;
            down++ ; 
        }
        // going right...
        int countRight = 0; 
        while(right < n){
            if(grid[i][right] == 0 || countDown < countRight) break ; 
            countRight++ ;
            right++ ; 
        }
        return Math.min(Math.min(countUp , countDown) , Math.min(countLeft , countRight));
    }
}
    class SolutionI {
    public int orderOfLargestPlusSign(int n, int[][] mines) {
        int[][] grid = new int[n][n] ; 
        for(int[] row : grid) Arrays.fill(row , 1);
        for(int[] mine : mines){
            grid[mine[0]][mine[1]] = 0 ;
        }

        int result = 0 ;

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 1){
                    int plus = 1 ; 
                    plus += solve(grid , i , j);
                    result = Math.max(plus , result);
                }
            }
        }
        return result ; 
    }
    //Lets first make the recursive four directions iteration 
    public int solve(int[][] grid , int i , int j){
        //we need to traverse all four directions 
        int n = grid.length ;

        int up = i-1 ; 
        int left = j-1 ; 
        int down = i+1 ; 
        int right = j+1 ; 

        // going up...
        int countUp = 0; 
        while(up >= 0){
            if(grid[up][j] == 0) break ; 
            countUp++ ;
            up-- ; 
        }
        // going left...
        int countLeft = 0; 
        while(left >= 0){
            if(grid[i][left] == 0 || countLeft > countUp) break ; 
            countLeft++ ;
            left-- ; 
        }
        // going down...
        int countDown = 0; 
        while(down < n){
            if(grid[down][j] == 0 || countDown > countLeft) break ; 
            countDown++ ;
            down++ ; 
        }
        // going right...
        int countRight = 0; 
        while(right < n){
            if(grid[i][right] == 0 || countDown < countRight) break ; 
            countRight++ ;
            right++ ; 
        }
        return Math.min(Math.min(countUp , countDown) , Math.min(countLeft , countRight));
    }
}
}
