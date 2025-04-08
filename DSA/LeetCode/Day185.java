package LeetCode;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day185 {
    class Solution {
    public int minimumOperations(int[] nums) {
        Map<Integer , Integer> map = new HashMap<>();
        int n = nums.length ; 
        int freq = 0 ; 
        Set<Integer> set = new HashSet<>();
        for(int i = 0 ; i < n ; i++){
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
            if(map.get(nums[i]) > 1){
                set.add(nums[i]);
            }
        }
        freq = set.size();
        int op = 0; 
        System.out.println(freq);
        if(freq == 0) return op ; 
        for(int i = 0 ; i < n ; i += 3){
            for(int j = 0 ; j < 3 && i+j < n ; j++){
                int f = map.get(nums[i+j]) - 1;
                // System.out.println(f);
                if( f == 0 ){
                    map.remove(nums[i+j]);
                }else if(f == 1){
                    freq-- ; 
                    map.put(nums[i+j] , f);
                }else{
                    map.put(nums[i+j] , f);
                }
            }
            op++ ; 
            if(freq == 0){
                break ; 
            }
        }
        return op ; 
    }
}
}
