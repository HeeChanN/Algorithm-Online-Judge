#include <bits/stdc++.h>
using namespace std;

int dp[100002][5];

int go(int num, int col, vector<vector<int>> land){
    if(num == land.size()){
        return 0;
    }
    int &ret = dp[num][col];
    if(ret != 0){
        return ret;
    }
    for(int i = 0 ; i<4; i++){
        if(col != i){
            ret = max(ret,go(num + 1, i, land));
        }
    }
    ret = ret + land[num][col];
    return ret;
}

int solution(vector<vector<int> > land)
{
    int answer = 0;
    memset(dp, 0, sizeof(dp));
    for(int i =0;i<4;i++){
        answer = max(answer, go(0,i,land));
    }
    return answer;
}
