#include<bits/stdc++.h>

using namespace std;

int n;
long long dp[3][100004];

long long go(int back, int x){
    if(x == n){
        return 1;
    }
    long long &ret = dp[back][x];
    if(ret != 0){
        return ret;
    }
    
    for(int i = 0; i<3;i++){
        if(back == 0){
            ret = ret + go(i,x+1);
        }
        else if(back != i){
            ret = ret + go(i, x+1);
        }
    }
    ret = ret % 9901;
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    cout <<go(0,0);
}
