import java.util.*;
public class Swapfunc {
    public static void swap( int a , int b ){
        int temp = a ;
        a = b ;
        b = temp ;
        System.out.println("The value of A after Swapping is : " + a);
        System.out.println("The value of B after Swapping is : " + b);
    }//the swapping function only works in the swap function i.e If there is no statement of print the value of
    // a and b is swap then the change in value remains in the swap function
    public static void main( String args [] ){
        Scanner sc = new Scanner (System.in);
        System.out.println("Enter the value of A :");
        int A = sc.nextInt();
        System.out.println("Enter the value of B :");
        int B = sc.nextInt();
        swap( A,B);
        System.out.println("The value of A without swapping is :"+A);
        System.out.println("The value of B without swapping is :"+B);
        sc.close();
    }//in the main function th evalue of a and b remains the same and it does'nt changes 
}