import java.util.*;
public class pattern2 {
    public static void main ( String args [] ){
        Scanner sc = new Scanner (System.in);
        System.out.println("how many stars do you want?");
        int n = sc.nextInt();
        for ( int o = 1 ; o <=n ; o++ ){
        for ( int i = 1 ; i <= n ; i++ ){
            for ( int star = 1 ; star <=i ; star++ ){
                System.out.print(star);
                
            }
            System.out.println();//here this line is used for making the stars to the next line 
        }
    }
    }
}