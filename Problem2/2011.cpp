#include<bits/stdc++.h>

using namespace std;

string s;

int n;
int dp[5002];

int go(int k){
    if(k == n-1 && s[k] == '0'){
        return 0;
    }
    if(k >= n-1){
        return 1;
    }
    if(s[k]=='0'){
        return 0;
    }
    int &ret = dp[k];
    if(ret != 0){
        return ret;
    }
    if(s[k] >= '3'){
        ret = go(k+1);
    }
    else{
        if(s[k+1] == '0'){
            ret = go(k+2);
        }
        else if(s[k]== '2' && s[k+1] > '6'){
            ret = go(k+1);
        }
        else{
            ret = go(k+1) + go(k+2);
        }
    }
    return ret%1000000;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>> s;
    n=s.length();
    if(n == 0){
        cout<<"0";
        return 0;
    }
    for(int i = 0; i<n;i++){
        if(s[i]=='0' && i !=0 ){
            if(s[i-1]>='3' || s[i-1] == '0'){
                cout<<"0";
                return 0;
            }
        }
    }
    if(s[0]=='0'){
        cout<<"0";
    }
    else{
        cout<<go(0);
    }
        
}