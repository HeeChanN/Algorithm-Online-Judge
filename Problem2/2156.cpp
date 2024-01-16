#include <bits/stdc++.h>

using namespace std;

int n;
vector<int> v;
int dp[10000][3];

int go(int num, int cnt){
    if(cnt == 3){
        return -987654321;
    }
    if(num == n){
        return 0;
    }
    int &ret = dp[num][cnt];
    if(ret != -1){
        return ret;
    }
    int pick = go(num +1, cnt + 1) + v[num+1];
    int no = go(num + 1, 0);
    ret = max(pick, no);
    return ret = max(ret, -1);
    
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    memset(dp, -1, sizeof(dp));
    
    v.push_back(0);
    
    for(int i = 0; i<n;i++){
        int num;
        cin >> num;
        v.push_back(num);
    }
    
    cout <<go(0,0);
    return 0;
    
}
