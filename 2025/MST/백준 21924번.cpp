#include<bits/stdc++.h>

using namespace std;

int n, m;
long long u,v,w;
long long ret;
long long s;
int cnt;
vector<pair<long long ,long long>> adj[100004];
priority_queue<pair<long long,long long>, vector<pair<long long,long long>>, greater<pair<long long,long long>>> pq;

int visited[100004];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    
    for(int i = 0; i<m;i++){
        cin >> u >> v >> w;
        adj[u].push_back({w,v});
        adj[v].push_back({w,u});
        if(pq.size() == 0){
            pq.push({0,u});
        }
        s = s + w;
    }
    while(pq.size()){
        long long nw = pq.top().first;
        long long np = pq.top().second;
        pq.pop();
        
        if(visited[np] == 1){
            continue;
        }
        visited[np] = 1;
        cnt++;
        ret = ret + nw;
        for(pair<long long,long long> x : adj[np]){
            if(visited[x.second] == 0){
                pq.push(x);
            }
        }
    }
    if(cnt != n){
        cout << "-1";
    }
    else{
        cout << s - ret;
    }
    
}
