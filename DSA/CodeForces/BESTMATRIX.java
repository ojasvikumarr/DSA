import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class BESTMATRIX{
    public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner sc = new Scanner(System.in);
		    int t = sc.nextInt();
		    while(t-- > 0){
		        int n = sc.nextInt();
		        int m = sc.nextInt();
                int[][] grid = new int[n][m];
                for(int i = 0 ; i < n; i++){
                    for(int j = 0 ; j < m ; j++){
                        grid[i][j] = sc.nextInt();
                    }
                }

                solve(grid, n, m);
                System.out.println();
		    }
		sc.close();
	}
    public static void solve(int[][] grid , int n , int m ){
        int[] r_d = {1 , -1};
        int[] c_d = {1 , -1};
        long ans = Long.MAX_VALUE ;
        for(int r : r_d){
            for(int c : c_d){
                Map<Integer , Integer> map = new HashMap<>();
                for(int i = 0 ; i < n ; i++){
                    for(int j = 0 ; j < m ; j++){
                        int diff = grid[i][j] - i*r - j*c ; 
                        System.out.print(diff + " ");
                        map.put(diff , map.getOrDefault(diff , 0)+1);
                    }
                    System.out.println();
                }
                long maxi = 0 ; 
                for(Integer key : map.keySet()){
                    maxi = Math.max(maxi , map.get(key));
                }
                ans = Math.min(ans , n*m - maxi);
            }
        }
        System.out.println(ans);
    }
}