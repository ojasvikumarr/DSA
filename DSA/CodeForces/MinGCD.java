package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class MinGCD {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i = 0 ; i < n ; i++){
                arr[i] = sc.nextLong();
            }

            //check multiples if exists then there gcd if it is mini then true
            //i just need to find one multiple 
            Arrays.sort(arr);
            long g = -1 ; 
            for(int i = 1 ; i < n ; i++){
                if(arr[i] % arr[0] == 0){
                    if(g == -1){
                        g = arr[i];
                    }
                    g = gcd( arr[i] , g);
                    // System.out.println(arr[i] + " " + g);
                }
            }
            if(g == arr[0]){
                System.out.println("Yes");
            }else{
                System.out.println("No");
            }
        }
        sc.close();
    }
    public static long gcd(long a , long b){
        while(b != 0 ){
            long temp = b ; 
            b = a%b  ; 
            a = temp ;
        }
        return a ; 
    }
}
