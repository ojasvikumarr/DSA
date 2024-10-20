int minSubset(vector<int> &arr , int n){
    int totsum = 0 ;
    for(int i = 0 ; i < n ; i++) totsum += arr[i];
    int k = totsum ;
    vector<vector<bool>> dp (n, vector<bool>(k+1 , 0));
    //this means a 2D Dp where value will be of boolean type 
    //there will be n rows and k+1 columns and all 
    //the elements will be initialised with 0 
    for(int i = 0 ; i < n ; i++) dp[i][0] = true ;
    //so 0th row ko humne true is inittialise kardiya hai 
    if(arr[0] <= k) dp[0][arr[0]] = true ;
    for(int idx = 1 ; idx < n ; idx++){
        for(int target = 1 ; target <= k ; target++){
            bool notTake = dp[idx-1][target];
            bool Take = false ;
            if(arr[idx] <= target) Take = dp[idx-1][target-arr[idx]];
            dp[idx][target] = Take | notTake ;
        }
    }
    int mini = 0 ;
    //dp[idx-1][col -> 0 ..... target]
    for(int col = 0 ; col < totsum/2 ; col++){
        if(dp[n-1][col] == true){
            mini = min(mini , abs((totsum-col)-col));
        }
    }
    return mini ;
}