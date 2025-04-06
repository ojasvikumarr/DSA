#include <bits/stdc++.h>

using namespace std ; 
int main(){
    ios::sync_with_stdio(false);
    cin.tie(0);
    int n , sum ; 
    cin >> n >> sum; 
    vector<int> coins(n);
    for(int i = 0 ; i < n ; i++) cin >> coins[i];

    const int MOD = 1e9+7 ; 
    vector<int> dp(sum+1 , 0);
    dp[0] = 1 ; 

    for(int i = 1 ; i <= sum ; i++){
        for(int coin : coins){
            if(coin <= i){
                dp[i] = (dp[i] + dp[i-coin])%MOD ; 
            }
        }
    }
    cout<<dp[sum];
    return 0 ; 
}