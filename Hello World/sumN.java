import java.util.*;

public class sumN{
    public static void main ( String args[]){
        Scanner sc = new Scanner (System.in);
        do {
        System.out.println("enter the value of n ");
        int n = sc.nextInt();
        int sum = 0 ;
        int i = 1 ;
        while ( i <= n){
            sum += i;
            i ++;
            sc.close();
        }
        System.out.println("the sum of "+ n +" is "+ sum);
    }while ( true );

    }
}