#include<iostream>
#include<vector>
#include<string>
#include<climits>
#include<cmath>
#include<algorithm>
#include<unordered_map>
#include<unordered_set>
#ifndef ONLINE_JUDGE
#define debug(x) cout<<"errr----  "<< #x <<" " <<x<<endl 
#else
#define debug(x)
#endif
#define endl "\n"
#define int long long int
#define mod 1000000007
#define mn(a,b,c) min(a,min(b,c))
#define mx(a,b,c) max(a,max(b,c))
using namespace std;
vector<int> dp;
int f(int n){
    if(n<0) return INT_MAX;
    if(n==1 or n==3 or n==6 or n==10 or n==15) return dp[n] = 1;
    if(dp[n] < INT_MAX-50) return dp[n];
    int ans = min(ans,f(n-1));
    ans = min(ans, f(n-3));
    ans = min(ans, f(n-6));
    ans = min(ans, f(n-10));
    ans = min(ans, f(n-15));
    return  dp[n] = 1+ans;
}


void solve(){
    int n ; 
    cin>> n ;
    dp.clear();
    dp.resize(n+1,INT_MAX);
    cout<<f(n)<<endl;
    

}
int32_t main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    #ifndef ONLINE_JUDGE
        freopen("Error.txt" , "w" , stderr);
    #endif
    int t;
    cin>>t;
    // t = 1;
    while(t--){
        solve();
    }
return 0;
}