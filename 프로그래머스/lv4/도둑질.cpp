#include <bits/stdc++.h>

using namespace std;

int dp[1000004][2];
vector<int> moneys;
int flag;

int go(int num){
    if(num >= moneys.size())
        return 0;
    if(num == moneys.size()-1 && flag == 1){
        return 0;
    }
    int &ret = dp[num][flag];
    if(ret != -1){
        return ret;
    }
    
    int pick = go(num+2)+moneys[num];
    int no = go(num+1);
    
    ret = max(pick,no);
    return ret;
    
    
}
int solution(vector<int> money) {
    int answer = 0;
    memset(dp, -1, sizeof(dp));
    moneys = money;
    
    flag = 1;
    int a =go(2) + money[0];
    flag = 0;
    int b =go(1);
    
    answer = max(a,b);
    
    return answer;
}