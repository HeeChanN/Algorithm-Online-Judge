#include <bits/stdc++.h>

using namespace std;

int visited[102][102];

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int n,m;

void go(int i, int j, vector<string> board){
    visited[i][j] = 1;
    queue<pair<int,int>> q;
    q.push({i,j});
    
    while(q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        
        for(int i = 0 ; i<4;i++){
            int ny = dy[i] + y;
            int nx = dx[i] + x;
            while((ny>=0 && nx >=0) &&(ny < n && nx < m) && board[ny][nx] != 'D'){
                ny = dy[i] + ny;
                nx = dx[i] + nx;
            }
            ny = ny - dy[i];
            nx = nx - dx[i];
            if(visited[ny][nx] != 0){
                continue;
            }
            visited[ny][nx] = visited[y][x] + 1;
            q.push({ny,nx});
        }
    }
    
}

int solution(vector<string> board) {
    int answer = 0;
    pair<int,int> start;
    pair<int,int> finish;
    
    for(int i = 0; i<board.size();i++){
        for(int j = 0;j<board[i].size();j++){
            if(board[i][j]=='R'){
                start = {i,j};
            }
            else if (board[i][j]=='G'){
                finish = {i,j};
            }
        }
    }
    n = board.size();
    m = board[0].size();
    
    go(start.first, start.second,board);
    
    if(visited[finish.first][finish.second] == 0){
        answer = -1;
    }
    else{
        answer = visited[finish.first][finish.second] - 1;
    }
    
    return answer;
}
