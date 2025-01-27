package GreedyAlgorithms;
public class EvenPartitions {
    class Solution {
        public int countPartitions(int[] nums) {
            int n = nums.length ; 
            int[] preSum = new int[n];
            int[] sufSum = new int[n];
            preSum[0] = nums[0];
            sufSum[n-1] = nums[n-1];
            for(int i = 1 ; i < n ; i++){
                preSum[i] = preSum[i-1] + nums[i];
                sufSum[n-i-1] = sufSum[n-i] + nums[n-i-1];
            }
    
            int count = 0 ; 
            for(int i = 0 ; i < n-1 ; i++){
                if(Math.abs(preSum[i] - sufSum[i+1]) %2 == 0) count++ ;
            }
            return count ; 
        }
    }
}
