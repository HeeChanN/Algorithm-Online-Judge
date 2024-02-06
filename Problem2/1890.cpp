#include <bits/stdc++.h>

using namespace std;

int n;
int arr[102][102];
long long dp[102][102];

long long go(int y, int x){
    if(y >= n || x >= n){
        return 0;
    }
    if(arr[y][x] == 0){
        if(y == n-1 && x == n-1){
            return 1;
        }
        else
            return 0;
    }
    long long &ret = dp[y][x];
    if(ret != -1){
        return ret;
    }
    long long right = go(y, x + arr[y][x]);
    long long down = go(y + arr[y][x], x);
    ret = right + down;
    
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i<n;i++){
        for(int j = 0; j < n;j++){
            cin >> arr[i][j];
        }
    }
    memset(dp, -1, sizeof(dp));
    cout<<go(0,0);
}
