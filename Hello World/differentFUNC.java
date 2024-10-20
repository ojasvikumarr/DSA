//import java.util.*;
public class differentFUNC{
    public static int multiply(int a , int b){
        int product = a*b;
        return product;

    }

    public static int nCr(int n , int r ){
        int a = factorial (n);
        int b = factorial (r);
        int c = factorial (n-r);
        int d = a/(b*c);
        return d;
    }

    public static int factorial(int n){
        int pro=1;
        for(int i = 1 ; i<=n ; i++ ){
            pro *= i ;
        }
        return pro;
    }

    public static void main ( String args [] ){
        int d = 10;
        int f = 20;
        //int g = 10;
        //int h = 2;
        //multiply(d,f);
        System.out.println(multiply(d,f));
        System.out.println(" The factorial of the given number is : " + factorial(10) );
        System.out.println(" The binomial coefficient of n and r is : " + nCr(10,2));
    }
}