public class Day255{
    class Solution {
    public int partitionArray(int[] nums, int k) {
        Arrays.sort(nums);
        int border = 0 ; 
        int prev = 0 ; 
        int n = nums.length ;
        int i = 0; 
        while(i < n){
            while(i < n && nums[i] - nums[prev] <= k) i++ ; 
            prev = i ; 
            border++ ; 
        }
        return (border) ; 
    }
}
}