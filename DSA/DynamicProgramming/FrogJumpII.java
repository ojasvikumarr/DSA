package DynamicProgramming;

public class FrogJumpII {
    class Solution {
        int [] dp ; 
        int minCost(int[] height) {
            // code here
            dp = new int[height.length];
            for(int i = 0 ; i < height.length ; i++) dp[i] = -1 ;
            // return solve(height , height.length-1);
            return tabulation(height);
        }
        int solve(int[] arr , int idx){
            if(idx == 0){
                //that we have reached the end 
                return 0 ;
            }
            if(dp[idx] != -1) return dp[idx];
            int first = solve(arr , idx-1) + Math.abs(arr[idx]-arr[idx-1]);
            int sec = Integer.MAX_VALUE ;
            if(idx > 1){
                sec = solve(arr , idx-2) + Math.abs(arr[idx]-arr[idx-2]);
            }
            return dp[idx] = Math.min(first , sec);
        }
        int tabulation(int[] arr){
            int n = arr.length ;
            // int[] tab = new int[n];
            int prev1 = 0 ; 
            int prev2 = 0 ; 
            int curr = 0; 
            // tab[0] = 0 ; 
            for(int i = 1 ; i < n ; i++){
                int one = prev1 + Math.abs(arr[i] - arr[i-1]);
                int two = Integer.MAX_VALUE ; 
                if(i > 1){
                    two = prev2 + Math.abs(arr[i] - arr[i-2]);
                }
                curr = Math.min(one , two);
                prev2 = prev1 ; 
                prev1 = curr ;
            }
            return prev1 ;
        }
    }
}
