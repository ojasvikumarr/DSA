package CodeForces;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class EatingCandies {
    public static void main(String args[]){
        Scanner sc = new Scanner(System.in);
        StringBuilder sb = new StringBuilder();
        int t = sc.nextInt();
        while( t-- > 0 ){
            int n = sc.nextInt();
            int[] arr = new int[n];
            for(int i = 0 ; i < n ; i++) arr[i] = sc.nextInt();
            sb.append(solve(arr, n));
            sb.append("\n");
        }
        System.out.println(sb.toString());
        sc.close();
    }
    public static int solve(int[] arr , int n){
        int[] preSum = new int[n];
        int[] sufSum = new int[n];
        preSum[0] = arr[0];
        sufSum[n-1] = arr[n-1];
        for(int i = 1 ; i < n ; i++){
            preSum[i] = preSum[i-1] + arr[i];
        }
        Map<Integer , Integer> map = new HashMap<>();
        map.put(arr[n-1] , n-1);
        for(int i = n-2 ; i >= 0 ; i--){
            sufSum[i] = sufSum[i+1] + arr[i];
            map.put(sufSum[i] , i);
        }
        int maxi = Integer.MIN_VALUE;
        for(int i = 0 ; i < n ; i++){
            if(map.containsKey(preSum[i]) && map.get(preSum[i]) > i){
                maxi = Math.max(maxi , i+1 + n-map.get(preSum[i])) ;
            }
        }
        return maxi == Integer.MIN_VALUE ? 0 : maxi ;
    }
}
