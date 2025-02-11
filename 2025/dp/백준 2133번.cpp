#include<bits/stdc++.h>

using namespace std;

int n;
int dp[32];

int main(){
    ios_base::sync_with_stdio(false);
    cout.tie(NULL);
    cin.tie(NULL);
    
    dp[0] = 1;
    dp[2] = 3;
    
    for(int i = 4; i<=30;i = i+2){
        for(int j = 0; j<i-2;j=j+2){
            dp[i] = dp[i] + dp[j]*2;
        }
        dp[i] = dp[i] + dp[i-2] * dp[2];
    }
    
    
    cin >> n;
    cout<<dp[n];
    
}
