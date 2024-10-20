import java.util.*;
public class breek {
    public static void main( String args [] ){
        Scanner sc = new Scanner ( System.in );
        do {
            System.out.println("Enter any number :");
            int I = sc.nextInt();
            if ( I%10 ==0 ){
            break;
        }
        } while(true);
        System.out.println("I'm out of this loop ");
        sc.close();
    }
}