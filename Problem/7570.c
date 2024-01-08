#include <bits/stdc++.h>

using namespace std;

int n;
vector<int> v;
int dp[1000001];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i = 0; i<n;i++){
        int num;
        cin >> num;
        v.push_back(num);
    }
    int m = 0;
    for(int i = 0 ; i <n;i++){
        int j = v[i];
        dp[j] = dp[j-1] +1;
        m = max(m, dp[j]);
    }
    cout<< n-m;
}
