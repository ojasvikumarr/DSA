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
}