#include<bits/stdc++.h>

using namespace std;

int board[102][102];
int dp[102][102];
int M;
int N;

int go(int i, int j){
    if(i >= N || j >=M || board[i][j] == 1){
        return 0;
    }
    if(i == N-1 && j == M-1){
        return 1;
    }
    int &ret = dp[i][j];
    if(ret != 0){
        return ret;
    }
    int right = go(i,j+1);
    int down = go(i+1,j);
    ret =  (right + down) % 1000000007;
    return ret;
}

int solution(int m, int n, vector<vector<int>> puddles) {
    int answer = 0;
    for(int i = 0; i<puddles.size();i++){
        board[puddles[i][1] - 1][puddles[i][0] - 1] = 1;
    }
    M = m;
    N = n;
    answer = go(0,0);
    return answer;
}
