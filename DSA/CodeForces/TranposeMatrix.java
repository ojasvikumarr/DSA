package CodeForces;

import java.util.Scanner;

public class TranposeMatrix {
     public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n; j++){
                    grid[i][j] = sc.nextInt();
                }
            }

            long diff = 0 ; 
            for(int i = 0 ;i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    if(grid[i][j] != grid[n-1-i][n-1-j]){
                        diff++ ; 
                    }
                }
            }
            diff /= 2 ; 
            if(diff > k){
                sb.append("NO");
            }else{
                sb.append("YES");
            }
            // if(solve(grid, n, k)){
            //     sb.append("YES");
            // }else{
            //     sb.append("NO");
            // }
            sb.append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
    public static boolean solve(int[][] grid , int n , int k){
        int same = 0 ; 
        int notSame =0 ;
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < n ; j++){
                if(grid[i][j] != grid[n-j-1][i]){
                    notSame++ ;
                }else{
                    same++ ; 
                }
            }
        }
        int x = 0 ; 
        int y = 0 ; 
        int val = 0 ; 
        int limit = 0 ; 
        if(n % 2 == 0){
            limit = n/2 - 1;
        }else{
            limit = (n+1)/2 - 1 ;
        }
        // System.out.println(limit);
        int cap = n-1 ; 
        while(x <= limit && y <= limit){
            for(int i = x , j = y; i < cap ; i++){
                int one = grid[i][j];
                int two = grid[n-1-j][i];
                int three = grid[n-1-i][n-1-j];
                int four = grid[n-1-(n-1-j)][n-i-1];
                int sum = one+two+three+four ;
                val += Math.min( sum , 4 - sum ) ; 
                // System.out.println(sum);
            }
            cap-- ;
            x++ ; 
            y++ ; 
        }
        // System.out.println(val);
        val = Math.min(val , Math.min(same , notSame));
        return k >= val ; 
    }
}
