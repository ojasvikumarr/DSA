import java.util.* ; 

public class Matrix {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int m = sc.nextInt();
        int[][] s = new int[n][n];
        for(int i = 0 ; i < n; i++){
            String row = sc.next();
            for(int j = 0 ; j < n ; j++){
                s[i][j] = (row.charAt(j) == '.' ? 0 : 1);
            }
        }
        int[][] t = new int[m][m];
        for(int i = 0 ; i < m; i++){
            String row = sc.next();
            for(int j = 0 ; j < m ; j++){
                t[i][j] = (row.charAt(j) == '.' ? 0 : 1);
            }
        }
        solve(s , t);

        sc.close();
    }
    public static void solve(int[][] s , int[][] t ){
        int n = s.length ; 
        int m = t.length ;
        for(int i = 0 ; i <= n - m; i++){
            for(int j = 0 ; j <= n - m ; j++){
                if(containMatrix(s , t , i , j)){
                    System.out.println((i+1)+" "+(j+1));
                    return ; 
                }
            }
        }
    }
    public static boolean containMatrix( int[][] s , int[][] t , int i , int j){
        int m = t.length ; 
        // int n = s.length ; 
        for(int k = 0 ; k < m ; k++){
            for(int h = 0 ; h < m ; h++){
                if(s[i+k][j+h] != t[k][h]){
                    return false ;
                }
            }
        }
        return true ; 
    }
}