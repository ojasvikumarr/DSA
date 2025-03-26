package CodeForces;

import java.util.Scanner;

public class SlidingParity {
    public static void main(String[] args){
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        while(t-- > 0){
            int n = sc.nextInt();
            int[] arr = new int[n];
            int mini = Integer.MAX_VALUE ;
            for(int i = 0 ; i < n ; i++) {
                arr[i] = sc.nextInt();
                mini = Math.min(mini , arr[i]);
            }
            // solve(arr, n , mini);
            // solveII(arr, n);
            solveIII(arr, n);
        }
        sc.close();
    }
    public static void solveIII(int[] arr , int n){
        int ans = arr[0];
        int mn = Math.min(0, arr[0]);
        int sum = arr[0];
        for(int i = 1 ; i < n ; i++){
            if((arr[i] + arr[i-1]) % 2 == 0){
                mn = 0 ; 
                sum = 0 ; 
            }
            sum += arr[i];
            ans = Math.max(ans ,sum - mn);
            mn = Math.min(mn , sum);
        }
        System.out.println(ans);
        return  ;
    }
    public static void solveII(int[] arr , int n){
        long[] preSum = new long[n+1];
        preSum[0] = 0; 
        long maxi = Long.MIN_VALUE ; 
        boolean neg = true ; 
        for(Integer ele : arr){
            if(ele >= 0) neg = false ;
            maxi = Math.max(maxi, ele);
        }
        if(neg == true){
            System.out.println(maxi);
            return ;
        }
        maxi = Long.MIN_VALUE ;
        for(int i = 0 ; i < n ; i++){
            long sum = preSum[i] + arr[i];
            if(sum < 0){
                preSum[i+1] = 0 ;
            }else if(i > 0 && (arr[i-1] + arr[i]) % 2 == 0){
                preSum[i+1] = arr[i]; 
            }else{
                preSum[i+1] = sum ;
            }
            maxi = Math.max(maxi , preSum[i+1]);
        }
        System.out.println(maxi);
    }
    public static void solve(int[] arr , int n ){
        int l = 0 ; 
        int r = 0 ; 
        long maxi = Long.MIN_VALUE ; 
        long sum = 0; 
        boolean neg = true ; 
        for(Integer ele : arr){
            if(ele >= 0) neg = false ;
            maxi = Math.max(maxi, ele);
        }
        if(neg == true){
            System.out.println(maxi);
            return ;
        }
        // maxi = Long.MIN_VALUE ;
        while(r < n){
            sum += arr[r];
            if(sum < 0){
                while(sum < 0 && l <= r){
                    sum -= arr[l];
                    l++ ; 
                }
                // sum = 0;
                // l = r + 1;
            }else if(r > 0 &&((r-l+1) > 1)&& (arr[r-1] + arr[r])%2 == 0){
                sum = arr[r];
                l = r; 
            }
                maxi = Math.max(maxi , sum);
            r++ ; 
        }
        System.out.println(maxi);
        return ; 
    }
}
