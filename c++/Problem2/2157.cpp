#include<bits/stdc++.h>

using namespace std;

int n, m, k;
int a,b,w;
int dp[302][302];
vector<pair<int,int>> adj[302];

int go(int num, int cnt){
    if(num == n){
        if(cnt <= m){
            return 0;
        }
        else{
            return -987654321;
        }
    }
    int &ret = dp[num][cnt];
    if(ret != -987654321){
        return ret;
    }
    for(pair<int,int> next : adj[num]){
        int num = go(next.first, cnt + 1) + next.second;
        ret = max(ret, num);
    }
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m >> k;

    for(int i = 0; i<k;i++){
        cin>>a>>b>>w;
        if(b<a){
            continue;
        }
        adj[a].push_back({b,w});
    }
    fill(&dp[0][0], &dp[301][302],-987654321);
    cout<<go(1,1);
}
