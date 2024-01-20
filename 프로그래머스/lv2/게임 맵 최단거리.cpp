#include <bits/stdc++.h>


using namespace std;

int visited[102][102];

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

void go(int i, int j, vector<vector<int>> maps){
    
    visited[i][j] = 1;
    queue<pair<int,int>> q;
    q.push({i,j});
    while(q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        
        for(int i = 0; i<4;i++){
            int ny = y +dy[i];
            int nx = x + dx[i];
            if(ny <0 || nx < 0 || ny >=maps.size() || nx >= maps[0].size() || maps[ny][nx] == 0){
                continue;
            }
            if(visited[ny][nx] == 0){
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny,nx});
            }
            else{
                visited[ny][nx] = min(visited[ny][nx], visited[y][x] + 1);
            }
        }
        
    }
}

int solution(vector<vector<int> > maps)
{
    int answer = 0;
    go(0,0,maps);
    
    int y = maps.size() -1;
    int x = maps[0].size() - 1;
    if(visited[y][x] == 0){
        answer = -1;
    }
    else{
        answer = visited[y][x];
    }
    
    return answer;
}
