#include <bits/stdc++.h>

using namespace std;

vector<int> v;
int dp[302][2];
int n;

int go(int num,int cnt){
    if(cnt == 3){
        return 0;
    }
    if(num > n){
        return 0;
    }
    if(num == n){
        return v[num];
    }
    int &ret = dp[num][cnt];
    if(ret != 0){
        return ret;
    }
    int one = go(num + 1, cnt + 1);
    int two = go(num + 2, 1);
    ret = max(one, two);
    if (ret != 0){
        ret += v[num];
    }
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    v.push_back(0);
    for(int i = 0; i<n;i++){
        int num;
        cin>>num;
        v.push_back(num);
    }
    
    cout<<go(0,0)<<"\n";
}
