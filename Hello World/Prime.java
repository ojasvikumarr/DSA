import java.util.*;
public class Prime {
    public static void main ( String args [] ){
        Scanner sc = new Scanner ( System.in );
        System.out.println("Enter your number :");
        int n = sc.nextInt();
        
        if (n == 2){
            System.out.println("your number is prime!!!");

        }
        else {
            boolean isPrime= true;
        for ( int i = 2 ; i <=Math.sqrt(n) ; i++ ){
            if( n%i == 0 ){
                isPrime= false;
            }
        }
        if ( isPrime = true){
            System.out.println("your number is prime!!");
        }
        else {
            System.out.println("your number is not prime!");
        }
        
    }
}

}