#include<bits/stdc++.h>

using namespace std;

int ret[10004];
int n,m, sum;
int cost[104];
int mem[104];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>> n >> m;
    for(int i = 0; i<n;i++){
        cin>>mem[i];
    }
    for(int i = 0;i<n;i++){
        cin>>cost[i];
        sum +=cost[i];
    }
    memset(ret, -1, sizeof(ret));
    
    if(sum == 0){
        cout<<"0";
    }
    else{
        ret[0] = 0;
        for(int i = 0;i< n ;i++){ // each App
    
            for(int j = sum; j >= cost[i]; j--){
                int cur = j - cost[i];
                if(ret[cur] != -1){
                    ret[j] = max(ret[cur]+mem[i], ret[j]);
                }
            }
        }
        for(int i = 0; i <= sum;i++){
            if (ret[i]>=m){
                cout<<i;
                break;
            }
        }
    }
}
