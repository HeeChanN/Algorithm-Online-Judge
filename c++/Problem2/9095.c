#include <bits/stdc++.h>

using namespace std;

int dp[14];
int t;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    dp[1] = 1;
    dp[2] = 2;
    dp[3] = 4;

    for(int i = 4; i <=11; i++){
        dp[i] = dp[i-1] + dp[i-2] + dp[i-3];
    }
    cin>>t;
    while(t--){
        int num;
        cin>>num;
        cout<<dp[num]<<"\n";
    }
}