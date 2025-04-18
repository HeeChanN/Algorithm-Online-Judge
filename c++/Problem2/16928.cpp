#include<bits/stdc++.h>

using namespace std;

int n,m;
int start, finish;

vector<int> adj[104];
int visited[104];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    
    for(int i = 0;i<n;i++){
        cin >> start >> finish;
        adj[start].push_back(finish);
    }
    for(int i = 0;i<m;i++){
        cin >> start >> finish;
        adj[start].push_back(finish);
    }
    queue<int> q;
    q.push(1);
    while(q.size()){
        int pos = q.front();
        q.pop();
        for(int i = 6;i>=1;i--){
            if(pos + i > 100){
                continue;
            }
            int next = adj[pos+i].size() == 0 ? pos + i : adj[pos+i][0];
            if(visited[next] == 0){
                visited[next] = visited[pos] + 1;
                q.push(next);
            }
            else if (visited[next] > visited[pos] + 1){
                visited[next] = visited[pos] + 1;
            }
        }
    }
    cout<<visited[100];
}
