class Solution {
    public int longestSubarray(int[] nums) {
        int max = Integer.MIN_VALUE ;
        for(Integer it : nums){
            max = Math.max(max , it);
        }
        int maxi = 0 ;
        int size = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] == max){
                size++ ;
            }else{
                size = 0 ; 
            }
            maxi = Math.max(maxi , size);

        }
        return maxi ;
    }
}