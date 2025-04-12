#include<bits/stdc++.h>

using namespace std;

int dy[] = {0,1};
int dx[] = {1,0};

int n;
int arr[1004][1004];
int dp[1004][1004][4];

int go (int y,int x, int t){
    if(y == n-1 && x == n-1){
        if((t+1)%3 == arr[y][x]){
            return 1;
        }
        else{
            return 0;
        }
    }
    int &ret = dp[y][x][t];
    if(ret != 0){
        return ret;
    }
    int tmp = 0;
    
    for(int i = 0; i<2;i++){
        int ny = dy[i] + y;
        int nx = dx[i] + x;
        if(ny >=n || nx >= n){
            continue;
        }
        if(arr[y][x] == (t+1)%3){
            tmp = max(tmp,go(ny,nx,arr[y][x]) + 1);
        }
        tmp = max(tmp,go(ny,nx,t));
    }
    
    ret = max(ret, tmp);
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>> n;
    for(int i = 0; i < n; i++){
        for(int j = 0;j<n;j++){
            cin >> arr[i][j];
        }
    }
    
    cout << go(0,0,2);
}
