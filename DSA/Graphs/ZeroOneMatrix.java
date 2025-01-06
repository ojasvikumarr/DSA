package Graphs;
import java.util.*  ;
public class ZeroOneMatrix {
    class Solution {
        class Pair{
            int src ; 
            int dist ; 
            int r ; 
            int c ;
            public Pair(int s , int d , int r , int c){
                this.src = s ; 
                this.dist = d ; 
                this.r = r ; 
                this.c = c ;
            }
        }
        public int[][] updateMatrix(int[][] mat) {
            int n = mat.length ; 
            int m = mat[0].length ; 
            int[][] result = new int[n][m];
            Queue<Pair> q = new LinkedList<>();
            boolean[][] visited = new boolean[n][m];
            // O(n*m) == O(10^4)
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    if(mat[i][j] == 0){
                        visited[i][j] = true ;
                        q.add(new Pair(0 , 0 , i , j));
                        //result matrix is already 0 so no need to do anything 
                    }
                }
            }
            // O(n*m) == O(10^4)
            while(!q.isEmpty()){
                int size = q.size();
                //total run will n*m and 4 position
                for(int i = 0 ; i < size ; i++){
                    Pair p = q.poll();
                    int curr = p.src ; 
                    int dist = p.dist ; 
                    int r = p.r ; 
                    int c = p.c ;
                    int[] drow = new int[]{-1 , 0 , 1 , 0};
                    int[] dcol = new int[]{0 , -1 , 0 , 1};
                    for(int j = 0 ; j < 4 ; j++){
                        int row = r + drow[j];
                        int col = c + dcol[j];
                        if( row >= 0 && col >= 0 && row < n && col < m && visited[row][col] == false){
                            //the element at that index will be 1 only right 
                            //because all the 0s are in the queue 
                            visited[row][col] = true ;
                            q.add(new Pair(1 , dist+1 , row , col));
                            result[row][col] = dist+1 ;
                        }
                    }
                }
            }
            return result ; 
        }
    }
}
