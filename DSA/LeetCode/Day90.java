public class Day90 {
    class Solution {
        public int waysToSplitArray(int[] nums) {
            long leftSum = 0, rightSum = 0;
            for (int num : nums) {
                rightSum += num;
            }
    
            int count = 0;
            for (int i = 0; i < nums.length - 1; i++) {
                leftSum += nums[i];
                rightSum -= nums[i];
                if (leftSum >= rightSum) {
                    count++;
                }
            }
    
            return count;
        }
        public int waysToSplitArrayII(int[] nums) {
            int n = nums.length ;
            int[] prefSum = new int[n];
            int[] suffSum = new int[n];
            prefSum[0] = nums[0];
            suffSum[n-1] = nums[n-1];
            for(int i = 1 ; i < n ; i++){
                prefSum[i] = prefSum[i-1] + nums[i];
                suffSum[n-i-1] = suffSum[n-i] + nums[n-i-1];
            }
            int counter = 0 ; 
            for(int i = 0 ; i < n-1 ; i++){
                if(prefSum[i] >= suffSum[i+1]) counter++ ;
            }
            return counter ;
        }
    }
}
