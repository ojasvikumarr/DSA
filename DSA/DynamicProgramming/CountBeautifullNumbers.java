package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class CountBeautifullNumbers {
    public class Solution {
    public int beautifulNumbers(int l, int r) {
        long countR = count(r);
        long countL = count(l - 1);
        return (int)(countR - countL);
    }
    
    private long count(int x) {
        if (x < 1) return 0;
        String s = Integer.toString(x);
        int n = s.length();
        int[] digits = new int[n];
        for (int i = 0; i < n; i++) {
            digits[i] = s.charAt(i) - '0';
        }
        Map<String, Long> memo = new HashMap<>();
        return dp(0, true, false, false, 0, 1, digits, n, memo);
    }
    
    private long dp(int pos, boolean tight, boolean started, boolean hasZero, int sum, int prod, int[] digits, int n, Map<String, Long> memo) {
        if (pos == n) {
            if (!started) return 0;
            if (hasZero) return 1;
            return (prod % sum == 0) ? 1 : 0;
        }
        
        String key = pos + "_" + (tight ? 1 : 0) + "_" + (started ? 1 : 0) + "_" + (hasZero ? 1 : 0) + "_" + sum + "_" + prod;
        if (memo.containsKey(key)) return memo.get(key);
        
        long ans = 0;
        int limit = tight ? digits[pos] : 9;
        
        if (started && hasZero && !tight) {
            long ways = (long) Math.pow(10, n - pos);
            memo.put(key, ways);
            return ways;
        }
        
        for (int d = 0; d <= limit; d++) {
            boolean newTight = tight && (d == limit);
            if (!started) {
                if (d == 0) {
                    ans += dp(pos + 1, newTight, false, false, 0, 1, digits, n, memo);
                } else {
                    ans += dp(pos + 1, newTight, true, false, d, d, digits, n, memo);
                }
            } else {
                if (hasZero) {
                    ans += dp(pos + 1, newTight, true, true, sum + d, 0, digits, n, memo);
                } else {
                    if (d == 0) {
                        ans += dp(pos + 1, newTight, true, true, sum, 0, digits, n, memo);
                    } else {
                        ans += dp(pos + 1, newTight, true, false, sum + d, prod * d, digits, n, memo);
                    }
                }
            }
        }
        
        memo.put(key, ans);
        return ans;
    }
}
}
