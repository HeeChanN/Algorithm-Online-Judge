#include <bits/stdc++.h>

using namespace std;

int t,k;
int a,b;
vector<pair<int,int>> v;
int dp[10004];
int dp2[10004];
int visited[10004];
int visited2[10004];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    cin >> k;
    for(int i = 0; i<k;i++){
        cin>> a >> b;
        v.push_back({a,b});
    }
    visited[0] = 1;
    visited2[0] = 1;
    dp[0] = 1;
    dp2[0] = 1;
    for(int i = 0;i<v.size();i++){
        int coin = v[i].first;
        int lim = v[i].second;
        for(int j =0;j<=t;j++){
            if(visited[j] == 0){
                continue;
            }
            int start = j;
            int inc = dp[j];
            
            for(int k = 0; k< lim;k++){
                if(start+coin>t){
                    break;
                }
                dp2[start+coin] = inc + dp2[start+coin];
                start = start + coin;
                visited2[start] = 1;
            }
        }
        
        for(int j = 0; j <=t; j++){
            visited[j] = visited2[j];
            dp[j] = dp2[j];
        }
    }
    cout<<dp[t];
}
