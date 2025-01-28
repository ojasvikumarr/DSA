package LeetCode; 

import java.util.* ; 

public class Day112 {
    class Solution {
        public int findMaxFish(int[][] grid) {
            //We'll traverse the grid 
            int n = grid.length ; 
            int m = grid[0].length ; 
    
            boolean[][] visited = new boolean[n][m];
            int maxi = 0 ; 
    
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(grid[i][j] > 0 && visited[i][j] == false){
                        maxi = Math.max(maxi , bfs(grid ,i , j , visited));
                    }
                }
            }
    
            return maxi ;
        }
        int[][] directions ={{1 , 0} , {-1 , 0} , {0 , -1} , {0 , 1}};
        public int bfs(int[][] graph , int row , int col , boolean[][] visited){
            Queue<int[]> q = new LinkedList<>();
    
            int sum = graph[row][col] ;
    
            q.add(new int[]{row , col});
    
            int n = graph.length ; 
            int m = graph[0].length ; 
            visited[row][col] = true; 
            
            while(!q.isEmpty()){
                int size = q.size();
                for(int i = 0 ; i < size ; i++){
                    int[] curr = q.poll();
                    int r = curr[0];
                    int c = curr[1];
                    for(int dir = 0 ; dir < 4 ; dir++){
                        int roo = r + directions[dir][0];
                        int coo = c + directions[dir][1];
                        if(roo < n && roo >= 0 && coo < m && coo >= 0 && graph[roo][coo] > 0 && visited[roo][coo] == false){
                            visited[roo][coo] = true ; 
                            sum += graph[roo][coo];
                            q.add(new int[]{roo , coo});
                        }
                    }
                }
            }
    
            return sum  ; 
        }
    }    
}
