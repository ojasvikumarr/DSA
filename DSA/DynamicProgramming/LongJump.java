package DynamicProgramming;

import java.util.Arrays;

public class LongJump {
    class Solution {
    public boolean canJump(int[] nums) {
        if(nums.length == 1) return true ;
        int farthest = 0 ; 
        for(int i = 0 ; i < nums.length ; i++){
            if(farthest < i) return false ;
            farthest = Math.max(farthest , i + nums[i]);
            if(farthest >= nums.length-1) return true ;
        }
        return false ;
    }
    public boolean canJumpII(int[] nums) {
        int[] dp = new int[nums.length+1];
        Arrays.fill(dp , -1);
        return recur(0 , nums , dp);
    }
    public boolean recur(int idx , int[] nums , int[] dp){
        if(idx == nums.length-1){
            return true ;
        }else if(idx > nums.length-1){
            return false ;
        }else if(nums[idx] == 0){
            return false ;
        }else if(dp[idx] != -1){
            return dp[idx] == 1 ? true : false ;
        }
        boolean flag = false ;
        for(int i = idx+1 ; i <= nums[idx] + idx ; i++){
            flag |= recur(i , nums, dp);
        }
        dp[idx] = (flag ? 1 : 0);
        return flag ;
    }
}
}
