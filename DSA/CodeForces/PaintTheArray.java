package CodeForces;

import java.util.Scanner;

public class PaintTheArray {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextLong();

                sb.append(solve(arr, n) + "\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
    public static long solve(long[] arr , int n){
        long evens = arr[0] ; 
        long odds = arr[1] ; 
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){
                evens = gcd(evens , arr[i]);
            }else{
                odds = gcd(odds , arr[i]);
            }
        }
        //we need to check if the alt is a factor of any of the element of the other sequence 
        // System.out.println(evens + " " + odds);
        boolean seq1 = true ;
        boolean seq2 = true ;
        for(int i = 0 ; i < n ; i++){
            if(i % 2 == 0){
                if(arr[i] % odds == 0){
                    seq1 = false ;
                }
            }else{
                if(arr[i] % evens == 0){
                    seq2 = false ;
                }
            }
        }
        if(seq1 || seq2){
            if(seq1 == true){
                return odds ; 
            }else {
                return evens ; 
            }
        }else{
            return 0 ; 
        }
    }
    public static long gcd(long a, long b){
        while(a != 0){
            long temp = a  ; 
            a = b%a ; 
            b = temp ; 
        }
        return b ; 
    }
}
