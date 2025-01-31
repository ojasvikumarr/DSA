package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Queue;
import java.util.Set;
import java.util.* ;

public class Day115 {
    class Solution {
    public int largestIsland(int[][] grid) {
        //Brute Force 
        //TO change each n every cell that is 0 to 1 
        //And implement a DFS or BFS on the grid for every 0 converted to 1 
        //ANd find out the largest size of the component 
        int color = 1 ; 
        //PreComputing the Areas of the components in the grid 
        int n = grid.length ; 
        HashMap<Integer, Integer> map = new HashMap<>();
        boolean[][] visited = new boolean[n][n];

        int area = 0 ; 

        for(int row = 0 ; row < n ; row++){
            for(int col = 0 ; col < n ; col++){
                if(grid[row][col] == 1 && visited[row][col] == false){
                    int result = bfs(grid , row , col , visited ,color);
                    area = Math.max(area , result);

                    map.put(color , result);
                    color++ ;
                }
            }
        }

        
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] == 0){
                    grid[i][j] = 1 ; 
                    //We'll do the BFS on this new grid 
                    //We check all foure directions for cells other that 0 
                    int CombinedComp = 1 ; 
                    Set<Integer> colors = new HashSet<>();
                    for(int dir = 0 ; dir < 4 ; dir++){
                        int row = i + directions[dir][0];
                        int col = j + directions[dir][1];
                        if(row < n && col < n && row >= 0 && col >= 0 && grid[row][col] != 0 && !colors.contains(grid[row][col])){
                            CombinedComp += map.get(grid[row][col]);
                            colors.add(grid[row][col]);
                        }
                    }
                    area = Math.max(area , CombinedComp);
                    grid[i][j] = 0 ; 
                }
            }
        }
        return area ; 
    }
    int[][] directions = {{1 , 0} , {-1 , 0} , {0 , 1} , {0 , -1}};
    public int bfs(int[][] grid , int i , int j , boolean[][] visited , int color){
        int n = grid.length ; 
        Queue<int[]> q = new LinkedList<>();
        int area = 1 ; 
        q.add(new int[]{i , j});
        visited[i][j] = true; 

        while(!q.isEmpty()){
            int[] curr = q.poll();
            int row = curr[0];
            int col = curr[1];
            grid[row][col] = color ; 
            for(int dir = 0 ; dir < 4 ; dir++){
                int roo = row + directions[dir][0];
                int coo = col + directions[dir][1];
                if(roo >= 0 && roo < n && coo >= 0 && coo < n && visited[roo][coo] == false && grid[roo][coo] == 1){
                    area++ ; 
                    visited[roo][coo] = true; 
                    q.add(new int[]{roo , coo});
                }
            }
        }
        return area ; 
    }
    // public void dfs(int[][] grid , int i , int j , int[][] visited){
    //     int n = grid.length ; 
    //     visited[i][j] = true ;
    //     int area = 0 ;
    //     for(int dir = 0 ; dir < 4 ; dir++){
    //         int row = i + directions[dir][0];
    //         int col = j + directions[dir][1];
    //         if(row >= 0 && row < n && col >= 0 && col < n && visited[row][col] == false && grid[row][col] == 1){
    //             dfs(grid , row , col, visited);
    //         }
    //     }
    // }
}
}
