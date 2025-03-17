package DynamicProgramming;

public class FrogJumpsKsteps {
    class Solution {
        int[][] dp ; 
        public int minimizeCost(int k, int arr[]) {
            // code here
            int n = arr.length ;
            dp = new int[n][k+1];
            for(int i = 0 ; i < n ; i++)
                for(int j = 0 ; j <= k ; j++) dp[i][j] = -1 ; 
            // return solve(arr , k , n-1);
            return tabulation(arr , k);
        }
        public int solve(int arr[] , int k , int idx){
            if(idx == 0){
                return 0 ; 
            }
            if(dp[idx][k] != -1) return dp[idx][k];
            int mini = Integer.MAX_VALUE ; 
            for(int i = 1; i <= k ; i++){
                if(idx >= i)
                mini = Math.min(mini , solve(arr , k , idx-i) + Math.abs(arr[idx] - arr[idx-i]));
            }
            return dp[idx][k] = mini ; 
        }
        public int tabulation(int[] arr , int k){
            //Bottom up 
            //Base case to the required result 
            //At base what we know? is that at idx 0 we have 0 result 
            int n = arr.length ;
            int[]tab = new int[n];
            //for every idx 0 we have result as 0 because we cant practically jump anywhere 
            // for(int i = 0 ; i <= k ; i++) tab[0][i] = 0 ; 
            tab[0] = 0 ; 
            //Its wasnt needed as by default the array was initialized by 0 in java 
            //Now lets traverse the array 
            //as the base case of i == 0 is fulfilled we will now traverse from i =1 to i = n-1
            //And the value of k goes from 1 to k 
            for(int i = 1 ; i < n ; i++){
                int mini = Integer.MAX_VALUE ;
                for(int j = 1 ; j <= k; j++){
                    if(i >= j){
                        //as we cant go beyond 0 
                        mini = Math.min(mini , tab[i-j] + Math.abs(arr[i] - arr[i-j]));
                    }
                }
                tab[i] = mini ; 
            }
            return tab[n-1];
        }
    }
}
