#include<bits/stdc++.h>

using namespace std;

vector<int> adj[102];
pair<int,int> ban;
int visited[102];
int ret = 102;

int go(int num){
    int cnt = 1;
    visited[num] = 1;
    
    queue<int> q;
    q.push(num);
    
    while(q.size()){
        int p = q.front();
        q.pop();
        for(int next : adj[p]){
            if(ban.first == p && ban.second == next){
                continue;
            }
            else if (ban.first == next && ban.second == p){
                continue;
            }
            if(visited[next] == 0){
                q.push(next);
                visited[next] = 1;
                cnt++;
            }
        }
    }
    return cnt;
}

int solution(int n, vector<vector<int>> wires) {
    int answer = -1;
    
    for(int i = 0; i<wires.size(); i++){
        adj[wires[i][0]].push_back(wires[i][1]);
        adj[wires[i][1]].push_back(wires[i][0]);
    }
    
    for(int i = 0; i<wires.size();i++){
        ban = {wires[i][0], wires[i][1]};
        memset(visited, 0, sizeof(visited));
        int half = go(wires[i][0]);
        ret = min(ret, abs((n - half) - half));
    }
    answer = ret;
    return answer;
}
