package LeetCode ; 
public class Day143 {
    class Solution {
        public int lenLongestFibSubseq(int[] arr) {
            int n = arr.length;
            int[][] dp = new int[n][n];
            int maxLen = 0;
            
            for (int curr = 2; curr < n; curr++) {
                int start = 0, end = curr - 1;
                while (start < end) {
                    int pairSum = arr[start] + arr[end];
                    if (pairSum > arr[curr]) {
                        end--;
                    } else if (pairSum < arr[curr]) {
                        start++;
                    } else {
                        dp[end][curr] = dp[start][end] + 1;
                        maxLen = Math.max(dp[end][curr], maxLen);
                        end--;
                        start++;
                    }
                }
            }
            return maxLen == 0 ? 0 : maxLen + 2;
        }
        public int lenLongestFibSubseqII(int[] arr) {
            int n = arr.length ; 
            int maxi = 0 ; 
            for(int i = 0 ; i < n-1 ; i++){
                for(int j = i+1 ; j < n ; j++ ){
                    maxi = Math.max(maxi , solve(arr , j+1 , arr[i] , arr[j]));
                }
            }
            return maxi ; 
        }
        public int solve(int[] arr , int idx ,  int prev2 , int prev1){
            if(idx == arr.length){
                return 0 ; 
            }
    
            int ans = 0 ; 
            int maxi = 0 ; 
    
            for(int i = idx ; i < arr.length ; i++){
                if(prev1 + prev2 == arr[i]){
                    maxi = Math.max(maxi , 1 + solve(arr , i+1 , prev1 , arr[i]));
                }
            }
    
            return maxi ; 
        }
    }
}
