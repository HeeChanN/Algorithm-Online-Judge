#include <bits/stdc++.h>

using namespace std;

int n;
int arr[102][102];
int visited[102][102];

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

void go(int i,int j){
    visited[i][j] = 1;
    queue<pair<int,int>> q;
    q.push({i,j});
    while(q.size()){
        int y = q.front().first;
        int x =q.front().second;
        q.pop();
        for(int i = 0; i<4;i++){
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(ny < 0 || nx < 0 || ny >= n || nx >=n )
                continue;
            if(visited[ny][nx] > visited[y][x] + arr[ny][nx]){
                visited[ny][nx] = visited[y][x] + arr[ny][nx];
                q.push({ny,nx});
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    
    
    for (int i =1; i<=t;i++){
        cin >> n;
        fill(&visited[0][0], &visited[101][102],  987654321);
        
        for(int j = 0; j<n;j++){
            string str;
            cin>>str;
            for(int k=0;k<str.size();k++){
                arr[j][k] = str[k] - '0';
            }
        }
        
        go(0,0);
        cout<<"#"<<i<<" "<<visited[n-1][n-1] - 1<<"\n";
    }
    
}
