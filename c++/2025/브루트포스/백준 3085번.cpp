#include<bits/stdc++.h>

using namespace std;

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int n,ret;
string board[54];

void countRowCandy(int y){
    char ch = board[y][0];
    int cnt = 1;
    for(int i = 1;i<n;i++){
        if(ch == board[y][i]){
            cnt++;
            ret = max(ret,cnt);
        }
        else{
            ch = board[y][i];
            cnt = 1;
        }
    }
}

void countColCandy(int x){
    char ch = board[0][x];
    int cnt = 1;
    for(int i = 1;i<n;i++){
        if(ch == board[i][x]){
            cnt++;
            ret = max(ret,cnt);
        }
        else{
            ch = board[i][x];
            cnt = 1;
        }
    }
}


void go(int y,int x){
    for(int i = 0; i<4;i++){
        int ny = dy[i] + y;
        int nx = dx[i] + x;
        if(ny <0 || nx < 0 || ny >=n || nx >=n || board[y][x] == board[ny][nx]){
            continue;
        }
        char tmp = board[y][x];
        board[y][x] = board[ny][nx];
        board[ny][nx] = tmp;
        countRowCandy(y);
        countColCandy(x);
        
        tmp = board[y][x];
        board[y][x] = board[ny][nx];
        board[ny][nx] = tmp;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i = 0;i<n;i++){
        cin >> board[i];
    }
    for(int i = 0; i<n;i++){
        countRowCandy(i);
        countColCandy(i);
    }
    for(int i = 0; i <n;i++){
        for (int j =0;j<n;j++){
            go(i,j);
        }
    }
    cout << ret;
}
