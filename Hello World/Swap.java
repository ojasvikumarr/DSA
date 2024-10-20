import java.util.*;
public class Swap {
    public static void main( String args [] ){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the value of A :");
        int A = sc.nextInt();
        System.out.println("Enter the value of B :");
        int B = sc.nextInt();

        int temp = A ;
        A = B ;
        B = temp ;
        System.out.println("The value of A after Swapping is : " + A);
        System.out.println("The value of B after Swapping is : " + B);
        sc.close();
    }
}