#include<bits/stdc++.h>

using namespace std;

long long n;
long long psum[1000004];
long long f[1000004];
int t,num;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    
    for (int i = 1; i <= 1000000; i++) {
        for (int j = i; j <= 1000000; j += i) {
            f[j] += i;
        }
    }
    for(int i = 1;i<=1000000;i++){
        psum[i] = psum[i-1] + f[i];
    }
    for(int i = 0;i<t;i++){
        cin >> num;
        cout << psum[num]<<"\n";
    }
}
