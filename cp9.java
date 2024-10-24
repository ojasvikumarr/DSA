import java.util.*;

public class cp9 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt(); 
        sc.nextLine(); 

        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int[][] grid = new int[n][n];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < n ; j++){
                    grid[i][j] = sc.nextInt();
                }
            }
            System.out.println(helper(grid, n));
        }

        sc.close();
    }
    public static int helper(int[][] grid , int n){
        int i = 0 ; 
        int j = 0 ; 
        int[] arr = new int[n+n-1];
        int maxi = Integer.MAX_VALUE ;
        for(int x = 0 ; x< n ; x++){
            i = x ;
            j = 0 ;
            maxi = Integer.MAX_VALUE ;
            while(i < n && j < n){
                maxi = Math.min(maxi , grid[i][j]);
                i++ ; j++ ;
            }
            arr[x] = maxi <= 0 ? maxi : 0;
        }
        for( int y = 1 ; y < n ; y++){
            i = 0 ;
            j = y ;
            maxi = Integer.MAX_VALUE ;
            while(i < n && j < n){
                maxi = Math.min(maxi , grid[i][j]);
                i++ ; j++ ;
            }
            arr[n+y-1] = maxi <= 0 ? maxi : 0;
        }
        int sum = 0 ; 
        for(Integer it : arr) sum += it ;
        return Math.abs(sum);
    }
}
