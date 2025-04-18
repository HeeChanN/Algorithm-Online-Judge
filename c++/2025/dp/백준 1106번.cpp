#include<bits/stdc++.h>

using namespace std;

int c,n;
int dp[1200];
int cost, human;
int ret = INT_MAX;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> c >> n;
    fill(&dp[0], &dp[1200],987654321);
    dp[0] = 0;
    for(int i =0 ;i<n;i++){
        cin >> cost >> human;
        // cout << i<<"\n";
        for(int j = human;j<=1100;j++){
            dp[j] = min(dp[j], dp[j-human]+cost);
            if(j >= c){
                ret = min(ret, dp[j]);
            }
        }
    }
    cout<<ret;
}
