package LeetCode;

public class Day106 {
    class Solution {
        public int trapRainWater(int[][] height) {
            //Aims is to make four matrices 
            //preMax and SufMax rowise and columnwise 
            int n = height.length ; 
            int m = height[0].length ;
    
    
            int[][] preRow = new int[n][m];
            int[][] sufRow = new int[n][m];
            for(int i = 0 ; i < n ; i++){
                preRow[i][0] = height[i][0];
                for(int j = 1 ; j < m ; j++){
                    preRow[i][j] = Math.max(preRow[i][j-1] , height[i][j]);
                }
    
                sufRow[i][m-1] = height[i][m-1];
                for(int j = m-2 ; j >= 0 ; j--){
                    sufRow[i][j] = Math.max(sufRow[i][j+1] , height[i][j]);
                }
            }
    
    
    
            int[][] preCol = new int[n][m];
            int[][] sufCol = new int[n][m];
    
            for(int j = 0 ; j < m; j++){
                preCol[0][j] = height[0][j];
                for(int i = 1 ; i < n ; i++){
                    preCol[i][j] = Math.max(preCol[i-1][j] , height[i][j]);
                }
                sufCol[n-1][j] = height[n-1][j];
                for(int i = n - 2; i >= 0 ; i--){
                    sufCol[i][j] = Math.max(sufCol[i+1][j] , height[i][j]);
                }
            }
            // for(int i = 0 ; i < m ; i++){
            //     preCol[0][i] = height[0][i];
            //     sufCol[n-1][i] = height[n-1][i];
            // }
    
            // for(int i = 1 ; i < n ; i++){
            //     for(int j = 1 ; j < m ;j++){
            //         preRow[i][j] = Math.max(preRow[i][j-1] , height[i][j]);
            //         sufRow[m-i-1][j] = Math.max(sufRow[m-i-1][j+1] , height[i][j]);
            //     }
            // }
    
            // for(int j = 1 ; j < m ;j++){
            //     for(int i = 1 ; i < n ; i++){
            //         preRow[i][j] = Math.max(preRow[i][j-1] , height[i][j]);
            //         sufRow[m-i-1][j] = Math.max(sufRow[m-i-1][j+1] , height[i][j]);
            //     }
            // }
    
            int ans = 0 ; 
            for(int i = 1; i < n-1 ; i++){
                for(int j = 1 ; j < m-1 ; j++){
                    int minHeight = Math.min(Math.min(preRow[i][j] , sufRow[i][j]) , Math.min(preCol[i][j] , sufCol[i][j]));
                    if(minHeight > height[i][j]){
                        ans += minHeight - height[i][j];
                    }
                }
            }
    
            return ans ;
        }
    }
}
