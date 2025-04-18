#include<bits/stdc++.h>

using namespace std;


typedef pair<int, pair<int,int>> p;

vector<p> edges;

int n, m,ret;
int u,v,w;
string str;
int sex[1004];
int parent[1004];

int find_parent(int a){
    if(parent[a] == a){
        return a;
    }
    return parent[a] = find_parent(parent[a]);
}

void union_root(int a, int b){
    int pa = find_parent(a);
    int pb = find_parent(b);
    if(pa != pb){
        parent[pa] = pb;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    for(int i = 1;i<=n;i++){
        cin >> str;
        if(str == "W"){
            sex[i] = 1;
        }
        parent[i] = i;
    }
    for(int i = 0 ;i<m;i++){
        cin >> v >> u >> w;
        edges.push_back({w,{v,u}});
    }

    sort(edges.begin(), edges.end());
    
    vector<p> mst;
    for(int i = 0; i<m;i++){
        p cur_edge = edges[i];
        int nd = cur_edge.first;
        int a = cur_edge.second.first;
        int b = cur_edge.second.second;
        if(find_parent(a) == find_parent(b) || sex[a] == sex[b]){
            continue;
        }
        union_root(a,b);
        ret = ret + nd;
        mst.push_back(cur_edge);
        if(mst.size() == n-1){
            cout<<ret;
            break;
        }
    }
    if(mst.size() != n-1){
        cout << "-1";
    }
}

