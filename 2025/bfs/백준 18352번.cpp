#include<bits/stdc++.h>

using namespace std;

int ret;
int a,b;
int n,m,k,x;
int visited[300004];
vector<int> adj[300004];

void bfs(int x){
    visited[x] = 1;
    queue<int> q;
    q.push(x);
    
    while(q.size()){
        int pos = q.front();
        q.pop();
        for(int next_pos : adj[pos]){
            if(visited[next_pos] == 0){
                visited[next_pos] = visited[pos] + 1;
                q.push(next_pos);
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m >> k >> x;
    
    for(int i = 0 ; i<m;i++){
        cin >> a >> b;
        adj[a].push_back(b);
    }
    
    bfs(x);
    
    vector<int> v;
    for(int i = 1;i<=n;i++){
        if(i == x){
            continue;
        }
        if(visited[i] - 1 ==k){
            ret++;
            v.push_back(i);
        }
    }
    if(ret == 0){
        cout <<"-1";
    }
    else{
        sort(v.begin(),v.end());
        for(int i : v){
            cout<< i << "\n";
        }
    }
}
