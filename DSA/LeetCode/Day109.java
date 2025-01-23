package LeetCode;

public class Day109 {
    class Solution {
        public int countServers(int[][] grid) {
            //TC O(2*m.n)
            //SC O(m+n)
            int n = grid.length ; 
            int m = grid[0].length ;
            int[] serverRow = new int[n] ;
            int[] serverCol = new int[m] ; 
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(grid[i][j] == 1){
                        serverRow[i]++ ;
                        serverCol[j]++ ;
                    }
                }
            }
    
            int result = 0 ; 
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(grid[i][j] == 1){
                        if(serverRow[i] > 1 || serverCol[j] > 1){
                            result++ ;
                        }
                    }
                }
            }
            return result ;
        }
    
        public int countServersII(int[][] grid) {
            //TC O(2*m.n + m.n)
            //SC O(m*n)
            int n = grid.length ; 
            int m = grid[0].length ;
            boolean[][] visited = new boolean[n][m];
    
            int result = 0 ; 
            for(int i = 0 ; i < n ; i++){
                int count = 0 ; 
                for(int j = 0 ; j < m ; j++){
                    if(grid[i][j] == 1){
                        count += grid[i][j];
                    }
                }
                if(count >= 2){
                    for(int j = 0 ; j < m ; j++){
                        if(grid[i][j] == 1){
                            visited[i][j] = true ;  
                        }
                    }
                    result += count ; 
                }
            }
    
            for(int j = 0 ; j < m ; j++){
                int visitCount = 0; 
                int unvisit = 0 ;
                for(int i = 0 ; i < n ; i++){
                    if(grid[i][j] == 1 && visited[i][j] == true){
                        visitCount++ ;
                    }else if(grid[i][j] == 1 && visited[i][j] == false){
                        unvisit++ ;
                    }
                }
                if(visitCount + unvisit >= 2){
                    result += unvisit ;
                }
            }
    
            return result ;
        }
    }
}
