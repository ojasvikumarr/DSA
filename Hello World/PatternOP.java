import java.util.*;
public class PatternOP {
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
        int x=1;
        for ( int i = 1; i<=a ; i++){
            for( int b = 1 ; b<=i ; b++){
                //int x = 1; it is always defined as x=1 as x is defined in the loop which is wrong , the loop is again and again making an varibale x which has value 1
                System.out.print(x+" ");
                x++;
                
            }
            System.out.println();
        }
    }
    public static void lOl_triangle( int a ){
        for (int i = a; i >=0 ; i--){
            for ( int b = 1 ; b <= i ; b++ ){
                if(b%2==0){
                    System.out.print("1 ");
                }
                else{
                    System.out.print("0 ");
                }
            }
            System.out.println();

        }
    }
    public static void butterfly(int n){
        for ( int i = 1; i <= n ; i++){
            for ( int j = 1; j<=i ; j++){
                System.out.print("*");
            }
            for ( int j = 1 ; j <=2*(n-i) ; j++){
                System.out.print(" ");
            }
            for ( int j = 1; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        } 
        for ( int i = n; i >= 0 ; i--){
            for ( int j = 1; j<=i ; j++){
                System.out.print("*");
            }
            for ( int j = 1 ; j <=2*(n-i) ; j++){
                System.out.print(" ");
            }
            for ( int j = 1; j<=i ; j++){
                System.out.print("*");
            }
            System.out.println();
        }
    }
    public static void rhombus( int n ){
        for ( int i=1 ; i<=n ; i++){
            for( int j = 1 ; j<=n-i ; j++){
                System.out.print(" ");
            }
            for( int j = 1 ; j<=n ; j++){
                System.out.print("8 ");
            }
            System.out.println();
        }
    }
    public static void hollow_rhombus(int n){
        for ( int i = 1; i <= n ;i++){
            for ( int j = 1; j<=n-i ; j++){
                System.out.print(" ");
            }
            for( int j = 1 ; j<=n ; j++){
                if ( i ==1 || i==n || j == n || j==1){
                    System.out.print("*");
                }
                else{
                    System.out.print(" ");
                }
                
            }
            System.out.println();
        }

    }
    public static void diamond( int n ){
        for ( int i = 1 ; i<=n ; i++){
            for ( int j = 1 ; j<n-i ; j++){
                System.out.print(" ");
            }
            for ( int j = 1 ; j<=(2*i)-1 ; j++){
                System.out.print("*");
            }
            for ( int j = 1 ; j<=n-i ; j++){
                System.out.print(" ");
            }
            System.out.println();
        }
        for ( int i = n ; i>=0 ; i--){
            for ( int j = 1 ; j<n-i ; j++){
                System.out.print(" ");
            }
            for ( int j = 1 ; j<=(2*i)-1 ; j++){
                System.out.print("*");
            }
            for ( int j = 1 ; j<=n-i ; j++){
                System.out.print(" ");
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
        Floyd_triangle(10);
        lOl_triangle(10);
        butterfly(10);
        rhombus(10);
        hollow_rhombus(10);
        diamond(10);
    }  
}