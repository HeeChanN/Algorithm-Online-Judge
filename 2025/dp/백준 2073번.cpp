#include<bits/stdc++.h>

using namespace std;

int d,p;
int l, c;
int num;
int dp[100004];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> d >> p;
    dp[0] =INT_MAX;
    for(int i = 0; i<p;i++){
        cin >> l >> c;
        
        for(int i = d; i>=l;i--){
            if(dp[i-l] != 0){
                num = min(dp[i-l], c);
                dp[i] = max(dp[i],num);
            }
        }
    }
    cout << dp[d];
}
