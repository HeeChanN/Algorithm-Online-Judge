#include <bits/stdc++.h>

using namespace std;

vector<int> tree[1002];
int dist[1002][1002];
int n,m;
int visited[1002];
int a, b, c;

int bfs(int s){
    int ret = 0;
    visited[s] = 1;
    queue<pair<int,int>> q;
    q.push({s,0});
    
    while(q.size()){
        int n = q.front().first;
        int w = q.front().second;
        q.pop();
        for(int i = 0;i<tree[n].size();i++){
            if(visited[tree[n][i]] == 1){
                continue;
            }
            if(tree[n][i] == b){
                ret = (w +dist[n][tree[n][i]]);
                break;
            }
            q.push({tree[n][i],w+dist[n][tree[n][i]]});
            visited[tree[n][i]] = 1;
        }
        if(ret != 0){
            break;
        }
    }
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    for(int i =0;i<n-1;i++){
        cin>> a >> b >> c;
        tree[a].push_back(b);
        tree[b].push_back(a);
        dist[a][b] = c;
        dist[b][a] = c;
    }
    for(int i = 0; i<m;i++){
        cin >> a >> b;
        memset(visited,0,sizeof(visited));
        cout << bfs(a)<<"\n";
    }
}
