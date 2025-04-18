#include <bits/stdc++.h>

using namespace std;

vector<long long> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n,m;
    cin >> n>>m;
    for(int i = 0; i<n;i++){
        long long num;
        cin>>num;
        v.push_back(num);
    }
    
    for(int i = 0;i<m;i++){
        sort(v.begin(), v.end());
        long long tmp = v[0] + v[1];
        v[0] = tmp;
        v[1] =tmp;
    }
    long long sum = 0;
    for(int i = 0; i < n;i++){
        sum = sum + v[i];
    }
    cout<<sum;
}
