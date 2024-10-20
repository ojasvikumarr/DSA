package Graphs;

import java.util.HashSet;
import java.util.* ;
public class NoOfDistinctIsland {
    class Pair{
        int first ;
        int second ;
        public Pair(int first , int second){
            this.first = first ;
            this.second = second ;
        }
    }
    public void Dfs(int matrix[][] , boolean vis[][] , int row , int col , ArrayList<String> vec , int row0 ,int col0){
        int n= matrix.length ;
        int m = matrix[0].length ;
        vec.add(toString(row - row0 , col- col0));
        int delRow[]= {0 , -1 , 0 , +1};
        int delCol[]= {-1 , 0 , +1 , 0};
        vis[row][col] = true ;
        for(int i = 0 ; i < 4 ; i++){
            int nrow = row + delRow[i];
            int ncol = col + delCol[i];
            if(nrow >= 0 && nrow < n && ncol >= 0 && ncol < m && matrix[nrow][ncol] == 1 && !vis[nrow][ncol] ){
                vis[nrow][ncol] = true ;
                Dfs(matrix, vis, nrow, ncol , vec , row0 , col0);
            }
        }
    }
    private String toString(int r , int c){
        return Integer.toString(r) + " " + Integer.toString(c);
    }
    public int FillVisited(int[][] matrix){
        int n = matrix.length ;
        int m = matrix[0].length ;
        boolean[][] vis = new boolean[n][m];
        HashSet<ArrayList<String>> st = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            for(int j =0 ; j< m ; j++){
                if(!vis[i][j] && matrix[i][j] == 1){
                    ArrayList<String> vec = new ArrayList<>();
                    Dfs(matrix, vis, i, j , vec , i , j);
                    st.add(vec);
                }
            }
        }
        return st.size();
    }
}
