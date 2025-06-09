// Online C++ compiler to run C++ program online
#include <iostream>
#include <vector>
using namespace std ; 
vector<vector<long>> dp (1e6+1 ,vector<long>(2));
int main() {
    int t ; 
    cin>>t ;
    while(t-- > 0){
        int n ; 
        cin>>n ; 
        dp[n][0] = 1 ;
        dp[n][1] = 1 ; 
        int mod = 1e9 + 7 ;
        for(int i = n - 1 ; i >= 0 ; i--){
            dp[i][0] = (2*dp[i+1][0] + dp[i+1][1])%mod ; 
            dp[i][1] = (4*dp[i+1][1] + dp[i+1][0])%mod ; 
        }
        int res = (dp[1][0] + dp[1][1])%mod ; 
        cout<<res<<endl ;
    }

    return 0;
}