package LeetCode;

public class Day145 {
    class Solution {
        public int[] applyOperations(int[] nums) {
            int n = nums.length ; 
            int[] result = new int[n];
            int idx = 0 ; 
            for(int i = 0 ; i < n-1 ; i++){
                if(nums[i] == nums[i+1]){
                    nums[i] *= 2; 
                    nums[i+1] = 0 ; 
                }
                if(nums[i] != 0 ) result[idx++] = nums[i];
            }
            if(nums[n-1] != 0) result[idx++] = nums[n-1];
            System.out.println("Helli");
            System.out.println("Helli");
            System.out.println("Helli");
            System.out.println("Helli");
            return result; 
        }
    }
}
