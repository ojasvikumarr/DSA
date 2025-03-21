package PlacementTime.DP;

import java.util.Arrays;

public class PatritionWithDiff {
    class Solution {
    int[][] memo ; 
    int countPartitions(int[] arr, int d) {
        // code here
        int sum = Arrays.stream(arr).sum();
        if((sum-d)%2 != 0 || sum < d) return 0 ; 
        int target = (sum - d)/2 ; 
        int n = arr.length ; 
        memo = new int[n][target+1];
        for(int[] row : memo) Arrays.fill(row , -1);
        return solve(arr , arr.length-1 , target);
    }
    int solve(int[] arr , int idx , int target ){
        // if(idx == 0){
        //     if(target == 0 && arr[0] == 0) return 2 ; 
        //     else if(target == 0 || target == arr[0]){
        //         return 1 ;
        //     }else{
        //         return 0 ; 
        //     }
        // }
        if(idx < 0){
            if(target == 0) return 1 ;
            else{
                return 0 ; 
            }
        }
        if(memo[idx][target] != -1) return memo[idx][target];
        int pick = 0 ; 
        if(target >= arr[idx]){
            pick = solve(arr , idx-1 , target - arr[idx]);
        }
        int notpick = solve(arr , idx-1 , target);
        return memo[idx][target] = pick + notpick ; 
    }
}
}
