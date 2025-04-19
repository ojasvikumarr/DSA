package CodeForces;

import java.util.Scanner;

public class Cats {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            // int N = n+1 ;
            // int K = k-1 ;
            // if(n%2 == 0){
            //     System.out.println((K%n)+1);
            // }else{
            //     //its odd 
            //     int posi = n-(K%n) ; // A ki posi 
            //     if(k%2 == 0){
            //         //gap of 2 
            //         System.out.println((posi+2)%n + 1);
            //     }else{
            //         System.out.println((posi+1)%n + 1);
            //     }
            // }
            if(n%2 == 0){
                //no skips 
                System.out.println((k-1)%n + 1);
            }else{
                int posi = (n)/2 ;
                int skips = (k-1)/posi ; 
                int a = (k-1)%n ;
                // System.out.println(posi + " " + skips + " " + a);
                System.out.println((a + skips)%n + 1);
            }
        }
        sc.close();
    }
}
