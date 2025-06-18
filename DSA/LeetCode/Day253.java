public class Day253{
    class Solution {
    public int nthUglyNumber(int n) {
        PriorityQueue<Long> pq = new PriorityQueue<>();
        long[] dp = new long[n+1];
        dp[1] = 1 ;
        long[] nums = {2 , 3 , 5};
        for(int i = 2 ; i <= n ; i++){
            for(long fac : nums){
                pq.add(fac*(dp[i-1]));
            }
            dp[i] = pq.poll();
            // System.out.print(dp[i] + " " );
            while(!pq.isEmpty() && pq.peek() == dp[i]) pq.poll();
        }
        
        return (int)dp[n];
    }
}
class SolutionII {
    public int numSquares(int n) {
        int[] dp = new int[n+1];
        // dp[i] = minimum no. of perfect sqs req to make a sum of i 
        Arrays.fill(dp , (int)1e8);
        dp[0] = 0 ;
        for(int i = 1 ; i <= n ; i++){
            //for every i we wil be checking previous perfect sqs AVAILABLE!!
            for(int prev = 1 ; prev*prev <= i ; prev++){
                dp[i] = Math.min(dp[i] , 1 + dp[i-prev*prev]);
            }
        }
        return dp[n];
    }
    Map<String , Integer> map ;
    public int solveI(int n){
        if(n == 0){
            return 0 ;
        }
        if(dp[n] != -1) return dp[n];
        int res = (int)1e8 ;
        for(int i = 1 ; i*i <= n ; i++){
            res = Math.min(res , 1 + solveI(n-i*i));
        }
        return dp[n] = res ;

    }
    int[] dp ;
    public int solve(int n , int idx){
        if(n == 0){
            return 0 ; 
        }
        if(idx <= 0){
            return (int)1e8 ; 
        }

        String key = n + " " + idx;
        if(map.containsKey(key)){
            return map.get(key);
        }
        // if(dp[n][idx] != -1){
        //     return dp[n][idx];
        // }

        int pick = (int)1e8  ; 
        if(perf(idx) && n >= idx){
            pick = 1 + solve( n-idx , idx);
        }
        int notpick = 0 + solve(n , idx-1);
        map.put(key , Math.min(pick , notpick));
        return map.get(key);
    }
    public boolean perf(int x){
        int sqrt = (int)Math.sqrt(x);
        return x == sqrt*sqrt ;
    }
}
}