package DynamicProgramming;

import java.util.Arrays;

public class DecodeWaysII {
    class Solution {
    long[] dp;

    public int numDecodings(String s) {
        dp = new long[s.length() + 1];
        Arrays.fill(dp, -1);
        return (int)solve(s, 0);
    }

    public long solve(String s, int idx) {
        if (idx >= s.length()) {
            return 1;
        }
        if (dp[idx] != -1) return dp[idx];

        int mod = 1000000007;

        // Pick one
        long pickone = 0;
        if (s.charAt(idx) == '*') {
            pickone = (9 * solve(s, idx + 1)) % mod;
        } else if (s.charAt(idx) != '0') {
            pickone = solve(s, idx + 1);
        }

        // Pick two
        long picktwo = 0;
        if (idx + 1 < s.length()) {
            if (s.charAt(idx) == '*') {
                if (s.charAt(idx + 1) == '*') {
                    picktwo = (15 * solve(s, idx + 2)) % mod;
                } else {
                    int nextDigit = Character.getNumericValue(s.charAt(idx + 1));
                    if (nextDigit <= 6) {
                        picktwo = (2 * solve(s, idx + 2)) % mod;
                    } else {
                        picktwo = solve(s, idx + 2);
                    }
                }
            } else if (s.charAt(idx + 1) == '*') {
                if (s.charAt(idx) == '1') {
                    picktwo = (9 * solve(s, idx + 2)) % mod;
                } else if (s.charAt(idx) == '2') {
                    picktwo = (6 * solve(s, idx + 2)) % mod;
                }
            } else {
                int num = Integer.parseInt(s.substring(idx, idx + 2));
                if (num >= 10 && num <= 26) {
                    picktwo = solve(s, idx + 2);
                }
            }
        }

        return dp[idx] = (pickone + picktwo) % mod;
    }

    int M = 1000000007;
    public int numDecodingsII(String s) {
        Long[] memo = new Long[s.length()];
        return (int) ways(s, s.length() - 1, memo);
    }
    public long ways(String s, int i, Long[] memo) {
        if (i < 0)
            return 1;
        if (memo[i] != null)
            return memo[i];
        if (s.charAt(i) == '*') {
            long res = 9 * ways(s, i - 1, memo) % M;
            if (i > 0 && s.charAt(i - 1) == '1')
                res = (res + 9 * ways(s, i - 2, memo)) % M;
            else if (i > 0 && s.charAt(i - 1) == '2')
                res = (res + 6 * ways(s, i - 2, memo)) % M;
            else if (i > 0 && s.charAt(i - 1) == '*')
                res = (res + 15 * ways(s, i - 2, memo)) % M;
            memo[i] = res;
            return memo[i];
        }
        long res = s.charAt(i) != '0' ? ways(s, i - 1, memo) : 0;
        if (i > 0 && s.charAt(i - 1) == '1')
            res = (res + ways(s, i - 2, memo)) % M;
        else if (i > 0 && s.charAt(i - 1) == '2' && s.charAt(i) <= '6')
            res = (res + ways(s, i - 2, memo)) % M;
        else if (i > 0 && s.charAt(i - 1) == '*')
            res = (res + (s.charAt(i) <= '6' ? 2 : 1) * ways(s, i - 2, memo)) % M;
        memo[i] = res;
        return memo[i];
    }
}
}
