#include <bits/stdc++.h>

using namespace std;

int n,m;
int u,v,w;

int parent[200004];

bool comp(pair<int, pair<int,int>> a, pair<int, pair<int,int>> b){
    return a.first < b.first;
}

int find(int n){
    if(parent[n] == n){
        return n;
    }
    return parent[n] = find(parent[n]);
}

void unio(int a, int b){;
    int pb = find(b);
    int pa = find(a);
    parent[pa] = pb;
    
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    while(true){
        vector<pair<int, pair<int,int> >> arr;
        int ret = 0;
        int sum = 0;
        cin>>n>>m;
        if(n == 0 && m == 0){
            break;
        }
        for(int i = 0;i<m;i++){
            cin>>u>>v>>w;
            arr.push_back({w,{u,v}});
            sum = sum + w;
        }
        sort(arr.begin(), arr.end());
        for(int i = 0;i<n;i++){
            parent[i] = i;
        }
        
        for(int i = 0;i<arr.size();i++){
            int a = arr[i].second.first;
            int b = arr[i].second.second;
            if(find(a) != find(b)){
                ret += arr[i].first;
                unio(a,b);
            }
        }
        cout<<sum - ret<<"\n";
    }
    
}
