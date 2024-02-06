#include <bits/stdc++.h>

using namespace std;

int n,m;

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

int arr[502][502];
int dp[502][502];

int go(int y, int x){
    if(y == m - 1 && x == n - 1){
        return 1;
    }
    int &ret = dp[y][x];
    if(ret != -1){
        return ret;
    }
    
    int sum = 0;
    for(int i = 0; i<4;i++){
        int ny = dy[i] + y;
        int nx = dx[i] + x;
        if(ny < 0 || nx < 0 || ny >= m || nx >= n || arr[ny][nx] >= arr[y][x]){
            continue;
        }
        sum = sum + go(ny, nx);
    }
    ret = sum;
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    // m : 세로 , n : 가로
    cin >> m >> n;

    for(int i = 0; i<m;i++){
        for(int j = 0; j<n;j++){
            cin>>arr[i][j];
        }
    }
    
    memset(dp, -1, sizeof(dp));
    cout << go(0,0);
}
