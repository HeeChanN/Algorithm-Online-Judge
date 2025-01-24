#include<bits/stdc++.h>

using namespace std;

typedef pair<long long,pair<int,int>> p;
vector<p> edges;

int parent[1002];
int n;
long long w;
long long ret = 0L;


int find_root(int x){
    if(parent[x] == x){
        return x;
    }
    return parent[x] = find_root(parent[x]);
}

void union_root(int a, int b){
    a = find_root(a);
    b = find_root(b);
    
    if(a!=b)
        parent[b] = a;
}



int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    
    for(int i = 0 ; i<n;i++){
        for(int j = 0;j<n;j++){
            cin >> w;
            edges.push_back({w,{i,j}});
        }
    }
    
    for(int i = 0; i<n;i++){
        parent[i] = i;
    }
    sort(edges.begin(), edges.end());
    
    for(int i = 0; i<edges.size();i++){
        p cur_edge = edges[i];
        
        int a = cur_edge.second.first;
        int b = cur_edge.second.second;
        w = cur_edge.first;
        if(find_root(a) == find_root(b))
            continue;
        ret = ret + w;
        union_root(a,b);
    }
    cout << ret;
}
