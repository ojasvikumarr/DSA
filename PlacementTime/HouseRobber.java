package PlacementTime;

import java.util.Arrays;

public class HouseRobber {
    class Solution {
    int[] dp ;
    public int rob(int[] nums) {
        //so we need to have the maximum robbery form the houses 
        //Given that no two adjacent houses are robbed together 
        //Top down appraoch 
        //we staart from the last house and goes to the first house at index 0 
        int n = nums.length ;
        dp = new int[n];
        Arrays.fill(dp , -1);
        // return solve(nums , n-1);
        // return tabulation(nums);
        return spaceOptimized(nums);
    }   
    public int tabulation(int[] nums){
        //bottom up approach 
        //Here we will go from the 0th house to the end 
        //from the base case to the required case 
        //Now at the 0th house what do we have ? the 0th house itself 
        int n = nums.length ;
        int[] tab = new int[n];
        tab[0] = nums[0];
        //now ther obber has to go from 0the house to the n-1 th house 
        for(int i = 1 ; i < n ; i++){
            // the robber will ave two choices to either pick the prev house or leave it 
            //As we can start from any house of our choice so nums[1] must be accepted RIGHT!!
            //But what about tabulation? we simply do this 
            int rob = (i-2 < 0 ? 0 : tab[i-2]) + nums[i];
            int notrob = tab[i-1];

            tab[i] = Math.max(rob , notrob);
        }
        return tab[n-1];
    }

    public int solve(int[] nums , int idx){
        //base case will be when we have reached the 0th house then we are finished 
        if(idx == 0){
            return nums[0] ; 
        }else if(idx < 0){
            return 0 ;
        }
        //we have two options on every house 
        //either we rob or we dont rob the house 
        if(dp[idx] != -1) return dp[idx];
        int rob = Integer.MIN_VALUE ;
        if(idx >= 1)
            rob = solve(nums , idx-2) + nums[idx];//idx-2 skips the next adjacent house
        //fulfilling our given condtion that no two houses are to be robbed 
        int notrob = solve(nums , idx-1) ; 
        //we have to find the maximum amt robbed 
        //thus we select the path that has maximum reward from the two 
        return dp[idx] = Math.max(rob , notrob);
    }

    public int spaceOptimized(int[] nums){
        int n = nums.length ; 
        int prev1 = nums[0];
        int prev2 = 0 ; 
        int curr = 0 ; 
        for(int i = 1 ; i < n ; i++){
            int rob = prev2 + nums[i];
            int notrob = prev1 ; 
            curr = Math.max(rob , notrob);
            prev2 = prev1 ; 
            prev1 = curr ;
        }
        return prev1 ;
    }
}
}
