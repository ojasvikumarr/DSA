import java.util.*;
/* so the 2D arrays have memory stored in such a way that a 3x3 matrix will form 
 * three arrays in random position in the memory 
 *  these array sare in row format they might be continues or not itd just a coincidence that they are 
 */
public class Matrix{
    public static boolean Search(int Matrix[][], int key){
        for( int i=0 ; i<Matrix.length ; i++){
            for(int j= 0 ; j<Matrix[0].length ; j++){
                if (Matrix[i][j] == key){
                    System.out.println("Found at cell ("+i+","+j+")");
                    return true;
                }
            }
        }
        return false;
    }
    public static void main( String args[] ){
        int Matrix [][]= new int [3][3];
        int n = Matrix.length , m=Matrix[0].length;

        try (Scanner sc = new Scanner (System.in)) {
            //input
            for( int i=0 ; i<n ; i++){
                for(int j= 0 ; j<m ; j++){
                    Matrix[i][j]=sc.nextInt();
                }
            }
        }
        //output
        for( int i=0 ; i<n ; i++){
            for(int j= 0 ; j<m ; j++){
                System.out.print(Matrix[i][j] + " ");
            }
            System.out.println();
        }
        Search(Matrix,9);
    }
}