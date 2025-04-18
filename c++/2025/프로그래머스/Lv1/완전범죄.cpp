#include <bits/stdc++.h>

using namespace std;

int dp[44][130][130][2];
int ret1,ret2;
vector<vector<int>> v;
int an, bm;

int go(int idx, int a, int b, int pick){
    if(a>=an || b >= bm){
        return 987654321;
    }
    if(idx == v.size()-1){
        if(pick==0){
            return v[idx][0];
        }
        else{
            return 0;
        }
    }
    int &ret = dp[idx][a][b][pick];
    if(ret != -1){
        return ret;
    }
    int l = go(idx +1, a+v[idx+1][0],b,0);
    int r = go(idx+ 1, a, b+v[idx+1][1],1);
    ret = min(l,r);
    if(pick == 0){
        ret = ret + v[idx][0];
    }
    return ret;
}
    
int solution(vector<vector<int>> info, int n, int m) {
    int answer = 0;
    an = n;
    bm = m;
    
    v.push_back({0,0});
    v.insert(v.end(),info.begin(),info.end());
    
    memset(dp, -1, sizeof(dp));
    ret1 = go(1, info[0][0],0, 0);
    ret2 = go(1,0,info[0][1], 1);
    
    answer = min(ret1,ret2);
    if(answer >= 987654321){
        answer = -1;
    }
    
    return answer;
}
