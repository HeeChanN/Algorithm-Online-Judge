#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int n,m;
int ret = -1;

// 0 빈칸, 1 벽, 2 바이러스 위치
int board[54][54];
int visited[54][54];
vector<pair<int,int>> virus;
vector<int> pick;


void bfs(){
    queue<pair<int,int>> q;
    for(int i = 0; i<pick.size();i++){
        pair<int,int> p = virus[pick[i]];
        visited[p.first][p.second] = 1;
        q.push(p);
    }
    while(q.size()){
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for(int i=0; i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >= n || board[ny][nx] == 1){
                continue;
            }
            if(visited[ny][nx] == 0){
                visited[ny][nx] = visited[y][x] + 1;
                q.push({ny,nx});
            }
        }
    }
    int a = 1;
    for(int i =0; i<n;i++){
        for(int j = 0; j<n;j++){
            if(board[i][j] == 0 && visited[i][j] == 0) {
                return;
            }
            if(board[i][j] == 0){
                a = max(a,visited[i][j]);
            }
        }
    }
    if(ret == -1){
        ret = a-1;
    }
    else{
        ret = min(ret,a-1);
    }
}

void comb(int x){
    if(pick.size() == m){
        memset(visited,0,sizeof(visited));
        bfs();
        return;
    }
    if(m - pick.size() > virus.size() - 1 - x){
        return;
    }
    for(int i = x+1;i<virus.size();i++){
        pick.push_back(i);
        comb(i);
        pick.pop_back();
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    for(int i = 0;i<n;i++){
        for(int j = 0;j<n;j++){
            cin >> board[i][j];
            if(board[i][j] == 2){
                virus.push_back({i,j});
            }
        }
    }
    comb(-1);
    cout<<ret;
}
