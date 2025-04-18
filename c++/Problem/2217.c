#include<bits/stdc++.h>

using namespace std;

int n;
int rope[100001];
int ret,cnt;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0;i<n;i++){
        cin>>rope[i];
    }
    
    sort(rope, rope + n, greater<int>());
    ret = rope[0];
    cnt = 1;
    for(int i = 1;i<n;i++){
        cnt++;
        if (rope[i]*cnt > ret){
            ret = rope[i] * cnt;
        }
    }
    cout<<ret;
    
}
