package CodeForces;

import java.util.Scanner;

public class Quests {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int[] a = new int[n];
            int[] b = new int[n];
            long[] preSum = new long[n+1];
            long[] preMax = new long[n+1];
            for(int i = 0 ; i < n; i++){
                a[i] = sc.nextInt();
                preSum[i+1] += preSum[i] + a[i];
            }
            for(int i = 0 ; i < n; i++){
                b[i] = sc.nextInt();
                preMax[i+1] = Math.max(preMax[i] , b[i]);
            }
            solve(preSum, preMax, k, n);

        }
        sc.close();
    }
    public static void solve(long[] preSum , long[] preMax , int k , int n){
        long res = 0 ; 
        int i = 0 ; 
        long rem = 0 ;
        if(k <= n){
            rem = 0 ; 
            i = k ; 
        }else{
            rem = k - n ;
            i = n ; 
        }
        while( i >= 0 ){
            res = Math.max(res , preSum[i] + preMax[i]*rem);
            i-- ; 
            rem++ ; 
        }
        System.out.println(res);
    }
}
