import java.util.PriorityQueue;

public class Day76 {
    class Solution {
    public int[] getFinalState(int[] nums, int k, int multiplier) {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        int n = nums.length ; 
        for(Integer num : nums) pq.offer(num);
        while(k > 0){
            int top = pq.poll();
            for(int i = 0 ; i < n ; i++){
                if(top == nums[i]){
                    nums[i] = nums[i] * multiplier ; 
                    pq.offer(nums[i]);
                    break ;
                }
            }
            k-- ;
        }
        return nums ;
    }
}
}
