class Solution {
    public int[] smallestSubarrays(int[] nums) {
        int n = nums.length ;
        int[] res = new int[n];
        int[][] dp = new int[n][32];
        for(int[] row : dp) Arrays.fill(row , -1);
        for(int i = 31 ; i >= 0 ; i--){
            if((nums[n-1]&(1<<i)) != 0){
                dp[n-1][i] = n-1 ;
            }
        }
        res[n-1] = 1 ;

        for(int i = n-2 ; i >= 0 ; i--){
            // first fill up the 32 columns 
            int maxi = i ;
            for(int j = 31 ; j >= 0 ; j--){
                if( (nums[i]&(1<<j)) != 0 ){
                    dp[i][j] = i ;
                }else{
                    dp[i][j] = dp[i+1][j];
                }
                maxi = Math.max(maxi , dp[i][j]);
            }
            res[i] = maxi - i + 1;
        }
        return res ;
    }
}