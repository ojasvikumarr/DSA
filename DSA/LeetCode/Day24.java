public class Day24 {
    public static int CherryPickup(int i , int j1 , int j2 , int n , int m , int[][] grid , int[][][] dp){
        if(j1 < 0 || j2 > 0 || j1 >= m || j2 >= m){
            return (int)-1e8 ;
        }
        if(i == n-1){
            if(j1 == j2){
                return grid[i][j1];
            }
            else{
                return grid[i][j1]+ grid[i][j2];
            }
        }
        if(dp[i][j1][j2] != -1){
            return dp[i][j1][j2];
        }//we can assume that har ithe row ke liye kitne j1 , j2 ke sath mein combinations hongay?? 

        //explore all the paths of alice and bob simultaneously 
        int maxi = (int) -1e8 ;
        for(int dj1 = -1 ; dj1 <= 1 ; dj1++){
            for(int dj2 = -1 ; dj2 <= 1 ; dj2++){
                int value = 0 ; 
                if(j1 == j2){
                    value = grid[i][j1];
                }
                else{
                    value = grid[i][j1] + grid[i][j2];
                }
                value += CherryPickup(i+1, j1+dj1, j2+dj2, n, m, grid , dp);
                maxi = Math.max(maxi , value);
            }
        }

        return dp[i][j1][j2] =  maxi ;
    }

    public static void main(String[] args){
        int n = 10 ;
        int m = 20 ;
        int[][] grid = new int[n][m];
        int dp[][][] = new int[n][m][m];
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < m ; j++){
                for(int k = 0 ; k < m ; k++){
                    dp[i][j][k] = -1 ;
                }
            }
        }
        CherryPickup(0, 0, m-1, n, m, grid , dp);
    }
}
