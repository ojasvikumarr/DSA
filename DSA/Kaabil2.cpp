#include<iostream>
#include<vector>
#include<string>
#include<climits>
#include<cmath>
#include<algorithm>
#include<unordered_map>
#include<unordered_set>
#include<set>
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

//This is an optimized solution for the problem 
// Here, we can see that we are using sets and pair stl 
// we use the in build function .count which checks whether the set b contains 
// ele that is the iterator of set a
// if it exists it pushes it in the ans which prints it at last 

//TIme complexity 
// O(nlogn)
void function(set<pair<int,int> > &a,et<pair<int,int> > &b){
    vector<pair<int,int> > ans;
    for(auto ele : a){
        if(b.count(ele)){
            ans.push_back(ele);
        }
    }
    for(auto ele : ans){
        cout<<"( "<<ele.first<<" , "<<ele.second<<" )"<<endl;
    }
}

//heres with the sample testcase

void solve(){
    set<pair<int,int> > a;
    set<pair<int,int> > b;

    pair<int,int> p1;
    p1.first = 3;
    p1.second = 4;
    a.insert(p1);
    b.insert(p1);
    pair<int,int> p2;
    p2.first = 3;
    p2.second = 5;
    a.insert(p2);
    b.insert(p2);
    pair<int,int> p3;
    p3.first = 3;
    p3.second = 6;
    a.insert(p3);
    vector<pair<int,int> > ans;
    for(auto ele : a){
        if(b.count(ele)){
            ans.push_back(ele);
        }
    }
    for(auto ele : ans){
        cout<<"( "<<ele.first<<" , "<<ele.second<<" )"<<endl;
    }
}

int32_t main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    #ifndef ONLINE_JUDGE
        freopen("Error.txt" , "w" , stderr);
    #endif
    int t;
    //cin>>t;
    t = 1;
    while(t--){
        solve();
    }
return 0;
}