#include <bits/stdc++.h>

using namespace std;

int t,x,y;
int visited[1004][1004];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    while(t--){
        int flag = 0;
        
        vector<string> board;
        queue<pair<int,int>> person;
        queue<pair<int,int>> fire;
        memset(visited, 0, sizeof(visited));
        cin>> x >> y;
        for(int i = 0;i<y;i++){
            string str;
            cin>>str;
            board.push_back(str);
        }
        
        for(int i = 0;i<y;i++){
            for(int j = 0; j<x;j++){
                if(board[i][j] == '@'){
                    person.push({i,j});
                }
                else if (board[i][j] == '*'){
                    fire.push({i,j});
                }
            }
        }
        int ret = 0;
        while(true){
            queue<pair<int,int>> fire2;
            while(fire.size()){
                int fire_y = fire.front().first;
                int fire_x = fire.front().second;
                fire.pop();
                for(int i = 0; i<4;i++){
                    int fire_ny = fire_y + dy[i];
                    int fire_nx = fire_x + dx[i];
                    if(fire_ny < 0 || fire_nx < 0 || fire_ny >=y || fire_nx >= x || board[fire_ny][fire_nx] == '#' || board[fire_ny][fire_nx] == '*'){
                        continue;
                    }
                    board[fire_ny][fire_nx] = '*';
                    fire2.push({fire_ny,fire_nx});
                }
            }
            fire = fire2;
            queue<pair<int,int>> person2;
            while(person.size()){
                int py = person.front().first;
                int px = person.front().second;
                visited[py][px] = 1;
                person.pop();
                for(int i = 0; i<4;i++){
                    int ny = py + dy[i];
                    int nx = px + dx[i];
                    if(ny < 0 || nx < 0 || ny >=y || nx >= x)
                    {
                        flag = 1;
                        break;
                    }
                    if(visited[ny][nx] == 1 || board[ny][nx] == '#' || board[ny][nx] == '*'){
                        continue;
                    }
                    person2.push({ny,nx});
                    visited[ny][nx] = 1;
                }
                if(flag == 1){
                    break;
                }
            }
            
            ret++;
            person = person2;
            if(flag == 1){
                cout<<ret << "\n";
                break;
            }
            if(person.size() == 0){
                cout<<"IMPOSSIBLE\n";
                break;
            }
        }
        
    }
}
