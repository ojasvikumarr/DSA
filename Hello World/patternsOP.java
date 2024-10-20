import java.util.*;
public class patternsOP {
    public static void Hollow_Rectangle ( int totRow , int totCol){
        for ( int i = 1 ; i<=totRow ; i++ ){
            for ( int j = 1 ; j<=totCol ; j++ ){
                if ( i == 1 || i ==totRow || j ==1 || j ==totCol ){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
            }
            
            }
            System.out.println();
        }
        
    }
    public static void inverted_pyramid(int n){

        for ( int i = 1; i <= n ; i++ ){
            for ( int a = 1 ; a<=n-i ; a++){
                System.out.print(" ");

            }
            for ( int b = 1 ; b<=i ; b++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void number_pyramid(int n){
        for ( int i = 0; i<=n ; i++ ){
            for ( int z = 1; z<=n-i ; z++){
                System.out.print(z+" ");
            }
            for ( int x = 1; x<=i ; x++){
                System.out.print(" ");
            }
            System.out.println();
        }
    }
    public static void Floyd_triangle (int a){
        for ( int i = 1; i<=n ; i++){
            for( int x = x+1 ; x<=i ; x++){
                System.out.print(x+" ");
            }
            System.out.println();
        }
    }
    public static void main ( String args [ ] ){
        Scanner sc = new Scanner ( System.in );
        /*System.out.println("ENTER no. of rows : ");

        int a = sc.nextInt();
        System.out.println("ENTER no. of columns : ");

        int b = sc.nextInt();y
        */


        Hollow_Rectangle(10, 10 );
        inverted_pyramid(10);
        number_pyramid(10);
    }  
}