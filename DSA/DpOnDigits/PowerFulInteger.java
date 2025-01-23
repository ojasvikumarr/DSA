package DpOnDigits;

import java.util.Arrays;

public class PowerFulInteger {
    class Solution {

    long[][] dp = new long[17][2];

    public long digitDP(int ind, boolean isSmaller, String finish, String s, int n, int limit) {
        if (ind == n - s.length()) {
            return isSmaller ? 1 : (finish.substring(n - s.length()).compareTo(s) >= 0 ? 1 : 0);
        }
        int flag = isSmaller ? 1 : 0;
        if (dp[ind][flag] != -1) {
            return dp[ind][flag];
        }
        long count = 0;
        int x = finish.charAt(ind) - '0';
        int maxLimit = isSmaller ? limit : Math.min(x, limit);

        for (int i = 0; i <= maxLimit; i++) {
            count += digitDP(ind + 1, isSmaller || (i < x), finish, s, n, limit);
        }

        return dp[ind][flag] = count;
    }

    public long numberOfPowerfulInt(long start, long finish, int limit, String s) {
        String g = String.valueOf(--start);
        String f = String.valueOf(finish);

        int sSize = s.length();
        int gSize = g.length();
        int fSize = f.length();

        long count1 = 0, count2 = 0;

        // Initialize dp array
        for (long[] row : dp) {
            Arrays.fill(row, -1);
        }

        if (gSize >= sSize) {
            count1 = digitDP(0, false, g, s, gSize, limit);
        }

        if (fSize >= sSize) {
            for (long[] row : dp) {
                Arrays.fill(row, -1);
            }
            count2 = digitDP(0, false, f, s, fSize, limit);
        }

        return count2 - count1;
    }
}
}
