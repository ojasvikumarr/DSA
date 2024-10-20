import java.util.*;
public class Factorial {
    public static void main( String args [] ){
        Scanner sc = new Scanner ( System.in );
        System.out.println("of which number you need it's factorial : ");
        int n = sc.nextInt();
        int product=1;
        for ( int o = 1 ; o <= n ; o ++){
            product *= o;

        }
        System.out.println(n + "! is : "+ product);
        sc.close();
    }
}