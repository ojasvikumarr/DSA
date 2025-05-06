package LeetCode;

public class Day211 {
    class Solution {
        public int[] buildArray(int[] nums) {
            int n = nums.length ; 
            for(int i = 0 ; i < n ; i++){
                int ele = nums[nums[i]]%1000;
                nums[i] += (ele*1000); 
                // System.out.println(nums[i]);
            }
            for(int i = 0 ; i < n ; i++){
                nums[i] = nums[i]/1000 ;
            }
            return nums ; 
        }
        public int[] buildArrayII(int[] nums) {
            int n = nums.length ; 
            int[] ans = new int[n];
            for(int i = 0 ; i < n ; i++){
                ans[i] = nums[nums[i]];
            }
            return ans ;
        }
    
    }
}
