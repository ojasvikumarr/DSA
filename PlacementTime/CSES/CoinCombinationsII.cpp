#include <bits/stdc++.h>
using namespace std ; 
int main(){
    int n , sum ; 
    cin>>n>>sum ; 
    vector<int> coins(n);
    for(int i = 0 ; i < n; i++){
        cin>>coins[i];
    }
    int MOD = (int)1e9 + 7 ;    
    vector<vector<int>> dp(n+1 , vector<int>(sum+1 , 0)) ; 

    for(int i = 0 ; i <= n ; i++) dp[i][0] = 1 ; 

    for(int i = n-1 ; i >= 0 ; i--){
        for(int j = 1 ; j <= sum ; j++){
            int skip = dp[i+1][j];
            int pickking = 0 ; 
            if(coins[i] <= j){
                pickking = dp[i][j-coins[i]];
            }

            dp[i][j] = (skip + pickking)%MOD ; 
        }
    }

    cout<<dp[0][sum];
}