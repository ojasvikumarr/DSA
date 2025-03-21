class Solution {
    static int[][] memo ;
    static int knapSack(int val[], int wt[], int capacity) {
        // code here
        int n = wt.length ;  
        // int[][] items = new int[n][2];
        // for(int i = 0 ; i < n ; i++){
        //     items[i] = new int[]{wt[i] , val[i]} ;
        // }
        // Arrays.sort(items , (a , b)-> b[0]/b[1] - a[0]/a[1]);
        memo = new int[n][capacity+1] ; 
        for(int[] row : memo) Arrays.fill(row , -1);
        
        // return solve(wt , val , n-1 , capacity);
        return tabulation(wt , val , capacity);
    }
    //tabulation 
    static int tabulation(int[]wt , int[]val , int bag){
        int n = wt.length ; 
        int[][] dp = new int[n][bag+1];
        //what will be the base case ?
        // if we have reached the last index what will be the base case?
        //our dp table will be storing values right 
        // for(int cap = 0 ; cap <= bag ; cap++){
        //     if(cap % wt[0] == 0){
        //         dp[0][cap] = val[0]*(cap/wt[0]);
        //     }
        // }
        for(int w = wt[0] ; w <= bag ; w++){
            dp[0][w] = ((int)w/wt[0])*val[0];
        }
        for(int i = 1 ; i < n ; i++){
            for(int cap = 1 ; cap <= bag ; cap++){
                //we have two option to pick or leave it 
                int pick = 0; 
                //we need to check if we have enough capacity in bag to hold wt
                if(cap >= wt[i]){
                    pick = val[i] + dp[i][cap-wt[i]];
                }
                int notpick = dp[i-1][cap];
                dp[i][cap] = Math.max(pick , notpick) ; 
            }
        }
        return dp[n-1][bag];
    }
    static int solve(int[] wt , int[] val , int idx , int bag){
        if(idx < 0){
            //we have gone out of items. 
            return 0 ; 
        }
        
        if(memo[idx][bag] != -1) return memo[idx][bag];
        //what do we have ?
        //we can either take this or leave it 
        int take = -(int)1e8;
        if(bag >= wt[idx]){
            take = val[idx] + solve(wt , val , idx , bag-wt[idx]);
        }
        int leaveIt = solve(wt , val , idx-1 , bag);
        return memo[idx][bag] = Math.max(take , leaveIt);
    }
}