#include <bits/stdc++.h>

using namespace std;

vector<pair<int,int>> adj[10004];
int a,b,w,n;
int visited[10004];
int ret;
int one;

void go(int num,int sum){
    visited[num] = 1;
    for(pair<int,int> next : adj[num]){
        if(visited[next.second] == 1){
            continue;
        }
        if(ret < sum + next.first){
            ret = sum + next.first;
            one = next.second;
        }
        go(next.second, sum + next.first);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i<n-1;i++){
        cin >> a >> b >> w;
        adj[a].push_back({w,b});
        adj[b].push_back({w,a});
    }
    
    go(1,0);
    memset(visited, 0, sizeof(visited));
    ret = 0;
    go(one,0);
    cout<< ret;
    
}
