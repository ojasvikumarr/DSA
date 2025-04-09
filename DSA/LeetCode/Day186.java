package LeetCode;

import java.util.HashSet;
import java.util.Set;

public class Day186 {
    class Solution {
    public int minOperations(int[] nums, int k) {
        boolean flag = false ; 
        int n = nums.length ;
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            if(nums[i] == k) flag = true ; 
            set.add(nums[i]);
            if(nums[i] < k) return -1 ; 
        }   
        return set.size() - (flag ? 1 : 0);
    }
}
}
