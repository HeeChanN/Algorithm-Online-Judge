#include <bits/stdc++.h>

using namespace std;

int k;
long long n;
long long ret;

vector<int> v;
long long num;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> k >> n;
    
    long long big = 0;
    
    for(int i =0;i<k;i++){
        cin >> num;
        v.push_back(num);
        big = max(big, num);
    }
    long long s = 1;
    long long e = big;
    while(s<=e){
        long long m = s + ((e-s) / 2);
        long long cnt = 0;
        for(int i = 0; i<v.size();i++){
            cnt += v[i] / m;
        }
        if(cnt <n){
            e = m-1;
        }
        else{
            s = m+1;
            ret = max(ret, m);
        }
    }
    cout<<ret<<"\n";
}
