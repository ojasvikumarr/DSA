class Solution {
    public int helper(int[] nums){
        int rob = 0 ;
        int noRob = 0 ;
        for(int i =0 ; i < nums.length ; i++){
            int n
        }
    }
    public int rob(int[] nums) {
        if(nums.length == 1){
            return nums[0];
        }
        int []First = new int[nums.length-1];
        int []Last = new int[nums.length-1];
        for(int i = 0 ; i < nums.length ; i++){
            if(i != nums.length-1){
                First[i] = nums[i];
            }
            if(i != 0){
                Last[i-1] = nums[i];
            }
        }
        return Math.max(helper(First) , helper(Last));
    }
}