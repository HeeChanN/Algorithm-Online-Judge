#include <bits/stdc++.h>

using namespace std;

int arr[1000001];
int len;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n;
    cin>> n;
    for(int i = 0; i<n;i++){
        int num;
        cin>> num;
        auto pos = lower_bound(arr, arr + len,num);
        if(*pos == 0){
            len++;
        }
        *pos = num;
    }
    cout<<len;
}
