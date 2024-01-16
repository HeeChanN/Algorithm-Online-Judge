#include <bits/stdc++.h>

using namespace std;

int n;

vector<int> adj[102];
char d[102];

void go(int num){
    if(adj[num].size()){
        go(adj[num][0]);
    }
    cout<<d[num];
    if(adj[num].size() == 2)
        go(adj[num][1]);
        
    return;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    for(int i = 1; i<=10;i++){
        cin >> n;
        for(int j = 1;j<=100;j++){
            adj[j].clear();
        }
        
        for(int j =0;j<n;j++){
            int num;
            char ch;
            cin >> num>>ch;
            d[num] = ch;
            int l,r;
            if(num * 2 <= n){
                cin>>l;
                adj[num].push_back(l);
            }
            if(num * 2 + 1 <=n){
                cin>>r;
                adj[num].push_back(r);
            }
        }
        
        cout<<"#"<<i<<" ";
        go(1);
        cout<<"\n";
        
    }
    
    return 0;
}
