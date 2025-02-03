import java.util.*  ;
import java.util.Arrays;
public class cp21 {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int m = sc.nextInt();
            int[][] matrix = new int[n][m+1];
            int count = -1 ; 
            for(int i = 0 ; i < n ; i++){
                matrix[i][0] = count ; 
                count-- ;
            }
            for(int i = 0 ; i < n; i++){
                for(int j = 1 ; j <= m ; j++){
                    matrix[i][j] = sc.nextInt();
                }
            }
            solve(matrix);
        }
        sc.close();
    }    
    public static void solve(int[][] matrix){
        //we need to sort every row ; 
        int n = matrix.length ; 
        int m = matrix[0].length ; 

        for(int[] row : matrix){
            Arrays.sort(row);
        }
        //Now we need to sort on basis of 1st element 
        Arrays.sort(matrix , (a , b) -> a[1] - b[1]);

        // Now we just need to check if the increasing order in possible or not 
        // for(int i =0  ; i < n ; i++){
        //     for(int j = 0 ; j < m ; j++){
        //         System.out.print(matrix[i][j] + " " );
        //     }
        //     System.out.println();
        // }
        int dummy = -1;
        for(int j = 1 ; j < m ; j++){
            for(int i = 0 ; i < n ; i++){
                // System.out.print(matrix[i][j]);
                if(matrix[i][j] < dummy){
                    System.out.println(-1);
                    return ; 
                }
                dummy = matrix[i][j];
            }
            // System.out.println();
        }
        for(int i = 0 ; i < n ;i++){
            System.out.print(Math.abs(matrix[i][0])+" ");
        }
        System.out.println();
    }
}
