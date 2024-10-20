import java.util.*;

public class ReverseNumber {
    public static void ReverseNo( int n){
        while( n > 0){
        int lastdigit = n%10 ;
        n /= 10;
        System.out.print(lastdigit);
        }
    }
    public static void main( String args[]){
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println("enter your number!!!"+ n);
        ReverseNo(n);
        sc.close();
    }
}
