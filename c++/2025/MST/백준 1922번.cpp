#include <bits/stdc++.h>

using namespace std;

typedef pair<int, pair<int,int>> p;
vector<p> v;
int parent[1004];


int n,m;
int a,b,c;
int ret;

int find_parent(int x){
    if(parent[x] == x){
        return x;
    }
    return parent[x] = find_parent(parent[x]);
}

void union_parent(int a, int b){
    int pa = find_parent(a);
    int pb = find_parent(b);
    if(pa != pb){
        parent[pb] = pa;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    cin >> m;
    
    for(int i = 0; i<m;i++){
        cin >> a >> b >>c;
        if(a==b){
            continue;
        }
        v.push_back({c,{a,b}});
    }
    
    for(int i = 0; i<1004;i++){
        parent[i] = i;
    }
    sort(v.begin(), v.end());
    
    for(int i = 0; i<v.size();i++){
        p cur_edge = v[i];
        a = cur_edge.second.first;
        b = cur_edge.second.second;
        c = cur_edge.first;
        if(find_parent(a) == find_parent(b)){
            continue;
        }
        union_parent(a,b);
        ret = ret +c;
    }
    cout<<ret;
}
