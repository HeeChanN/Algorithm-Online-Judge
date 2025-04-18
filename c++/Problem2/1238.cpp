#include <bits/stdc++.h>

using namespace std;

int n ,m, x;
int u, v, w;
int ret;

vector<pair<int,int>> adj[1004];
int dist[1004];
int visited[1004];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m >> x;
    for(int i = 0; i<m;i++){
        cin >> u >> v >> w;
        adj[u].push_back({w,v});
    }
    fill(&dist[0], &dist[1003], 987654321);
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    
    dist[x] = 0;
    pq.push({0,x});
    while(pq.size()){
        int p = pq.top().second;
        int d = pq.top().first;
        pq.pop();
        if(d != dist[p])
            continue;
        for(pair<int,int> next : adj[p]){
            int np = next.second;
            int nd = next.first;
            if(d + nd < dist[np]){
                dist[np] = d + nd;
                pq.push({dist[np], np});
            }
        }
    }
    for(int i = 1;i<=n;i++){
        if(i == x){
            continue;
        }
        fill(&visited[0], &visited[1003],987654321);
        priority_queue<pair<int,int>,vector<pair<int,int>>, greater<pair<int,int>>> pq2;
        visited[i] = 0;
        pq2.push({0,i});
        while(pq2.size()){
            int p = pq2.top().second;
            int d = pq2.top().first;
            pq2.pop();
            if(d != visited[p])
                continue;
            for(pair<int,int> next : adj[p]){
                int np = next.second;
                int nd = next.first;
                if(d + nd < visited[np]){
                    visited[np] = d + nd;
                    pq2.push({visited[np], np});
                }
            }
        }

        ret = max(ret, dist[i] + visited[x]);
    }
    cout<<ret;
}
