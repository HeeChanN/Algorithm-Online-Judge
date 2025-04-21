#include<bits/stdc++.h>

using namespace std;

int a,b,s,target;

int w[34];
int dp[60004];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> a;
    for(int i =0;i<a;i++){
        cin>>w[i];
        s=s+w[i];
    }
    dp[0] = 1;
    
    for(int i=0;i<a;i++){
        int num = w[i];
        for(int j = s;j>=num;j--){
            if(dp[j-num] != 0){
                dp[j] = 1;
            }
        }
    }
    cin >> b;
    for(int i = 0; i<b;i++){
        int flag = 0;
        cin >> target;
        if(dp[target] !=0){
            cout << "Y ";
            continue;
        }
        for(int j=1;j<=s;j++){
            if(dp[j] != 0){
                if(dp[j+target] != 0){
                    cout<<"Y ";
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 0){
            cout<<"N ";
        }
    }
}