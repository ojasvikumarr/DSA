import java.util.* ; 
public class cp74 {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] grid = new int[n][m];
            int negs = 0 ; 
            int sum = 0 ; 
            int mini = Integer.MAX_VALUE ; 
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    grid[i][j] = sc.nextInt();
                    sum += Math.abs(grid[i][j]);
                    mini = Math.min(mini , Math.abs(grid[i][j]));
                    if(grid[i][j] < 0){
                        negs++ ; 
                    }
                }
            }
            if(negs%2 == 0){
                System.out.println(sum);
            }else{
                System.out.println(sum-2*mini);
            }

        }
        sc.close();
    }
}
