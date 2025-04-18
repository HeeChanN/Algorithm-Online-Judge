#include <bits/stdc++.h>

using namespace std;

pair<int,int> S;
pair<int,int> E;
pair<int,int> L;
int visited[104][104];


int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};


int go(int i, int j, int flag, vector<string> maps){
    visited[i][j] = 1;
    queue<pair<int,int>> q;
    q.push({i,j});
    while(q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for(int i = 0;i<4;i++){
            int ny = y  + dy[i];
            int nx = x + dx[i];
            if(ny <0 || nx <0 || ny >= maps.size() || nx >=maps[0].size() || maps[ny][nx] == 'X'){
                continue;
            }
            if(visited[ny][nx] == 0){
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny,nx});
            }
        } 
    }
    if(visited[L.first][L.second] == 0 && flag == 0){
        return -1;
    }
    else if(visited[E.first][E.second] == 0 && flag == 1){
        return -1;
    }
    
    if(flag == 0)
        return visited[L.first][L.second];
    else{
        return visited[E.first][E.second];
    }
}

int solution(vector<string> maps) {
    int answer = 0;
    
    
    for(int i = 0 ;i<maps.size(); i++){
        for(int j = 0; j <maps[i].size();j++){
            if(maps[i][j] == 'S')
                S = {i,j};
            if (maps[i][j] == 'E')
                E = {i,j};
            if (maps[i][j] == 'L')
                L = {i,j};
        }
    }
    
    int middle = go(S.first, S.second, 0,maps);
    if(middle == -1){
        answer = -1;
        return answer;
    }
    
    memset(visited,  0, sizeof(visited));
    
    int ret = go(L.first, L.second, 1,maps);
    if(ret == -1){
        answer = -1;
        return answer;
    }
    
    
    answer = middle + ret -2;
    return answer;
}