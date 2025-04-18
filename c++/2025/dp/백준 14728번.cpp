#include<bits/stdc++.h>

using namespace std;

int n,t;
int k,s;

vector<pair<int,int>> v;
int dp[10004][104];

int go(int total_t, int idx){
    if(total_t < 0){
        return -987654321;
    }
    if(idx == n){
        return 0;
    }
    int &ret = dp[total_t][idx];
    if(ret != 0){
        return ret;
    }
    int sel = go(total_t - v[idx].first, idx+1) + v[idx].second;
    int no_sel = go(total_t,idx+1);
    ret = max(sel,no_sel);
    return ret;
    
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> t;
    
    for(int i=0;i<n;i++){
        cin>>k>>s;
        v.push_back({k,s});
    }
    
    cout <<go(t,0);
}
