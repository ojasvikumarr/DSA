package LeetCode;

import java.util.Queue;
import java.util.* ;

public class Day108 {
    class Solution {
    public int[][] highestPeak(int[][] grid) {
        Queue<int[]> q = new LinkedList<>();
        int n = grid.length ; 
        int m = grid[0].length ; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1){
                    grid[i][j] = 0 ; 
                    q.add(new int[]{i , j});
                }else{
                    grid[i][j] = - 1;
                }
            }
        }
        int[][] directions = {{-1 , 0} , {1 , 0} , {0 , 1} , {0 , -1}};
        while(!q.isEmpty()){
            int size = q.size();
            for(int i = 0 ; i < size ; i++){
                //we'll check the neighbors 
                int[] pair = q.poll();
                int row = pair[0];
                int col = pair[1];
                for(int[] direc : directions){
                    int roo = direc[0] + row ; 
                    int coo = direc[1] + col ;
                    if( roo >= 0 && coo >= 0 && roo < n && coo < m && grid[roo][coo] == -1){
                        grid[roo][coo] = grid[row][col] + 1 ; 
                        q.add(new int[]{roo , coo});
                    }
                }
            }
        }

        return grid ;
    }
}
}
