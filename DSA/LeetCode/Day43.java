import java.util.Deque;
import java.util.LinkedList ;
public class Day43 {
    class Solution {
    public int shortestSubarrayX(int[] nums, int k) {
        int ans = (int)10e9 ; 
        int n = nums.length ; 
        int sum = 0 ; 
        int l = 0 ; 
        for(int r = 0 ; r < n ; r++){
            sum += nums[r];
            while(sum >= k){
            ans = Math.min(ans , r-l+1);
                sum -= nums[l];
                l++ ;
            }
        }
        return ans == (int)10e9 ? -1 : ans;

    }
    public int shortestSubarray(int[] nums, int k) {
        int n = nums.length;
        long[] prefixSum = new long[n + 1];
        for (int i = 0; i < n; i++) {
            prefixSum[i + 1] = prefixSum[i] + nums[i];
        }

        Deque<Integer> deque = new LinkedList<>();
        int ans = n + 1;
        
        for (int i = 0; i <= n; i++) {
            while (!deque.isEmpty() && prefixSum[i] - prefixSum[deque.peekFirst()] >= k) {
                ans = Math.min(ans, i - deque.pollFirst());
            }
            while (!deque.isEmpty() && prefixSum[i] <= prefixSum[deque.peekLast()]) {
                deque.pollLast();
            }
            deque.offerLast(i);
        }
        return ans == n + 1 ? -1 : ans;
    }

}
}
