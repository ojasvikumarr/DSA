package DynamicProgramming;

import java.util.Arrays;

public class WiggleSubseq {
    class Solution {
    int[][] dp ;
    public int wiggleMaxLength(int[] nums) {
        int n = nums.length ;
        int[][] tab = new int[n][2];
            tab[n-1][0] = 0 ; 
            tab[n-1][1] = 0 ; 
        for(int i = n-2 ; i >= 0 ; i--){
            for(int flag = 0 ; flag <= 1 ; flag++){
                int pick = 0 ; 
                if(flag == 1 && nums[i] > nums[i+1]){
                    pick = 1 + tab[i+1][0];
                }else if(flag == 0 && nums[i] < nums[i+1]){
                    pick = 1 + tab[i+1][1];
                }
                int notPick = tab[i+1][flag];
                tab[i][flag] = Math.max(pick , notPick);
            }
        }
        return 1 + Math.max(tab[0][0] , tab[0][1]);
    }
    public int wiggleMaxLengthII(int[] nums) {
        dp = new int[nums.length][2];
        for(int[] row : dp) Arrays.fill(row , -1);
        return 1 + Math.max(solve(nums , 0 , 0) , solve(nums , 0 , 1));
    }
    public int solve(int[] nums , int idx , int flag){
        if(idx >= nums.length-1) return 0 ; 
        if(dp[idx][flag] != -1) return dp[idx][flag];
        int pick = 0 ; 
        // if(flag == -1 ){
        //     int diff = nums[idx] - nums[idx+1];
        //     if(diff < 0){
        //         pick = 1 + solve(nums , idx+1 , 0);
        //     }else{
        //         pick = 1 + solve(nums , idx+1 , 1);
        //     }
        // }
        if(flag == 0 && nums[idx] - nums[idx+1] < 0){
            pick = 1 + solve(nums , idx + 1 , 1);
        }else if(flag == 1 && nums[idx] - nums[idx+1] > 0){
            pick = 1 + solve(nums , idx + 1 , 0);
        }
        int notPick =solve(nums , idx+1 , flag);
        return dp[idx][flag] = Math.max(pick , notPick);
    }
}
}
