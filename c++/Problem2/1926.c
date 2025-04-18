#include<bits/stdc++.h>

using namespace std;

int n,m;
int arr[504][504];
int visited[504][504];
int ret;
int cnt;

int dy[]={-1,0,1,0};
int dx[]={0,1,0,-1};

int go(int y, int x){
    int num=1;
    queue<pair<int,int>> q;
    visited[y][x] = 1;
    q.push({y,x});
    
    while(q.size()){
        int py = q.front().first;
        int px = q.front().second;
        q.pop();
        for(int i=0;i<4;i++){
            int ny = py + dy[i];
            int nx = px + dx[i];
            if(ny>=n || ny <0 || nx >= m || nx < 0){
                continue;
            }
            if (visited[ny][nx] == 0 && arr[ny][nx]==1){
                q.push({ny,nx});
                visited[ny][nx] = 1;
                num++;
            }
        }
    }
    return num;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    for (int i =0;i<n;i++){
        for (int j = 0; j <m;j++){
            cin>>arr[i][j];
        }
    }
    
    for(int i = 0; i< n;i++){
        for (int j = 0;j<m;j++){
            if(visited[i][j] == 0 && arr[i][j] == 1){
                int tmp = go (i,j);
                cnt++;
                ret = max(ret, tmp);
            }
        }
    }
    cout<<cnt<<"\n"<<ret;
}
