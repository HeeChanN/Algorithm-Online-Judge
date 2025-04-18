#include<bits/stdc++.h>

using namespace std;

int dp[1004];
int tmp[1004];
int n,m,h;
int num;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m >>h;
    cin.ignore();
    dp[0] = 1;

    for(int i=0;i<n;i++){
        string str;
        getline(cin, str); 
        istringstream iss(str);
        
        vector<int> v;
        while(iss >> num){
            v.push_back(num);
        }
        memset(tmp,0,sizeof(tmp));
        for(int j =0;j<v.size();j++){
            int block = v[j];
            for(int k=block;k<=h;k++){
                tmp[k] = tmp[k] + dp[k-block];
            }
        }
        // for(int j = 1;j<=h;j++){
        //     cout<<tmp[j]<<" ";
        // }
        // cout<<"\n";
        for(int j = 1;j<=h;j++){
            dp[j] = (dp[j]+tmp[j])%10007;
        }
    }
    cout<<dp[h];
}
