#include<bits/stdc++.h>

using namespace std;

int chair[42];
int ban[42];
int dp[2][42];
int n,m,vip;



int go(int flag, int x){
    if(x==n+1){
        if(flag == 0)
            return 1;
        else
            return 0;
    }
    if(ban[x] == 1){
        if(flag == 0){
            return dp[flag][x] = go(0,x+1);
        }
        else{
            return 0;
        }
    }
    int &ret = dp[flag][x];
    if(ret != 0){
        return ret;
    }
    int sum = 0;
    if(flag == 1){
        sum = go(0,x+1);
    }
    else{
        for(int i = 0; i<2;i++){
            sum = sum + go(i,x+1);
        }
    }
    ret = sum;
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    cin >> m;
    for(int i = 0; i<m;i++){
        cin >> vip;
        ban[vip] = 1;
    }
    ban[0] = 1;
    ban[n+1] = 1;
    
    cout << go(0,1);
    
    
}
