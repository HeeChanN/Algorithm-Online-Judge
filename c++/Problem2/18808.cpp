#include<bits/stdc++.h>

using namespace std;

int m,n,k;
int board[42][42];

int check(int starty, int startx, int y, int x,int arr[11][11]){
    int a = 0;
    int b = 0;
    for(int i = starty; i<starty+y;i++){
        b= 0;
        for(int j = startx;j<startx+x;j++){
            if(board[i][j] == 1 && arr[a][b] == 1){
                return 0;
            }
            b++;
        }
        a++;
    }
    return 1;
}

void fill_board(int starty, int startx, int y, int x,int arr[11][11]){
    int a = 0;
    int b = 0;
    for(int i = starty; i<starty+y;i++){
        b=0;
        for(int j = startx;j<startx+x;j++){
            if(arr[a][b]==1){
                board[i][j] = arr[a][b];
            }
            b++;
        }
        a++;
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> m >> n >> k;
    
    while(k--){
        int arr[11][11] = {0}; // 스티커
        int y, x;
        cin >> y >> x;
        
        for(int i = 0; i<y;i++){
            for(int j = 0;j<x;j++){
                cin>> arr[i][j];
            }
        }
        
        for(int k = 0;k<4;k++){
            
            int flag = 0;
            for(int i = 0; i<=m-y; i++){
                for(int j = 0;j<=n-x;j++){
                    // check arr
                    flag = check(i,j,y,x,arr);
                    if(flag == 1){
                        fill_board(i,j,y,x,arr);
                        break;
                    }
                }
                if(flag == 1){
                    break;
                }
            }
            
            if(flag == 1){
                break;
            }
            else{
                int tmp[11][11];
                for(int i = 0; i<y;i++){
                    for(int j = 0 ; j<x;j++){
                        tmp[j][i] = arr[y-i-1][j];
                    }
                }
                memmove(arr,tmp,sizeof(arr));
                int t = y;
                y = x;
                x = t;
                
            }
        }
    }
    int cnt = 0;
    for(int i = 0;i<m;i++){
        for(int j = 0 ;j<n;j++){
            if(board[i][j] == 1){
                cnt++;
            }
        }
    }
    cout<<cnt;
}
