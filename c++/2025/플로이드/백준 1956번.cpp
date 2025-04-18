#include<bits/stdc++.h>


using namespace std;

int v,e;
int a,b;
long long c;

long long adj[402][402];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    fill(&adj[0][0], &adj[401][402], INT_MAX);
    cin >> v >> e;
    for(int i = 0; i<e;i++){
        cin >> a >> b >> c;
        adj[a-1][b-1] = c;
    }
    
    for(int k = 0; k < v; k++){
        for(int i = 0; i<v;i++){
            for(int j = 0; j<v;j++){
                adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j]);
            }
        }
    }
    long long ret = INT_MAX;
    for(int i= 0;i<v;i++){
        if(adj[i][i] != INT_MAX){
            ret = min(ret,adj[i][i]);
        }
    }
    
    if(ret==INT_MAX){
        cout<<"-1";
    }
    else{
        cout<<ret;
    }
}
