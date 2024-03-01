#include<bits/stdc++.h>

using namespace std;

int n,m;

void combi(vector<int> v,int visited[]){
    if(v.size() == m){
        for(int i = 0;i<v.size();i++){
            cout<< v[i] << " ";
        }
        cout<<"\n";
        return;
    }
    for(int i = 1;i<=n;i++){
        if(visited[i] == 1){
            continue;
        }
        v.push_back(i);
        visited[i] = 1;
        combi(v,visited);
        v.pop_back();
        visited[i] = 0;
    }
}

int main(){
    
    cin >> n >> m;
    vector<int> v;
    int visited[10] = {0};
    combi(v,visited);
    
}
