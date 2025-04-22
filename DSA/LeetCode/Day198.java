package LeetCode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Day198 {
    class Solution {
    static int MOD = 1000000007;
    static int MAX_N = 10010;
    static int MAX_P = 15; // There are up to 15 prime factors
    static int[][] c = new int[MAX_N + MAX_P][MAX_P + 1];
    static int[] sieve = new int[MAX_N]; // Minimum prime factor
    static List<Integer>[] ps = new List[MAX_N]; // List of prime factor counts

    public Solution() {
        if (c[0][0] == 1) {
            return;
        }

        for (int i = 0; i < MAX_N; i++) {
            ps[i] = new ArrayList<>();
        }

        for (int i = 2; i < MAX_N; i++) {
            if (sieve[i] == 0) {
                for (int j = i; j < MAX_N; j += i) {
                    if (sieve[j] == 0) {
                        sieve[j] = i;
                    }
                }
            }
        }

        for (int i = 2; i < MAX_N; i++) {
            int x = i;
            while (x > 1) {
                int p = sieve[x], cnt = 0;
                while (x % p == 0) {
                    x /= p;
                    cnt++;
                }
                ps[i].add(cnt);
            }
        }

        c[0][0] = 1;
        for (int i = 1; i < MAX_N + MAX_P; i++) {
            c[i][0] = 1;
            for (int j = 1; j <= Math.min(i, MAX_P); j++) {
                c[i][j] = (c[i - 1][j] + c[i - 1][j - 1]) % MOD;
            }
        }
    }

    public int idealArrays(int n, int maxValue) {
        long ans = 0;
        for (int x = 1; x <= maxValue; x++) {
            long mul = 1;
            for (int p : ps[x]) {
                mul = (mul * c[n + p - 1][p]) % MOD;
            }
            ans = (ans + mul) % MOD;
        }
        return (int) ans;
    }
    int[][] dp ; 
    // int MOD = (int)1e9 + 7 ; 
    public int idealArraysII(int n, int maxValue) {
        dp = new int[n+1][maxValue+2] ; 
        for(int[] row : dp) Arrays.fill(row , -1);
        return solve(n , 0 , maxValue , maxValue+1);
    }
    public int solve(int n , int idx , int maxVal , int prev ){
        if(idx == n){
            //reached the end 
            // System.out.println(ls);
            return 1 ; 
        }
        if(dp[idx][prev] != -1){
            return dp[idx][prev];
        }
        int ans = 0 ; 
        for(int i = 1 ; i <= maxVal ; i++){
            if( prev == maxVal+1 || i % prev == 0){
                // ls.add(i);
                ans = (ans + solve(n , idx+1 , maxVal , i )%MOD)%MOD;
                // ls.remove(ls.size()-1);
            }
        }
        return dp[idx][prev] = ans ; 
    }
}
}
