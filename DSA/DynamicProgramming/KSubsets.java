package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class KSubsets {
    class Solution {
    Map<String , Boolean> map ; 
    public boolean canPartitionKSubsets(int[] nums, int k) {
        int sum = 0 ; 
        map = new HashMap<>();
        for(Integer it : nums) sum += it ; 
        if(sum % k != 0) return false ; 
        int buckets = sum / k ; 
        int n = nums.length ; 
        // return solveII(nums , 0 , (1 << n)-1 , buckets , 0 , k);
        return solveII(nums, (1 << n) - 1, 0, buckets, k);
    }

    private boolean solveII(int[] nums, int mask, int currentSum, int target, int remainingBuckets) {
        if (remainingBuckets == 0) return true; // All buckets are filled successfully
        if (currentSum == target) { 
            // Start a new bucket
            return solveII(nums, mask, 0, target, remainingBuckets - 1);
        }
        if (map.containsKey(mask + " " + currentSum)) {
            return map.get(mask + " " + currentSum);
        }

        for (int i = 0; i < nums.length; i++) {
            if ((mask & (1 << i)) != 0) { // Check if nums[i] is not picked
                if (currentSum + nums[i] > target) break; // Prune if sum exceeds target

                // Pick nums[i]
                if (solveII(nums, mask ^ (1 << i), currentSum + nums[i], target, remainingBuckets)) {
                    map.put(mask + " " + currentSum, true);
                    return true;
                }
            }
        }
        map.put(mask + " " + currentSum, false);
        return false;
    }
    public boolean solve(int[] nums , int idx , int mask , int k , int sum , int bucket){
        if(bucket == 0){
            return true ;
        }
        if(sum == k && bucket > 0){
            return solve(nums , 0 , mask , k , 0 , bucket-1);
        }
        if(sum > k) return false ;
        if(idx == nums.length){
            return false ;
        }
        if( (mask & (1 << idx)) != 0){
            return solve(nums , idx + 1 , mask , k , sum , bucket);
        }

        String key = mask + " " + sum + " " + bucket ;
        if(map.containsKey(key)){
            return map.get(key);
        }
        //pick 
        sum += nums[idx];
        boolean pick = solve(nums , idx + 1 , (mask ^ (1<<idx)) , k , sum , bucket);

        //notPick 
        sum -= nums[idx];
        boolean notpick = solve(nums , idx + 1 , (mask ^ (1 << idx)) , k , sum , bucket);
        map.put(key , (pick || notpick));
        return map.get(key);
    }
}
}
