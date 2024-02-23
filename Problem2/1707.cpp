#include<bits/stdc++.h>

using namespace std;

int k;
int v,e;
int a,b;
int check,flag;

vector<int> adj[20004];
int visited[20004];
int arr[20004];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> k;
    while(k--){
        flag = 0;
        cin >> v >> e;
        for(int i = 0; i<20004;i++){
            adj[i].clear();
        }
        for(int i = 0;i<e;i++){
            cin >> a >> b;
            adj[a].push_back(b);
            adj[b].push_back(a);
        }
        memset(arr,0,sizeof(arr));
        memset(visited,0,sizeof(visited));
        
        
        for(int i = 1; i<=v;i++){
            queue<int> q;
            if(visited[i] == 0){
                q.push(i);
                while(q.size()){
                    int pos = q.front();
                    q.pop();
                    visited[pos] = 1;
                    for(int next : adj[pos]){
                        if(visited[next] == 0){
                            q.push(next);
                            arr[next] = arr[pos] ^ 1;
                        }
                        else if (arr[next] == arr[pos]){
                            flag = 1;
                        }
                    }
                }
            }
        }
            
            
        if(flag == 1){
            cout<<"NO"<<"\n";
        }
        else{
            cout<<"YES" << "\n";
        }
    }
}
