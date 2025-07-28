class Solution {
    public int countMaxOrSubsets(int[] nums) {
        int maxOr = 0 ;
        for(Integer it : nums) maxOr = maxOr | it ;
        return helper(nums , 0 , maxOr , 0);
    }
    public int helper(int[] nums , int idx , int target , int whatwegot){
        if(idx >= nums.length){
            if(whatwegot == target){
                return 1;
            }else{
                return 0 ;
            }
        }
        int pick = helper(nums , idx+1 , target , whatwegot | nums[idx]);
        int notPick = helper(nums , idx+1 , target , whatwegot);
        return pick + notPick;
    }
}