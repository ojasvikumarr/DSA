import java.util.*;
public class pattern1 {
    public static void main ( String args [] ){
        Scanner sc = new Scanner (System.in);
        System.out.println("how many stars do you want?");
        int n = sc.nextInt();
        for ( int o = 1 ; o <=n ; o++ ){
        for ( int i = 1 ; i <= n ; i++ ){
            for ( int star = 1 ; star <=i ; star++ ){
                System.out.print("*");
                if (i%2==0){
                    break;
                } 
            }
            System.out.println();//here this line is used for making the stars to the next line 
        }
        for ( int p = n ; p >=0 ; p-- ){
            for ( int star = 1 ; star <=p ; star++ ){
                System.out.print("*");
                if (p%2==0){
                    break;
                } 
            }
            System.out.println();//here this line is used for making the stars to the next line 
        }}
        sc.close();
    }
}