package Graphs;

import java.util.Arrays;

public class SuperUglyNumb {
    class Solution {
    public int nthSuperUglyNumber(int n, int[] primes) {
        int[] pointers = new int[primes.length];
        Arrays.fill(pointers , 1);
        long[] dp = new long[n+1];
        dp[1] = 1 ;
        for(int i = 2 ; i <= n ; i++){
            long mini = Integer.MAX_VALUE ;
            for(int j = 0 ; j < primes.length ; j++){
                mini = Math.min(mini , primes[j]*dp[pointers[j]]);
            }
            dp[i] = mini ;
            for(int j = 0 ; j < primes.length ; j++){
                if(primes[j]*dp[pointers[j]] == mini) pointers[j]++ ;
            }
        }
        return (int)dp[n];
    }

}
}
