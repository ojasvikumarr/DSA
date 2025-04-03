public class Day181 {
    class Solution {
        public long maximumTripletValue(int[] nums) {
            int n = nums.length ; 
            int[] preMax = new int[n];
            int[] suffMax = new int[n];
            preMax[0] = nums[0];
            suffMax[n-1] = nums[n-1];
            for(int i = 1 ; i < n ; i++){
                preMax[i] = Math.max(preMax[i-1] , nums[i]);
                suffMax[n-i-1] = Math.max(suffMax[n-i] , nums[n-i-1]);
            }
            long res = Long.MIN_VALUE ; 
            for(int i = 1 ; i < n-1 ; i++){
                // System.out.println("preMax " + preMax[i-1] +"nums " + nums[i] + "suffmax " +suffMax[i+1]);
                res = Math.max(res , (long)(preMax[i-1] - nums[i])*(long)suffMax[i+1]);
            }
            if(res < 0) return 0 ; 
            return res  ; 
        }
    }
}
