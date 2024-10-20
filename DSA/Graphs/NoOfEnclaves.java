package Graphs;
import java.util.* ;

public class NoOfEnclaves {
    //similar to replacing O's with X's
/////this is by dfs 
    public static void dfs (int[][] grid , boolean[][] vis , int row , int col ){
        int n = vis.length ;
        int m = vis[0].length ;
        int delRow[] = {0 , -1 , 0 , +1};
        int delCol[] = {-1 , 0 , +1 , 0};
        for(int i = 0 ; i < 4 ; i++){
            vis[row][col] = true ;
            int newrow = row + delRow[i];
            int newcol = col + delCol[i];
            if(newrow >= 0 && newrow <= n && newcol >= 0 && newcol <= m && vis[newrow][newcol] == false && grid[newrow][newcol] == 1){
                dfs(grid, vis, newrow, newcol);
            }
        }
    }
    public static int Fillgrid(int[][] grid){
        int n = grid.length;
        int m = grid[0].length ; 

        boolean vis[][] = new boolean[n][m];
        //first row and last row 
        for(int j = 0 ; j < m ; j++){
            if(!vis[0][j] && grid[0][j] == 1){
                dfs(grid , vis , 0 , j);
            }
            if(!vis[n-1][j] && grid[n-1][j] == 1){
                dfs(grid , vis , n-1 , j);
            }
        }
        //first column and last column 
        for(int i = 0 ; i < n ; i++){
            if(!vis[i][0] && grid[i][0] == 1){
                dfs(grid , vis , i , 0);
            }
            if(!vis[i][m-1] && grid[i][m-1] == 1){
                dfs(grid , vis , i , m-1);
            }
        }
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(!vis[i][j] && grid[i][j] == 1){
                    count++ ;
                }
            }
        }
        return count ;
    }
////// this is by bfs
    class Pair{
        int first ;
        int second ;
        public Pair(int i , int j){
            this.first = i ;
            this.second = j ;
        }
    }
    public int NoOfenclaves(int grid[][]){
        Queue<Pair> q = new LinkedList<Pair>();
        int n = grid.length ;
        int m = grid[0].length ;
        boolean vis[][] = new boolean[n][m];

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j ++){
                //first row , last col , last row , first col 
                if(i == 0 || i == n-1 || j == 0 || j == m-1){
                    if(grid[i][j] == 1){
                        q.add(new Pair(i,j));
                        vis[i][j] = true ;
                    }
                }
            }
        }
        int delRow[] = {-1 , 0 , +1 , 0};
        int delCol[] = {0 , +1 , 0 , -1};
        while(!q.isEmpty()){
            int row = q.peek().first ;
            int col = q.peek().second ; 
            q.remove();

            //traverse all 4 directions 
            for(int i = 0 ; i < 4 ; i++){
                int nrow = row + delRow[i];
                int ncol = col + delCol[i];
                if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && !vis[nrow][ncol] && grid[nrow][ncol] == 1){
                    q.add(new Pair(nrow , ncol));
                    vis[nrow][ncol] = true ;
                }
            }
        }
        int count = 0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                if(grid[i][j] == 1 && !vis[i][j]){
                    count++ ;
                }
            }
        }
        return count ;

    }
}
