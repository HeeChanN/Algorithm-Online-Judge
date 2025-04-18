#include<bits/stdc++.h>

using namespace std;

int arr[2004][2004];
bool visited[2004][2004];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
int cnt=0;
int n,m;

int change_direction(int item, int idx){
    if(item == 1 && (idx == 1 || idx == 3)){
        return (idx+2)%4;
    }
    else if(item == 2 &&(idx == 0 || idx == 2)){
        return (idx+2)%4;
    }
    else if(item == 3){
        if(idx == 0) return 1;
        if(idx == 1) return 0;
        if(idx == 2) return 3;
        if(idx == 3) return 2;
    }
    else if(item == 4){
        if(idx == 0) return 3;
        if(idx == 1) return 2;
        if(idx == 2) return 1;
        if(idx == 3) return 0;
    }
    return idx;
}

void check(int y,int x){
    queue<pair<int,int>> q;
    visited[y][x] = true;
    
    for(int i = 0; i<4;i++){
        q.push({y,x});
        int idx = i;
        while(q.size()){
            int py = q.front().first + dy[idx];
            int px = q.front().second + dx[idx];
            q.pop();
            if(py < 0 || px < 0 || py >=n || px >=m 
            || arr[py][px] == 9){
                continue;
            }
            q.push({py,px});
            visited[py][px] = true;
            if(1 <= arr[py][px] && arr[py][px] <= 4){
                idx = change_direction(arr[py][px], idx);
            }
        }
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    
    for(int i = 0; i<n;i++){
        for(int j = 0; j<m;j++){
            cin >> arr[i][j];
        }
    }
    
    for(int i = 0; i<n;i++){
        for(int j = 0; j<m;j++){
            if(arr[i][j] == 9){
                check(i,j);
            }
        }
    }
    for(int i = 0; i<n;i++){
        for(int j = 0; j<m;j++){
            if(visited[i][j] == true){
                cnt++;
            }
        }
    }
    cout<<cnt;
}
