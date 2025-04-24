package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day200 {
    class Solution {
    public int countCompleteSubarrays(int[] nums) {
        int l = 0 ; 
        int r = 0 ; 
        int n = nums.length ; 
        Set<Integer> set = new HashSet<>();
        for(int ele : nums){
            set.add(ele);
        }
        int benchMark = set.size();
        Map<Integer , Integer> map = new HashMap<>();
        int res = 0 ; 
        while(r < n){
            map.put(nums[r] , map.getOrDefault(nums[r] , 0)+1);
                //we need to count 
                
                //we increment l 
                while(map.size() == benchMark){
                    res += n-r ;
                    int freq = map.get(nums[l]);
                    if(freq-1 == 0){
                        map.remove(nums[l]);
                    }else{
                        map.put(nums[l] , freq-1);
                    }
                    l++ ; 
                }
            r++ ;
        }
        return res ;
    }
}
}
