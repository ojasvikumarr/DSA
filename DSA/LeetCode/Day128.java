package LeetCode ; 

import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class Day128 {
    class SolutionII {
    public int maximumSum(int[] nums) {
        Map<Integer ,Integer> map = new HashMap<>();
        int n = nums.length ;
        int maxi = -1 ; 
        for(int i = 0 ; i < n ; i++ ){
            int sumOfDigit = sumDigits(nums[i]);
            if(map.containsKey(sumOfDigit)){
                maxi = Math.max(maxi ,( nums[i] + map.get(sumOfDigit)));
            }
            // map.putIfAbsent(sumOfDigit , new PriorityQueue<>((a , b) -> b - a)) ; 
            if(map.containsKey(sumOfDigit)){
                if( map.get(sumOfDigit) < nums[i])
                    map.put(sumOfDigit , nums[i]);
            }else{
                map.put(sumOfDigit , nums[i]);
            }
        }
        return maxi ; 
    }
    public int sumDigits(int n){
        int sum = 0 ; 
        while( n > 0 ){
            int digit = n%10 ; 
            sum += digit ; 
            n /= 10 ; 
        }
        return sum ; 
    }
}
    class Solution {
        
        public int maximumSum(int[] nums) {
            Map<Integer , PriorityQueue<Integer>> map = new HashMap<>();
            int n = nums.length ;
            int maxi = -1 ; 
            for(int i = 0 ; i < n ; i++ ){
                int sumOfDigit = sumDigits(nums[i]);
                if(map.containsKey(sumOfDigit)){
                    maxi = Math.max(maxi ,( nums[i] + map.get(sumOfDigit).peek()));
                }
                map.putIfAbsent(sumOfDigit , new PriorityQueue<>((a , b) -> b - a)) ; 
                map.get(sumOfDigit).add(nums[i]);
            }
            return maxi ; 
        }
        public int sumDigits(int n){
            int sum = 0 ; 
            while( n > 0 ){
                int digit = n%10 ; 
                sum += digit ; 
                n /= 10 ; 
            }
            return sum ; 
        }
    }
}
