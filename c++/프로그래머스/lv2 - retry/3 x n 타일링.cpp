#include<bits/stdc++.h>


using namespace std;

long long dp[5002];

int solution(int n) {
    int answer = 0;
    
    dp[0] = 1;
    dp[2] = 3;
    dp[4] = 11;
    for(int i = 6;i<=n;i = i+2){
        dp[i] = ((dp[i-2] * 4 % 1000000007) - (dp[i-4] % 1000000007) + 1000000007) % 1000000007;
    }
    
    answer= dp[n];
    
    return answer;
}
