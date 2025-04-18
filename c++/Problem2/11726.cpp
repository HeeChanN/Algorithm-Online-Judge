#include<bits/stdc++.h>

using namespace std;

int n;

long long dp[1003];

long long go(int num){
    if(num == n || num == (n + 1)){
        return 1;
    }
    long long &ret = dp[num];
    if(ret != 0){
        return ret;
    }
    long long h = go (num + 1);
    long long w = go (num + 2);
    ret = (h + w)%10007;
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    cout<<go(1)%10007;
}
