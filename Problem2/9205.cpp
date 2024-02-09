#include <bits/stdc++.h>

using namespace std;

int t,n;
vector<pair<int,int>> amenity;

pair<int,int> start;
pair<int,int> finish;

int bfs(int idx){
    int visited[102];
    queue<int> q;
    memset(visited, 0, sizeof(visited));
    visited[idx] = 1;
    q.push(idx);
    while(q.size()){
        int p = q.front();
        q.pop();
        if(p == amenity.size()-1){
            return 1;
        }
        for(int i = 0 ; i<amenity.size();i++){
            int dist = abs(amenity[i].first - amenity[p].first) + abs(amenity[i].second - amenity[p].second);
            if( visited[i] ==0 && dist <= 50 * 20){
                q.push(i);
                visited[i] = 1;
            }
        }
    }
    return -1;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    
    while(t--){
        cin >> n;
        
        amenity.clear();
        
        
        for(int i = 0; i< n+2;i++){
            int a,b;
            cin >> a >> b;
            amenity.push_back({a,b});
        }
        if(bfs(0) == 1){
            cout<< "happy\n";
        }
        else{
            cout<<"sad\n";
        }
    }
}
