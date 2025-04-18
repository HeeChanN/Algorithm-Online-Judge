#include <bits/stdc++.h>
#include <unordered_map>

using namespace std;

int n,m;
unordered_map<string, string> mp;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    
    for(int i = 0; i< n ; i++){
        string address, key;
        cin >> address >> key;
        mp[address] = key;
    }
    for(int i = 0; i < m; i++){
        string reqAddress;
        cin >> reqAddress;
        cout<<mp[reqAddress] << "\n";
    }
}
