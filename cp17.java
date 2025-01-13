import java.util.* ;
public class cp17 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            String path = sc.next();
            int[][] grid = new int[n][m];
            for(int i = 0 ; i < n ; i++){
                for(int j = 0 ; j < m ; j++){
                    grid[i][j] = sc.nextInt();
                }
            }
            solve(grid , n , m , path);
        }
        sc.close();
    }
    public static void solveII(int[][] grid , int n , int m , String path){
        int row = 0 ; 
        int col = 0 ;
        int sum = 0 ; 
        for(int i = 0 ; i < path.length() ; i++){
            if(path.charAt(i) == 'R'){
                sum = 0 ;
                for(int j = 0 ; j < n ; j++){
                    sum += grid[row][j];
                }
                grid[row][col] = -sum ;
                col++ ;
            }else{
                sum = 0 ; 
                for(int j = 0 ; j < m ; j++){
                    sum += grid[j][col];
                }
                grid[row][col] = -sum ; 
                row++ ;
            }
        }
        for(int i = 0 ; i < n ; i++){
            sum += grid[i][j];
            
        }
    }
    public static void solve(int[][] grid , int n ,int m ,String str){
        int sum = 0 ; 
        for(int i = 0 ; i < n ; i++){
            sum += grid[0][i];
        }
        //Now the first cell will be the negative of the sum of the row 
        grid[0][0] = -sum;
        //This will ensure that i am maing the total sum of the row and col to be 0 

    }
}
