#include<bits/stdc++.h>

using namespace std;

int t,num;
pair<long long ,long long> dp[41];


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    
    dp[0] = {1L,0L};
    dp[1] = {0L,1L};
    
    for(int i = 2 ; i <= 40;i++){
        dp[i].first = dp[i-1].first + dp[i-2].first;
        dp[i].second = dp[i-1].second + dp[i-2].second ;
    }
    
    for(int i =0; i <t;i++){
        cin >> num;
        cout << dp[num].first <<" " <<dp[num].second << "\n"; 
    }
}
