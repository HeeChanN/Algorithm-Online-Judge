#include <bits/stdc++.h>

using namespace std;

int board[24][24];
int dy[] = {0,0,-1,1};
int dx[] = {1,-1,0,0};
int n,m,x,y,k;
int c;
int dice[6];

//0,2,4,5 
void move_south(){
    int tmp = dice[5];
    dice[5] = dice[4];
    dice[4] = dice[2];
    dice[2] = dice[0];
    dice[0] = tmp;
}

void move_north(){
    int tmp = dice[5];
    dice[5] = dice[0];
    dice[0] = dice[2];
    dice[2] = dice[4];
    dice[4] = tmp;
}
// 1,2,3,5
void move_east(){ //2->1
    int tmp = dice[5];
    dice[5] = dice[1];
    dice[1] = dice[2];
    dice[2] = dice[3];
    dice[3] = tmp;
}

void move_west(){ //1->2
    int tmp = dice[5];
    dice[5] = dice[3];
    dice[3] = dice[2];
    dice[2] = dice[1];
    dice[1] = tmp;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>n>>m>>y>>x>>k;
    
    for(int i = 0;i<n;i++){
        for(int j=0;j<m;j++){
            cin>>board[i][j];
        }
    }
    
    for(int i =0;i<k;i++){
        cin >> c;
        int ny = y + dy[c-1];
        int nx = x + dx[c-1];
        if(ny<0 || nx <0 || ny >= n || nx >=m){
            continue;
        }
        if(c == 1){
            move_east();
        }
        else if (c == 2){
            move_west();
        }
        else if (c == 3){
            move_north();
        }
        else if (c == 4){
            move_south();
        }
        cout<<dice[2]<<"\n";
        y = ny;
        x = nx;
        
        if(board[y][x] == 0){
            board[y][x] = dice[5];
        }
        else{
            dice[5] = board[y][x];
            board[y][x] = 0;
        }
    }
    
}
