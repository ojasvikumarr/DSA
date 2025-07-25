class Solution {
    public int maxSum(int[] nums) {
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] > 0){
                set.add(nums[i]);
            }
        }
        int sum = 0 ; 
        for(Integer it : set) sum += it ; 
        if(set.size() == 0){
            //that all are negative 
            int maxi = Integer.MIN_VALUE ; 
            for(Integer it : nums){
                maxi = Math.max(maxi ,it);
            }
            return maxi ; 
        }
        return sum ; 
    }
}