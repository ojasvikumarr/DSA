package LeetCode;

import java.util.HashMap;
import java.util.Map;

public class Day125 {
    class Solution {
    public long countBadPairs(int[] nums) {
        int n = nums.length ; 
        int newArr[] = new int[n];
        for(int i = 0 ; i < n; i++){
            newArr[i] = nums[i] - i ; 
        }
        //Now we use map 
        Map<Integer , Integer> map = new HashMap<>();
        long totalValidPair = 0 ; 
        for(int i = 0 ; i < n; i++){
            if(map.containsKey(newArr[i])){
                int freq = map.get(newArr[i]); 
                totalValidPair += freq ;
            }
            map.put(newArr[i] , map.getOrDefault(newArr[i] , 0)+1);
        }

        // System.out.print(totalValidPair + " " + (n*((long)n-1))/2 );
        return (n*((long)n-1))/2 - totalValidPair ; 
    }
}
}
