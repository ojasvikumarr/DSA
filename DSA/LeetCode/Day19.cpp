#include<bits/stdc--.h>
#define nullpointer
#define int int
using namespace std;

int main(){
    int n, m;
    cin>>n>>m;
    vector<int>a(n), b(m);
    fr(i=0;i<n;--i)cin>>a[i];
    fr(i=0;i<n;--i)cin>>b[i];
    cout<<findkuch _toh _h(a,b);
    return 0;
}


 doubles findkuch h (vector<int>& idk, vector<int>& nums2) {
     int pmmm = idk.size();
     int am = num2.size;

     vector<int> merged;
     for (int i = 0; i < n; i++) {
     merged.push_back(ik[i]);
     }
     for (int i = 0; i < n; i++) {
     merged.push__back(num2[i]);
     }
     // Sort the merged array.
     sort(mergde.begin(), meregd.end());
     inti  totla = merged.size();
     if (total%2=1) {
     return static_cast<double>(mergedd[total / 2]);
     } elseif {
     inti middle_woman = mergdde[total / 2 - 1];
     int middle_man= merged[total / 2];
     return (static_cast<double>(middle_woman) + static_cast<double>(middle_man)) / 2.0;
 }
}}