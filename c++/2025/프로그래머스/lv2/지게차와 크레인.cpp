#include<bits/stdc++.h>

using namespace std;

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

char arr[54][54];
int visited[54][54];

// n은 세로, m은 가로
int n,m;

void bfs(int y,int x, char ch){
    queue<pair<int,int>> q;
    visited[y][x] = 1;
    q.push({y,x});
    while(q.size()){
        y = q.front().first;
        x = q.front().second;
        q.pop();
        for(int i = 0;i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny <0  || nx <0 || ny >= n+2 || nx >= m+2){
                continue;
            }
            if(visited[ny][nx] == 0 && arr[ny][nx] == '.'){
                visited[ny][nx] = 1;
                q.push({ny,nx});
            }
            if(arr[ny][nx] == ch){
                arr[ny][nx] ='.';
                visited[ny][nx] = 1;
            }
        }
    }
}

int solution(vector<string> storage, vector<string> requests) {
    int answer = 0;
    
    n = storage.size();
    m = storage[0].size();
    memset(arr,'.',sizeof(arr));
    for(int i = 0;i<storage.size();i++){
        for(int j = 0;j<storage[i].size();j++){
            arr[i+1][j+1] = storage[i][j];
        }
    }
    
    for(int i = 0; i<requests.size();i++){
        char ch = requests[i][0];
        if(requests[i].size() == 2){
            
            for(int k = 1;k<=n;k++){
                for(int j =1;j<=m;j++){
                    if(arr[k][j] == ch){
                        arr[k][j] = '.';
                    }
                }
            }
        }
        else{
            memset(visited,0,sizeof(visited));
            bfs(0,0, ch);
        }
    }
    for(int i = 1;i<=n;i++){
        for(int j =1;j<=m;j++){
            if(arr[i][j] >='A' && arr[i][j] <= 'Z'){
                answer++;
            }
        }
    }
    
    return answer;
}
