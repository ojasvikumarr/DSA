package CodeForces;

import java.util.Scanner;

public class DemoDogs {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            long n = sc.nextLong();
            int MOD = (int)1e9 + 7 ; 
            long ans = (((((n*(n+1))%MOD)*(4*n-1))%MOD)*(long)337)%MOD ; 
            System.out.println(ans);
        }
        sc.close();
    }
}
