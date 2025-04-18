#include<bits/stdc++.h>

using namespace std;

long long x,y,w,s;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    // w = 직진, s = 대각선
    cin >> x >> y >> w >> s;
    
    long long num = min(x,y);
    x = x-num;
    y = y-num;
    long long sum = min(num*2*w, num*s);
    
    if(x == 0){
        if(y %2 == 1){
            sum = sum + w + (min(w,s) *(y-1));
        }
        else{
            sum = sum + (min(w,s) * y);
        }
    }
    else{
        if(x %2 == 1){
            sum = sum + w + (min(w,s) *(x-1));
        }
        else{
            sum = sum + (min(w,s) * x);
        }
    }
    cout <<sum;
}
