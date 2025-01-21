// Online C++ compiler to run C++ program online
#include <bits/stdc++.h>

using namespace std;

int dy[] = {-2,-2,-1,1,2,2,1,-1};
int dx[] = {-1,1,2,2,1,-1,-2,-2};

int t,n;
int visited[301][301];
pair<int,int> start;
pair<int,int> finish;

void bfs(){
    queue<pair<int,int>> q;
    q.push({start.second,start.first});
    
    while(q.size()){
        int py = q.front().first;
        int px = q.front().second;
        q.pop();
        
        for(int i = 0; i <8;i++){
            int ny = py + dy[i];
            int nx = px + dx[i];
            if(ny >= n || nx >= n || ny <0 || nx < 0 || visited[ny][nx] != 0){
                continue;
            }
            visited[ny][nx] = visited[py][px] + 1;
            q.push({ny,nx});
         }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    while(t--){
        cin >> n; // 판 크기
        cin >> start.first >> start.second;
        cin >> finish.first >> finish.second;
        memset(visited, 0, sizeof(visited));
        if(start.first == finish.first 
        && start.second == finish.second){
            cout<< "0\n";
        }
        else{
            bfs();
            cout << visited[finish.second][finish.first] << "\n";
        }
    }
    
}
