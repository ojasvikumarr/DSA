import java.util.*;
public class pattern3 {
    public static void main ( String args [] ){
        Scanner sc = new Scanner ( System.in );
        System.out.println("how many letters do you want? ");
        int n = sc.nextInt();
        //System.out.println("From which letter do you want to start ?");
        char ch = 'A';
        for ( int i = 1 ; i <= n ; i++ ){
            for ( int chars = 1 ; chars<=i ; chars++ ){
                System.out.print(ch);
                ch++;

            }
            System.out.println();
        }

    }
}