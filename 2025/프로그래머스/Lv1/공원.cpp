#include<bits/stdc++.h>

using namespace std;

int visited[80][80];
int dy[] ={-1,0,1,0};
int dx[] = {0,1,0,-1};
int lx,ly;


int bfs(vector<int> mats,vector<vector<string>> park,int y,int x){
    int ret = -1;
    
    for(int i = 0; i < mats.size();i++){
        memset(visited, 0, sizeof(visited));
        int my = y + mats[i];
        int mx = x + mats[i];
        if(my > ly || mx > lx){
            return ret;
        }
        queue<pair<int,int>> q;
        q.push({y,x});
        visited[y][x] = 1;
        while(q.size()){
            int py = q.front().first;
            int px = q.front().second;
            q.pop();
            for(int j = 0; j<4;j++){
                int ny = py + dy[j];
                int nx = px + dx[j];
                if(ny < y || nx < x || ny >=my || nx >= mx){
                    continue;
                }
                if(park[ny][nx].size() == 1){

                    return ret;
                }
                if(visited[ny][nx] == 0){
                    visited[ny][nx] = 1;
                    q.push({ny,nx});
                }
            }
        }
        ret = max(ret, mats[i]);
    }
    return ret;
}

int solution(vector<int> mats, vector<vector<string>> park) {
    int answer = -1;
    lx = park[0].size();
    ly = park.size();
    
    sort(mats.begin(), mats.end());
    
    for(int i = 0; i<park.size();i++){
        for(int j = 0; j<park[i].size();j++){
            if(park[i][j].length() == 2){
                answer = max(answer,bfs(mats,park,i,j));
            }
        }
    }
    
    return answer;
}
