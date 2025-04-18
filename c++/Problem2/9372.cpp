#include <bits/stdc++.h>

using namespace std;

int n,m;
int a,b;
vector<int> adj[1004];
int visited[1004];
int cnt;
void go(int num){
    visited[num] = 1;
    
    for(int a : adj[num]){
        if(visited[a] != 1){
            go(a);
            cnt++;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    while(t--){
        cin >>n>>m;
        memset(visited,0,sizeof(visited));
        for(int i=0;i<1004;i++){
            adj[i].clear();
        }
        for(int i = 0;i<m;i++){
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }
        cnt=0;
        go(a);
        cout<<cnt<<"\n";
    }
    return 0;
}
