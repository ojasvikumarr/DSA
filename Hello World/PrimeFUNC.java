import java.util.*;
public class PrimeFUNC {
    //public static boolean Prime(int a){
    //    boolean Prime = true ;
    //    for ( int i = 1 ; i<=a-1 ; i++ ){
    //        Prime = false ;
    //        break;
    //    }
    //    return Prime;
    //}
    //can also be written as
    public static boolean Prime(int a){
        for ( int i = 1 ; i<=Math.sqrt(a) ; i++ ){
            return false;
        }
        return true;
    }

    public static void Primerange( int a ){
        for ( int i = 2 ; i <= n ; i++ ){
            if ( Prime(a) ){
                System.out.print(i);
            }
        }
        System.out.println();
    }

    public static void main ( String args[] ){
    Scanner sc= new Scanner ( System.in );
    int a=sc.nextInt();
    int n=sc.nextInt();
            System.out.println("your number is : " + Prime(a));
            System.out.println("all the prime numbers in till "+n+"is :"+primerange(n));
    }
}