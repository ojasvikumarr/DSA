package LeetCode;

import java.util.PriorityQueue;

public class Day129 {
    class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>() ; 
        for(Integer it : nums){
             pq.offer(it);

        }

        int count = 0 ; 
        while(pq.peek() < k){
            int top = pq.poll();
            int secTop = pq.poll();
            // int val = top*2 + secTop ;
            if(top > (Integer.MAX_VALUE - secTop)/2){
                pq.offer(k);
            }else{
                pq.offer(top*2 + secTop);
            }
            count++ ; 
        }
        return count ; 
    }
    public int minOperationsII(int[] nums, int k) {
        PriorityQueue<Long> pq = new PriorityQueue<>() ; 
        for(Integer it : nums){
             pq.offer((long)it);

        }

        int count = 0 ; 
        while(pq.peek() < k){
            long top = pq.poll();
            long secTop = pq.poll();
            pq.offer(top*2 + secTop);
            count++ ; 
            // System.out.println(top + " " + secTop + " " + pq.peek());
        }
        return count ; 
    }
}
}
