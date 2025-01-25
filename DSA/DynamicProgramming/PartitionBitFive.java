package DynamicProgramming;

import java.util.Arrays;

public class PartitionBitFive {
    class Solution {
    int[][] dp ;
    public int minimumBeautifulSubstringsIIIIII(String s) {
        int n = s.length();
        int[] memo = new int[n + 1];
        Arrays.fill(memo, Integer.MAX_VALUE / 2); // Initialize with a large value
        memo[n] = 0; // Base case: no splits needed beyond the end of the string

        for (int i = n - 1; i >= 0; i--) {
            for (int j = i; j < n; j++) {
                if (checkFive(s.substring(i, j + 1))) {
                    memo[i] = Math.min(memo[i], memo[j + 1] + 1);
                }
            }
        }

        return memo[0] == Integer.MAX_VALUE / 2 ? -1 : memo[0];
    }
        public int minimumBeautifulSubstrings(String s) {
        int n = s.length(), dp[] = new int[n + 1];
        Arrays.fill(dp, n + 1);
        dp[0] = 0;
        for (int i = 0; i < n; i++) {
            if (s.charAt(i) == '0') continue;
            for (int j = i, cur = 0; j < n; j++) {
                cur = cur * 2 + s.charAt(j) - '0';
                if (15625 % cur == 0)
                    dp[j + 1] = Math.min(dp[j + 1], dp[i] + 1);
            }
        }
        return dp[n] > n ? -1 : dp[n];
    }
    public int minimumBeautifulSubstringsIIII(String s) {
        int n = s.length();
        int[] tab = new int[n+1];
        Arrays.fill(tab , Integer.MAX_VALUE/2);
        tab[0] = 0 ; 

        for(int i = 1 ; i <= n ; i++){
            if(i < n && s.charAt(i) == '0') continue ;
            for(int j = n-1 ; j >= 0 ; j--){
                if(checkFive(s.substring(i , j))){
                    tab[i] = Math.min(tab[i] ,( tab[j] + 1));
                }
            }
        }
        return tab[n] == Integer.MAX_VALUE /2 ? -1 : tab[n];
    }
    public boolean checkFive(String str) {
        if (str == null || str.isEmpty() || str.charAt(0) == '0') return false;
        int sum = 0;
        int two = 1;

        for (int i = str.length() - 1; i >= 0; i--) {
            if (str.charAt(i) == '1') {
                sum += two;
                if (sum > 1_000_000) break; // Stop early for large sums.
            }
            two *= 2;
            if (two > 1_000_000) break; // Prevent overflow.
        }

        return sum == 1 || (sum % 5 == 0 && sum != 0);
    }
    public int minimumBeautifulSubstringsII(String s) {
        int n = s.length();
        // System.out.println(checkFive("1001110001"));
        // System.out.println(checkFive("1"));

        dp = new int[n+1][n+1];
        for(int[] row : dp) Arrays.fill(row , -1);

        int result = solve(s , n-1 , n)  ;
        return result == Integer.MAX_VALUE/2 ? -1 : result ;
    }
    public int solve(String s , int idx , int prev){
        if(idx < 0){
            if(checkFive(s.substring(0 , prev))){
                return 1 ;
            }
            return Integer.MAX_VALUE/2 ;
        }
        if(dp[idx][prev] != -1) return dp[idx][prev] ;
        //pick 
        int pick = Integer.MAX_VALUE ;
        if(checkFive(s.substring(idx , prev))){
            pick = 1 + solve(s , idx-1 , idx);
        }
        //notpick
        int notpick = solve(s , idx-1 , prev);

        return dp[idx][prev] = Math.min(pick , notpick);
    }
    public boolean checkFiveI(String str){
        if(str == null || str.isEmpty() || str.charAt(0) == '0') return false ;
        int sum = 0 ; 
        int n = str.length();
        int two = 1 ; 
        for(int i = n-1 ; i >= 0 ; i--){
            if(str.charAt(i) == '1'){
                sum += two;
            }
            two *= 2 ;
        }
        return (sum == 1 || sum % 5 == 0) && sum != 0;
        // return (15625 % sum == 0 || sum == 1 ) && sum != 0; 
        // return 15625 % sum == 0 ; 
    }
}
}
