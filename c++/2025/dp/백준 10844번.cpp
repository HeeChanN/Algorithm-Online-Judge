#include<bits/stdc++.h>

using namespace std;

long long n;
long long dp[104][10];

long long go(int pos, int idx){
    if(idx < 0 || idx > 9){
        return 0;
    }
    if(pos == n){
        return 1;
    }
    long long &ret = dp[pos][idx];
    if(ret != -1){
        return ret;
    }
    long long a = go(pos+1, idx + 1);
    long long b = go(pos+1, idx-1);
    ret = (a + b)%1000000000;
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin>> n;
    memset(dp, -1, sizeof(dp));
    long long s = 0;
    for(int i = 1;i<=9;i++){
        s = s + go(1,i);
    }
    cout << s%1000000000;
}
