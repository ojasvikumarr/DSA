package LeetCode;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class Day162 {
    class Solution {
    int[][] memo ; 
    public int minCapability(int[] nums, int k) {
        int l = Integer.MAX_VALUE ; 
        int r = Integer.MIN_VALUE ; 
        for(Integer it : nums){
            l = Math.min(it , l);
            r = Math.max(it , r);
        } 
        int interRes = 0 ; 
        while(l <= r){
            int mid = l + (r-l)/2 ; 
            if(isPossible(nums , k , mid)){
                interRes = mid ; 
                r = mid-1 ; 
            }else{
                l = mid + 1 ; 
            }
        }
        return interRes ;
    }
    public boolean isPossible(int[] nums , int k , int mid){
        int houses = 0; 
        for(int i = 0 ; i < nums.length ; i++){
            if(nums[i] <= mid){
                houses++ ; 
                i++ ; 
            }
        }
        return houses >= k ; 
    }
    public int minCapabilityIII(int[] nums, int k) {
        int n = nums.length ; 
        memo = new int[n+1][k+1];
        for(int[] row : memo) Arrays.fill(row , -1);
        return solveII(nums , 0 , k);
    }

    public int solveII(int[] nums , int i , int k ){
        if(k == 0) return 0 ; 
        if(i >= nums.length) return Integer.MAX_VALUE ;
        if(memo[i][k] != -1) return memo[i][k];
        int pick = Math.max(nums[i] , solveII(nums , i+2 , k-1));
        int notpick = solveII(nums , i+1 , k);
        return memo[i][k] = Math.min(pick , notpick);
    }



    int mini ;
    Map<String , Integer> map ;
    int[][][] dp ; 
    
    public int minCapabilityII(int[] nums, int k) {
        mini = Integer.MAX_VALUE ; 
        map = new HashMap<>();
        int maxi = Integer.MIN_VALUE ; 
        for(Integer it : nums) maxi = Math.max(maxi , it);
        dp = new int[nums.length + 1][k + 1][maxi+1];
        for(int[][] mat : dp){
            for(int[] row : mat){
                Arrays.fill(row ,-1);
            }
        }
        solve(nums , 0 , k , 0);
        return mini ; 
    }
    public int solve(int[] nums , int i , int k , int maxi ){
        if(k == 0){
            mini = Math.min(mini , maxi);
            return maxi ; 
        }
        if(i >= nums.length){
            if(k == 0){
                mini = Math.min(mini , maxi);
                return maxi ;
            }
            return -1 ; 
        }
        // String key = i + " " + k + " " + maxi ; 
        // if(map.containsKey(key)){
        //     return map.get(key);
        // }
        if(dp[i][k][maxi] != -1){
            return dp[i][k][maxi];
        }
        int currMaxi = Math.max(maxi , nums[i]);
        int pick = 0;
        if(k-1 >= 0)
        pick = solve(nums , i+2 , k-1 , currMaxi);
        int notPick = solve(nums , i+1 , k , maxi);
        int res = Math.max(pick , notPick);
        // map.put(key , res);
        dp[i][k][maxi] = res ; 
        return res ;
    }
}
}
