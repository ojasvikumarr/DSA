package BackTracking;
import java.util.*;

public class Hww{
    public static int IntToBin( int n ){
        int p = 0 ;
        int m = 0 ;
        while( n>0 ){
        int LastDigit = n%2 ;
        m = m + (int)( LastDigit*Math.pow(10,p));
            n /= 2 ;
            p++;
        }
        return m ;
        
    }

    public static int BinTOInt( int n ){
        int lastDigit ; 
        int m = 0 ; 
        int pow = 0  ;
        while( n > 0){
            lastDigit = n%10 ;
            m += lastDigit*Math.pow(2 , pow);
            n/= 10 ;
            pow++ ;
        }
        return m ;
    }
    public static void main( String arg[]){
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter your number!!!");
        int n = sc.nextInt();
        System.out.println(IntToBin(n));
        int m = sc.nextInt();
        System.out.println(BinTOInt(m));
        sc.close();
    }
}