package LeetCode;

import java.util.Arrays;

public class Day166 {
    class Solution {
    public int minOperations(int[] nums) {
        //silding window is the approach ill be using here 
        //ill have a window of size 3 that will flip the bits inside it if the 
        //first character of the silding window is 0 
        //if it is 1 then sliding window moves one step ahead w/o flipping 
        int l = 0 ; 
        int operations = 0; 
        int n = nums.length ;
        if(Arrays.stream(nums).allMatch(x -> x == 1)) return 0 ; 
        while(l < n-2){
            if(nums[l] == 0){
                //flip the bits 
                for(int i = 0 ; i < 3 ; i++){
                    nums[l+i] ^= 1 ;
                }
                operations++ ; 
                while(l < n &&nums[l] == 1) l++ ; 
                if(l == n) return operations ; 
            }else{
                l++;
            }
        }
        for(int i = 0 ; i < 3 ; i++){
            if(nums[l+i] != 1) return -1 ;    
        }
        return operations ; 
    }
}
}
