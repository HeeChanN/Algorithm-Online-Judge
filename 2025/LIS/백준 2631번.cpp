#include<bits/stdc++.h>

using namespace std;

int n;
int num,len;
int lis[202];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i<n;i++){
        cin >> num;
        auto pos = lower_bound(lis,lis+len,num);
        if(*pos == 0){
            len++;
        }
        *pos = num;
    }
    cout<<n - len;
}
