package PlacementTime.DP;

public class HouseRobberII {
    class Solution {
        public int rob(int[] nums) {
            int noOfHouses = nums.length ;
            if(noOfHouses == 1){
                return nums[0];
            }
            return Math.max(tabulation(nums , 0 , noOfHouses-1) , tabulation(nums , 1 , noOfHouses));
        }
        //space Optimized one 
        public int tabulation(int[] nums , int l , int r){
            int prev1 = nums[l];
            int prev2 = 0 ; 
            int curr = 0 ; 
            int noOfHouses = r ;
            for(int i = l+1 ; i < noOfHouses ; i++){
                int rob = nums[i] + prev2;
                int notrob = 0 + prev1;
                curr = Math.max(rob , notrob);
                prev2 = prev1 ; 
                prev1 = curr ; 
            }
            return prev1 ;
        }
    }
}
