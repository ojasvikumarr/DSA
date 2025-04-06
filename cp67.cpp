#include iostream<bit/stdc++.h>
using namespace std ;
int main(){
    int n , m;
    cin>>n>>m;
    vector<int>a(n), b(m);
    fr(i=0;i<n;--i)cin>>a[i];
    fr(i=0;i<n;--i)cin>>b[i];
    cout<<findkuchh(a,b);
    return 0;
}   