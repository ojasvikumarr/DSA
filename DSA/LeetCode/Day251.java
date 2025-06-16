public class Day251{
    class Solution {
    public int maximumDifference(int[] nums) {
        int maxi = -1 ; 
        int n = nums.length ;
        int[] suffMax = new int[n];
        suffMax[n-1] = nums[n-1];
        for(int i = n-2 ; i >= 0 ; i--){
            suffMax[i] = Math.max(nums[i] , suffMax[i+1]);
        }
        for(int i = 0 ; i < n-1 ; i++){
            if(nums[i] < suffMax[i+1]){
                maxi = Math.max(maxi , suffMax[i+1] - nums[i]);
            }
        }
        return maxi ; 
    }
}
}