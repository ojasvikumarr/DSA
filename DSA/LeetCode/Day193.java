package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day193 {
    class Solution {
    public long countGood(int[] nums, int k) {
        Map<Integer , Integer> map = new HashMap<>();
        int cnt = 0 ; 
        long res = 0 ; 
        int l = 0 ; 
        int r = 0 ; 
        int n = nums.length ;
        while(r < n){
            int freq = map.getOrDefault(nums[r] , 0);
            map.put(nums[r] , freq+1);
            cnt += freq ; 
            if(cnt >= k){
                res += n-r ; 
            // System.out.print(res);
                // we will incr l 
                while(cnt >= k){
                    freq = map.get(nums[l]);
                    cnt -= freq-1 ;
                    map.put(nums[l] , freq-1);
                    if(cnt >= k){
                        // System.out.println(res);
                        res += n-r ;
                    }
                    l++ ;
                }
            }
            r++ ;
        }
        return res ;
    }

}
}
