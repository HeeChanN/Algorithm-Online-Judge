#include <bits/stdc++.h>

using namespace std;

int visited[101][101];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};


int go(int i, int j, vector<string> maps){
    visited[i][j] = 1;
    queue<pair<int,int>> q;
    int sum = maps[i][j]-'0';
    
    q.push({i,j});
    while(q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        
        for(int k = 0;k<4;k++){
            int ny = y + dy[k];
            int nx = x + dx[k];
            
            if(ny <0 || nx <0 || ny >= maps.size() || nx >=maps[0].size() || maps[ny][nx] == 'X'){
                continue;
            }
            if(visited[ny][nx] == 0){
                sum = sum + maps[ny][nx]-'0';
                visited[ny][nx] = 1;
                q.push({ny,nx});
            }
            
        }
    }
    return sum;
}

vector<int> solution(vector<string> maps) {
    vector<int> answer;
    
    for(int i = 0; i< maps.size();i++){
        for(int j = 0;j<maps[i].size();j++){
            if(visited[i][j] == 0 && maps[i][j] != 'X'){
                answer.push_back(go(i,j,maps));
                
            }
        }
    }
    
    if(answer.size() == 0){
        answer.push_back(-1);
    }
    sort(answer.begin(), answer.end());
    
    return answer;
}
