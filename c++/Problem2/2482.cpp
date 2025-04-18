#include <bits/stdc++.h>

using namespace std;

int n,k;
int dp[1004][1004][2];

int go(int num, int cnt,int pick){
    
    if(cnt == k){
        return 1;
    }
    if(num >= n){
        return 0;
    }
    int &ret = dp[num][cnt][pick];
    if(ret !=-1){
        return ret;
    }
    int comb, no;
    if(num == n-1 && pick == 1){
        comb = 0;
        no = 0;
    }
    else{
        comb = go(num+2, cnt+1 ,pick);
        no = go(num + 1, cnt,pick);
    }
    ret = (comb + no) % 1000000003;
    return ret;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    cin >> k;
    memset(dp, -1, sizeof(dp));
    int a = go(2,1,1);

    int b =go(1,0,0);
    
    cout << (a + b)%1000000003;
}
