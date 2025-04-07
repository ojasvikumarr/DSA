package CodeForces;

import java.util.Scanner;

public class SkiResort {
     public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int cap = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            solve(arr, n, k, cap);

        }
        sc.close();
    }
    public static void solve(int[] arr , int n , int k , int cap){
        int l = 0 ; 
        int r = 0 ; 
        long ans = 0 ; 
        while(r < n){
            while(r < n && arr[r] > cap){
                r++; 
                l++ ; 
            }
            while(r < n && arr[r] <= cap) r++ ; 
            //count window 
            while(l < r){
                long val = r - l - k + 1 ; 
                if(val > 0){
                    ans += val ; 
                }
                // System.out.println(ans+"--");
                l++ ; 
            }
            // r++ ; 
        }
        System.out.println(ans);
    }
}
