#include<bits/stdc++.h>

using namespace std;

long long n,k;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> k;
    
    long long s = 0;
    long long idx = 1;
    long long num = 9;
    while(k > (num * idx)){
        k = k - (num*idx);
        s = s + num;
        num = num * 10;
        idx++;
    }
    long long ret = (s+1) + (k-1) / idx;
    if(ret> n){
        cout<<"-1";
    }
    else{
        string str = to_string(ret);
        cout<<str[(k-1)%idx];
    }
    
}
