#include<bits/stdc++.h>

using namespace std;

int n,t;
int a,b;
int u,v;
vector<int> adj[104];
int visited[104];
int ret;

void go(int here, int cnt){
    if(here == b){
        ret = cnt;
        return;
    }
    for(int next : adj[here]){
        if(visited[next] == 0){
            visited[next] = 1;
            go(next, cnt + 1);
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>n;
    cin>>a>>b;
    cin>>t;
    for(int i =0;i<t;i++){
        cin>>u>>v;
        adj[u].push_back(v);
        adj[v].push_back(u);
    }
    visited[a] = 1;
    go(a,0);
    if(visited[b]==0){
        cout<<"-1";
    }
    else
        cout<<ret;
}
