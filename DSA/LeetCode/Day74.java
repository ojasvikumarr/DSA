import java.util.*;

public class Day74 {
    class Solution {
        public long continuousSubarraysI(int[] nums) {
            int min = Integer.MAX_VALUE ; 
            int max = Integer.MIN_VALUE ;
            int n = nums.length ;  
            int l = 0 ; 
            int count = 0 ; 
            for(int r = 0 ; r < n ; r++){
                min = Math.min(min , nums[r]);
                max = Math.max(max , nums[r]);
                while(Math.abs(min - max) > 2 && l < n){
                    if(nums[l] == min){
                        for(int i = l+1 ; i <= r ; i++) min = Math.min(min , nums[i]);
                    }else if(nums[l] == max){
                        for(int i = l+1 ; i <= r ; i++) max = Math.max(max , nums[i]);
                    }
                    l++ ; 
                }
                count += r-l+1 ;
            }
            return count ;
        }
        // public long continuousSubarrays(int[] nums) {
        //     // TreeMap to maintain sorted frequency map of current window
        //     TreeMap<Integer, Integer> freq = new TreeMap<>();
        //     int left = 0, right = 0;
        //     int n = nums.length;
        //     long count = 0; // Total count of valid subarrays
    
        //     while (right < n) {
        //         // Add current element to frequency map
        //         freq.put(nums[right], freq.getOrDefault(nums[right], 0) + 1);
    
        //         // While window violates the condition |nums[i] - nums[j]| ≤ 2
        //         // Shrink window from left
        //         while (freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2) {
        //             // Remove leftmost element from frequency map
        //             freq.put(nums[left], freq.get(nums[left]) - 1);
        //             if (freq.get(nums[left]) == 0) {
        //                 freq.remove(nums[left]);
        //             }
        //             left++;
        //         }
    
        //         // Add count of all valid subarrays ending at right
        //         count += right - left + 1;
        //         right++;
        //     }
    
        //     return count;
        // }
        public long continuousSubarrays(int[] nums) {
            TreeMap<Integer , Integer> freq = new TreeMap<>();
            int l = 0 ; 
            int n = nums.length ;
            long count = 0 ; 
            for(int r = 0 ; r < n ; r++ ){
                freq.put(nums[r] , freq.getOrDefault(nums[r] , 0)+1);
                while(freq.lastEntry().getKey() - freq.firstEntry().getKey() > 2){
                    freq.put(nums[l] , freq.get(nums[l])-1);
                    if(freq.get(nums[l]) == 0) freq.remove(nums[l]);
                    l++ ;
                }
                count += r-l +1 ;
            }
            return count ;
        }
    }
}
