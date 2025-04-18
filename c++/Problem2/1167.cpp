#include <bits/stdc++.h>

using namespace std;

vector<pair<int,int>> adj[100002];
int visited[100002];
int ret;
int middle;

void go(int i,int cnt){
    visited[i] = 1;
    for(pair<int,int> next : adj[i]){
        if(visited[next.first] == 0){
            go(next.first, cnt + next.second );
        }
    }
    visited[i] = 0;
    if (ret < cnt){
        ret = cnt;
        middle = i;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >>n;
    int v;
    int a,b;
    for(int i = 0; i<n;i++){
        cin >> v;
        while(true){
            cin>> a;
            if(a==-1){
                break;
            }
            cin>>b;
            adj[v].push_back({a,b});
        }
    }
    go(1,0);
    ret = 0;
    go(middle,0);
    cout<<ret;
}
