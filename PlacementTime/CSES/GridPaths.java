package PlacementTime.CSES;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class GridPaths {
    public static void main(String[] args)throws IOException{
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[][] grid = new int[n][n];
        // StringTokenizer st ;
        for(int i = 0 ; i < n ; i++){
            // st = new StringTokenizer(br.readLine());
            String line = br.readLine();
            for(int j = 0 ; j < n ; j++){
                if(line.charAt(j) == '.'){
                    grid[i][j] = 0 ; 
                }else{
                    grid[i][j] = 1 ; 
                }
            }
        }
        int MOD = (int)1e9 + 7 ; 
        int[][] dp = new int[n+1][n+1];
        if(grid[n-1][n-1] == 1){
            System.out.println("0");
            // System.out.println("yes");
            return ; 
        }
        dp[n-1][n-1] = 1 ; 
        for(int i = n-1 ; i >= 0 ; i--){
            for(int j = n-1 ; j >= 0 ; j--){
                if(grid[i][j] == 1){
                    continue ;
                }else{
                    dp[i][j] += (dp[i+1][j] + dp[i][j+1])%MOD;
                }
            }
        }

        System.out.println(dp[0][0]);

        br.close();
    }
}
