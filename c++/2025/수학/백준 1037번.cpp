#include<bits/stdc++.h>

using namespace std;

int n,tmp;
vector<int> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i<n;i++){
        cin >> tmp;
        v.push_back(tmp);
    }
    
    sort(v.begin(), v.end());
    
    cout<< v[0] * v[n-1];
}
