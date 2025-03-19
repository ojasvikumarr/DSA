package PlacementTime.DP;

import java.util.Arrays;
import java.util.List;

public class TraingaleRain {
    class Solution {
    int[][] memo ; 
    public int minimumTotal(List<List<Integer>> triangle) {
        //as there can be many paths 
        // recursion seems to be the best optionin findint the minimimum path sum 
        //after exploring all the paths 
        //top down approach 
        // from the destination to the origin 
        // so from the base we are moving to the top
        // int mini = Integer.MAX_VALUE ;
        int n = triangle.size();
        int m = triangle.get(n-1).size();
        // memo = new int[n][m];
        // for(int[] row : memo) Arrays.fill(row , -1);
        // for(int i = 0 ; i < m ; i++){
        //     mini = Math.min(mini , solve(triangle , n-1 , i));
        // }
        // return mini ; 
        return tabulation(triangle , n , m);
    }

    public int tabulation(List<List<Integer>> triangle , int n , int m ){
        //bottom up approach 
        //from the base case to the req case

        // [2]
        // [3][4]
        // [6][5][7]
        // [4][1][8][3]
        // [][][][][][]
        // [][2]
        // [][5][6]
        // [][11][10][13]
        // [][15][11][18][16] min == > 11 formula is Math.min(j, j-1)
        
        // int[][] tab = new int[n+1][m+1];
        int[] prev = new int[m+1];
        int[] curr = new int[m+1];
        //base case 
        // for(int[] row : tab) Arrays.fill(row , Integer.MAX_VALUE);
        Arrays.fill(prev , Integer.MAX_VALUE);
        Arrays.fill(curr , Integer.MAX_VALUE);
        // tab[1][1] = triangle.get(0).get(0);

        prev[1] = triangle.get(0).get(0);
        for(int i = 2 ; i <= n ; i++){
            for(int j = 1 ; j <= i ; j++){
                if(i == 1 && j == 1) continue ;
                curr[j] = Math.min(prev[j] , prev[j-1]) + triangle.get(i-1).get(j-1);
            }
            prev = Arrays.copyOf(curr , m+1);
        }
        int mini = Integer.MAX_VALUE ; 
        for(int i = 1 ; i <= m ; i++){
            mini = Math.min(mini , prev[i]);
        }
        return mini ; 
    }
    public int solve(List<List<Integer>> triangle , int i , int j ){
        //base case 
        if(i == 0 && j == 0){
            return triangle.get(0).get(0);
        }else if(j >= triangle.get(i).size() || j < 0 ){
            return Integer.MAX_VALUE ; 
        }
        //from a cell i have two options either to go upwards 
        //or left diagonally 
        if(memo[i][j] != -1) return memo[i][j];
        int up = solve(triangle , i-1 , j);
        int leftUp = solve(triangle , i-1 , j-1);
        return memo[i][j] = Math.min(up , leftUp) + triangle.get(i).get(j);
    }
}
}
