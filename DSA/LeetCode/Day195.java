package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class Day195 {
    class Solution {
    public long calculateScore(String[] str, int[] values) {
        long score = 0 ; 
        Set<Integer> set = new HashSet<>();
        int i = 0 ; 
        while(i < str.length && i >= 0){
                if(set.contains(i)) break ;
            String s = str[i] ;
            set.add(i);
            if(s.equals("jump")){
                i += values[i];
            }else{
                score += values[i];
                i++ ;
            }
            // System.out.println(i + " -- " + score);
        }
        return score ;
    }
}
class SolutionI {
    public int maximumPossibleSize(int[] nums) {
        int n = nums.length ; 
        int[] sorted = Arrays.copyOf(nums , n);
        Arrays.sort(sorted);
        int i = n-1 ; 
        int j = n-1 ; 
        int len = 0 ; 

        Map<Integer , Integer> map = new HashMap<>();
        while(i >= 0 && j >= 0){
            while(i >= 0 && nums[i] != sorted[j]){
                // set.add(nums[i]);
                map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
                i-- ;
            }
            // set.add(nums[i]);
            map.put(nums[i] , map.getOrDefault(nums[i] , 0)+1);
            len++ ; 
            i-- ;
            while(j >= 0 && map.getOrDefault(sorted[j] , 0) > 0){
                map.put(sorted[j] , map.get(sorted[j])-1);
                j-- ;
            }
        }
        return len ; 
    }
    public int maximumPossibleSizeII(int[] nums) {
        int n = nums.length ; 
        int[] dp = new int[n];
        Arrays.fill(dp , 1);
        int maxi = 1 ; 
        for(int i = 1 ; i < n ; i++){
            for(int j = i-1 ; j >= 0 ; j--){
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i] , dp[j] + 1);
                }
            }
            maxi = Math.max(maxi , dp[i]);
        }
        return maxi ; 
    }
}
}
