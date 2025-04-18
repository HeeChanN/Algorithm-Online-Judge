#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;



int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    for(int i =  1; i<=t;i++){
        int n,m;
        int cnt = 0;
        cin >> n >> m;
        unordered_map<string, int> mp;
        
        for(int j = 0; j<n;j++){
            string s;
            cin>> s;
            if(mp[s] == 0){
                mp[s] =1;
            }
        }
        for(int j = 0 ; j<m;j++){
            string s;
            cin >> s;
            if(mp[s]==1){
                cnt++;
            }
        }
        cout<<"#"<<i<<" "<<cnt<<"\n";
    }
    
}
