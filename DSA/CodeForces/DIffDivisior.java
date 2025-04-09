package CodeForces;

import java.util.Scanner;

public class DIffDivisior {
    public static void main(String[]args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int d = sc.nextInt();
            int a = 1+d ; 
            while(!isPrime(a)) a++ ; 
            int b = a+d ; 
            while(!isPrime(b)) b++ ; 
            System.out.println(a*b);
        }
        sc.close();
    }

    public static boolean isPrime(int x){
        if(x < 2) return false ;
        for(int i = 2 ; i*i <= x ; i++){
            if(x%i == 0) return false ;
        }
        return true ;
    }
}
