package DynamicProgramming;

import java.util.HashMap;
import java.util.Map;

public class IncredibleDP {
    class Solution {
    public int numberOfArithmeticSlices(int[] nums) {
        int n = nums.length ;
        if (nums.length < 3) return 0; // Less than 3 elements, no slices possible
        @SuppressWarnings("unchecked")
        Map<Long , Integer>[] map = new HashMap[n];
        int result = 0 ; 
        for(int i = 0 ; i < n ; i++){
            map[i] = new HashMap<>();
            for(int j = 0 ; j < i ; j++){
                long diff = (long)nums[i] - nums[j];
                int countAtJ = map[j].getOrDefault(diff , 0);
                map[i].put(diff , map[i].getOrDefault(diff , 0) + countAtJ + 1);
                result += countAtJ ;
            }
        }
        return result ;
    }

    // public int solve(int[] nums , int idx , int prev, int diff ,int length){
    //     if(idx == nums.length){

    //     }
    //     int pick = 0 ; 
    //     if(prev == -1){
    //         pick = solve(nums , idx+1 , nums[idx] , length+1 , length);
    //     }
    //     else if(prev - nums[idx] = diff){

    //     }
    // }
    // public int solveIII(int[] nums, int idx, int prevIdx, int diff, int[][][] dp) {
    //     if (idx == nums.length) return 0;
    //     if (prevIdx != -1 && dp[idx][prevIdx][diff + 1000] != -1)
    //         return dp[idx][prevIdx][diff + 1000];
        
    //     int pick = 0;
    //     if (prevIdx == -1 || nums[idx] - nums[prevIdx] == diff) {
    //         pick = (prevIdx != -1 && idx - prevIdx >= 2) ? 1 : 0; 
    //         pick += solve(nums, idx + 1, idx, nums[idx] - (prevIdx == -1 ? nums[idx] : nums[prevIdx]), dp);
    //     }
    //     int notPick = solve(nums, idx + 1, prevIdx, diff, dp);
    //     if (prevIdx != -1)
    //         dp[idx][prevIdx][diff + 1000] = pick + notPick; 
        
    //     return pick + notPick;
    // }
    // public int solveII(int[] nums, int idx , int diff , List<Integer> ls){
    //     if(idx == nums.length){
    //         return 0 ;
    //     }
    //     int pick = 0 ;
    //     for(int i = idx ; i < nums.length ; i++){
    //         if(diff == -1 ){
    //             ls.add(nums[i]);
    //             pick = solveII(nums , i+1 , 0 , ls);
    //         }else if(diff == 0){
    //             diff = ls.get(0) - nums[i];
    //             ls.add(nums[i]);
    //             pick = solveII(nums , i+1 , diff , ls);
    //         }else if(ls.get(ls.size()-1) - nums[i] == diff){
    //             ls.add(nums[i]);
    //             pick = (ls.size() > 2 ? 1 : 0) + solveII(nums , i+1 , diff , ls);
    //         }
    //     }
    //     // int notpick = ( ls.size() > 2 ? 1 : 0 ) + solve(nums , idx+1 , diff , ls);
    //     int notpick = solveII(nums , idx+1 , diff , ls);
    //     return pick + notpick;
    // }
}
}
