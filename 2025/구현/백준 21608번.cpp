#include<bits/stdc++.h>

using namespace std;

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int board[24][24];
int n;
int id;
int p[4];
int student[404][4];
int y,x,blank,f;
int ret;

void find_proper_area(int i, int j){
    int cnt = 0;
    int fcnt = 0;
    for(int k = 0;k<4;k++){
        int ny = i + dy[k];
        int nx = j + dx[k];
        if(ny < 0 || nx < 0 || ny >=n || nx >= n){
            continue;
        }
        if(board[ny][nx] ==0){
            cnt ++;
        }
        else{
            for(int l = 0; l<4;l++){
                if(p[l] == board[ny][nx]){
                    fcnt++;
                    break;
                }
            }
        }
    }
    
    if(fcnt > f){
        blank = cnt;
        y = i;
        x = j;
        f = fcnt;
    }
    else if(fcnt == f && blank < cnt){
        blank = cnt;
        y = i;
        x = j;
    }
    else if (fcnt == f && blank == cnt){
        if(i < y){
            y = i;
            x = j;
        }
        else if (i == y && j < x){
            y = i;
            x = j;
        }
    }

}

void travel_board(){
    y = 21;
    x = 21;
    blank = -1;
    f = 0;
    int flag = 0;
    
    for(int i = 0; i<n;i++){
        for(int j = 0;j<n;j++){
            if(board[i][j] == 0){
               find_proper_area(i,j);
            }
        }
    }
    board[y][x] =id;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i =0 ; i<n * n;i++){
        cin >> id >> p[0] >> p[1] >> p[2] >> p[3];
        student[id][0] = p[0];
        student[id][1] = p[1];
        student[id][2] = p[2];
        student[id][3] = p[3];
        travel_board();
    }
    
    
    for(int i = 0; i<n;i++){
        for(int j = 0;j<n;j++){
            int good = 0;
            int pid = board[i][j];
            for(int k=0;k<4;k++){
                int ny = i + dy[k];
                int nx = j + dx[k];
                if(ny < 0 || nx < 0 || ny >=n || nx >= n){
                    continue;
                }
                for(int l = 0; l<4;l++){
                    if(board[ny][nx] == student[pid][l]){
                        good++;
                        break;
                    }
                }
            }
            if (good == 4){
                ret += 1000;
            }
            else if (good == 3){
                ret += 100;
            }
            else if (good == 2){
                ret += 10;
            }
            else if (good == 1){
                ret++;
            }
        }
    }
    cout << ret;
}
