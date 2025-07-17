class Solution {
    public int maximumLength(int[] nums) {
        int n = nums.length ; 
        dp = new int[n][n+1];

        for(int[] row : dp) Arrays.fill(row , -1);
        int zeroRem = solve(nums , 0 , n , 0 );

        for(int[] row : dp) Arrays.fill(row , -1);
        int oneRem = solve(nums , 0 , n , 1 );
        return Math.max(zeroRem , oneRem);

        int zero = solve(nums , 0);
        int one = solve(nums , 1);

        return Math.max(zero , one);

        return solve(nums);
    }
    
    public int solve(int[] nums ){
        int n = nums.length ;
        int[][] dp = new int[n][2];
        for(int[] row : dp) Arrays.fill(row , 1);

        int maxi = 1 ; 
        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                if( (nums[i] + nums[j]) % 2 == 1 ){
                    dp[i][1] = Math.max(dp[i][1] , 1 + dp[j][1]);
                }else{
                    dp[i][0] = Math.max(dp[i][0] , 1 + dp[j][0]);
                }
            }
            maxi = Math.max(maxi , Math.max(dp[i][0] , dp[i][1]));
        }

        return maxi ; 
    }


    // public int solve(int[] nums ,int k ){
    //     int n = nums.length ;
    //     int[] dp = new int[n];
    //     Arrays.fill(dp , 1);

    //     int maxi = 1 ; 
    //     for(int i = 1 ; i < n ; i++){
    //         for(int j = 0 ; j < i ; j++){
    //             if( (nums[i] + nums[j])%2 == k ){
    //                 dp[i] = Math.max(dp[i] , 1 + dp[j]);
    //             }
    //         }
    //         maxi = Math.max(maxi , dp[i]);
    //     }

    //     return maxi ; 
    // }


    // public int solve(int[] nums , int k){
    //     int n = nums.length ; 
    //     List<Integer> LIS = new ArrayList<>();
    //     for(int i = 0 ; i < n ; i++){
    //         int ele = nums[i];
    //         int idx = binarySearch(LIS , ele);
    //         if(idx == LIS.size()){
    //             LIS.add(ele);
    //         }else{
    //             LIS.set(idx , ele);
    //         }
    //     }

    //     return LIS.size();
    // }
    // public int binarySearch(List<Integer> LIS , int target){
    //     int lo = 0 ; 
    //     int hi = LIS.size()-1;
    //     while(lo <= hi){
    //         int mid = lo + (hi - lo)/2 ; 
    //         if(LIS.get(mid) >= target){
    //             hi = mid - 1 ; 
    //         }else{
    //             lo = mid + 1 ;
    //         }
    //     }
    //     return lo ; 
    // }







    // int[][] dp ; 
    // public int solve(int[] nums , int idx , int prev , int k ){
    //     int n = nums.length ; 
    //     if(idx == n){
    //         return 0 ; 
    //     }
    //     if(dp[idx][prev] != -1){
    //         return dp[idx][prev] ;
    //     }
    //     // pick 
    //     int pick = 0 ; 
    //     if(prev == n || (nums[idx] + nums[prev])%2 == k){
    //         pick = 1 + solve(nums , idx+1 , idx , k);
    //     }
    //     int skip = solve(nums , idx+1 , prev , k);
        
    //     return dp[idx][prev] = Math.max(pick , skip);
    // }

    public int maximumLength(int[] nums, int k) {
        return solve(nums , k);
    }
    public int solve(int[] nums , int k){
        int n = nums.length ; 
        int[][] dp = new int[n][k+1];

        for(int[] row : dp) Arrays.fill(row , 1);

        int maxi = 1 ; 

        for(int i = 0 ; i < n ; i++){
            for(int j = 0 ; j < i ; j++){
                int mod = (nums[i] + nums[j])%k ; 
                dp[i][mod] = Math.max(dp[i][mod] , 1 + dp[j][mod]);
                maxi = Math.max(maxi , dp[i][mod]) ;
            }
        }
        return maxi ;
    }

}