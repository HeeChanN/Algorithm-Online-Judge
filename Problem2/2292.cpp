#include<bits/stdc++.h>

using namespace std;

long long n;

int main(){
    
    cin >> n;
    
    n = n - 1;
    long long cnt = 1;
    while(1){
        long long num = 3 * cnt * (cnt -1);
        if(num >= n){
            break;
        }
        cnt++;
    }
    cout<<cnt;
}
