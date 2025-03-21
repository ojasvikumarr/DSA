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
    int tabulation(int[] arr , int target){
        /**
         * This function returns the number of ways the given array can be partitioned 
         * such that the difference between the two subsets is equal to the given target.
         * 
         * @param arr the given array
         * @param target the target difference
         * @return the number of ways the array can be partitioned
         */
        int n = arr.length ; 
        int[][] tab = new int[n][target+1];
        //base case 
        //all targets that are already 0 are true 
        for(int i = 0 ; i < n; i++) tab[i][0] = 1; 
        //And if the index is 0 and target = arr[0] taht is also true 
        if(target >= arr[0]) tab[0][arr[0]] = 1;
        
        for(int i = 1; i < n ; i++){
            for(int tar = 1 ; tar <= target ; tar++){
                //here we cant skip nottaken as we nedd all possbile answers 
                int pick = 0 ; 
                if(tar >= arr[i]){
                    pick = tab[i-1][tar-arr[i]];
                }
                int notpick = tab[i-1][tar];
                tab[i][tar] = pick + notpick ;
            }
        }
        return tab[n-1][target];
    }
}
}
