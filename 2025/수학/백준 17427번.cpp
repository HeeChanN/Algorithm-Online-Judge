#include<bits/stdc++.h>

using namespace std;

long long n,ret;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 1; i<=n;i++){
        ret = ret + ((n / i) * i);
    }
    cout << ret;
}
