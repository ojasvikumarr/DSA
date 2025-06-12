public class Day249{
    class Solution {
    public int maxAdjacentDistance(int[] nums) {
        int maxi = 0 ; 
        int n = nums.length ;
        for(int i = 0 ; i < n-1 ; i++){
            maxi = Math.max(maxi , Math.abs(nums[i] - nums[i+1]));
        }
        maxi = Math.max(maxi , Math.abs(nums[0] - nums[n-1]));
        return maxi ; 
    }
}
}