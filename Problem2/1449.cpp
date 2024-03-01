#include<bits/stdc++.h>

using namespace std;

int n,k;
int num;
vector<int> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> k;
    
    for(int i = 0;i<n;i++){
        cin>> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    
    int start = v[0];
    int cnt = 1;
    int ret = 1;
    for(int i = 1;i<v.size();i++){
        int dist = v[i] - start;
        if(dist + cnt > k){
            start = v[i];
            cnt = 1;
            ret++;
        }
    }
    cout<<ret;
}
