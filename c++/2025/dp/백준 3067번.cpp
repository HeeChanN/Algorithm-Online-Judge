#include<bits/stdc++.h>

using namespace std;

int t;
int n,m,num;
int dp[10004];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    
    while(t--){
        cin >> n;
        vector<int> v;
        for(int i = 0; i<n;i++){
            cin >> num;
            v.push_back(num);
        }
        cin >> m;
        memset(dp,0,sizeof(dp));
        dp[0] = 1;
        for(int i = 0;i<n;i++){
            int num = v[i];
            for(int j = num; j<=m;j++){
                dp[j] = dp[j] + dp[j-num];
            }
        }
        cout<<dp[m]<<"\n";
    }
}
