package CodeForces;

import java.util.Arrays;
import java.util.Scanner;

public class BrMeast {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            long[] arr = new long[n];
            for(int i = 0 ;i < n ; i++) arr[i] = sc.nextLong();
            // solve(arr, n);
            solveII(arr, n);
        }
        sc.close();
    }
    public static void solveII(long[] arr , int n){
        long[] preSum = new long[n+1];
        for(int i = 0 ; i < n ; i++){
            preSum[i+1] = preSum[i] + arr[i];
        }
        long diff = Long.MIN_VALUE ;
        int k = 1 ; 
        while(k <= n){
            if(n%k == 0){
                long mini = Long.MAX_VALUE ;
                long maxi = Long.MIN_VALUE ;
                for(int i = k ; i <= n ; i += k){
                    long val = preSum[i] - preSum[i - k];
                    mini = Math.min(mini , val);
                    maxi = Math.max(maxi , val);
                }
                diff = Math.max(diff , maxi - mini);
            }
            k++ ; 
        }
        System.out.println(diff);
        return ;
    }
    public static void solve(long[] arr , int n){
        long min = 0 ; 
        long max = 0 ; 
        Arrays.sort(arr);
        int i = 0 ; 
        int j = n-1 ; 
        int k = 0 ; 
        long maxi = Long.MIN_VALUE ;
        while(i < j){
            min += arr[i];
            max += arr[j];
            i++ ; 
            j-- ; 
            k++ ; 
            if(n%k == 0){
                maxi = Math.max(maxi , max-min);
            }
        }
        System.out.println(maxi);
        return ; 
    }
}
