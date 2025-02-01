package Graphs;

import java.util.Arrays;

public class LargestPlus {
    class Solution {
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
