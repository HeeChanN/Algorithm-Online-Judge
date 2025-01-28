#include<bits/stdc++.h>

using namespace std;

int n;
vector<int> adj[52];
int a,b;
int visited[52];
vector<pair<int,int>> v;

int bfs(int x){
    int dist = 0;
    queue<int> q;
    visited[x] = 1;
    q.push(x);
    
    while(q.size()){
        int num = q.front();
        q.pop();
        for(int i : adj[num]){
            if(visited[i]==0){
                visited[i] = visited[num] + 1;
                dist = max(dist,visited[i]);
                q.push(i);
            }
        }
    }
    return dist-1;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>n;
    
    while(1){
        cin >> a >> b;
        if(a==-1 && b == -1){
            break;
        }
        adj[a].push_back(b);
        adj[b].push_back(a);
    }
    
    for(int i = 1 ; i<=n;i++){
        memset(visited,0,sizeof(visited));
        int dist = bfs(i);
        v.push_back({dist,i});
    }
    sort(v.begin(), v.end());
    
    int score = v[0].first;
    int cnt = 0;
    for(int i = 0; i<v.size();i++){
        if(v[i].first == score){
            cnt++;
        }
        else{
            break;
        }
    }
    cout<<score<< " " << cnt<<"\n";
    for(int i = 0; i<v.size();i++){
        if(v[i].first == score){
            cout<<v[i].second << " ";
        }
        else{
            break;
        }
    }
}
