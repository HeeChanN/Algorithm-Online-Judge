#include<bits/stdc++.h>

using namespace std;

int n,m;
int arr[304][304];
int arr2[304][304];
int visited[304][304];

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

void melt_ice(){
    for(int i =0;i<n;i++){
        for (int j = 0;j<m;j++){
            for(int k = 0; k<4;k++){
                int ny = i + dy[k];
                int nx = j + dx[k];
                if(ny<0||nx<0||ny>=n||nx>=m){
                    continue;
                }
                if(arr[ny][nx] ==0){
                    arr2[i][j] = max(0, arr2[i][j]-1);
                }
            }
        }
    }
    for(int i =0;i<n;i++){
        for (int j = 0;j<m;j++){
            arr[i][j] = arr2[i][j];
        }
    }
}

void go(int y, int x){
    visited[y][x] = 1;
    
    queue<pair<int,int>> q;
    q.push({y,x});
    while(q.size()){
        int py = q.front().first;
        int px = q.front().second;
        q.pop();
        
        for(int k = 0; k<4;k++){
            int ny = py + dy[k];
            int nx = px + dx[k];
            if(ny<0||nx<0||ny>=n||nx>=m){
                continue;
            }
            if(arr[ny][nx] >0 && visited[ny][nx] == 0){
                visited[ny][nx] = 1;
                q.push({ny,nx});
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    
    for(int i =0;i<n;i++){
        for(int j = 0;j<m;j++){
            cin>>arr[i][j];
            arr2[i][j] = arr[i][j];
        }
    }
    int cnt = 0;
    while(true){
        cnt++;
        melt_ice();
        
        
        memset(visited, 0, sizeof(visited));
        int flag = 0;
        
        for(int i =0;i<n;i++){
            for(int j =0;j<m;j++){
                if(visited[i][j] == 0 && arr[i][j] != 0){
                    go(i, j);
                    flag++;
                }
            }
        }
        if(flag == 0){
            cout<<"0";
            break;
        }
        else if (flag !=1){
            cout<< cnt;
            break;
        }
    }
    
    return 0;
}
