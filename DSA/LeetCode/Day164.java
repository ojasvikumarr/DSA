package LeetCode;

import java.util.Arrays;

public class Day164 {
    class Solution {
    public boolean divideArray(int[] nums) {
        Arrays.sort(nums);
        int i = 1 ; 
        int n = nums.length ;
        while(i < n){
            if(nums[i] == nums[i-1]){
                i += 2 ;
            }else{
                return false ;
            }
        }
        return true ; 
    }
}
}
