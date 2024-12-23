package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class Number {
    class Solution {
    int[] dp ;
    Map<Long , Integer> map ;
    public int integerReplacement(int n) {
        map = new HashMap<>();
        // Arrays.fill(dp , -1);
        return solve(n);
    }
    public int solve(long n){
        if(n == 1) return 0 ;
        if(map.containsKey(n)) return map.get(n);
        int result = 0 ;
        // int mini = Integer.MAX_VALUE ;
        if(n % 2== 0){
            long x = n/2 ;
            result = 1 + solve(x);
        }else{
            result = 1 + Math.min(solve(n+1) ,solve(n-1));
        };
        map.put(n , result);
        return map.get(n);
    }
}
}
