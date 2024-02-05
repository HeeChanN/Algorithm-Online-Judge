#include <bits/stdc++.h>

using namespace std;

int arr[10004];
vector<int> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n,k;
    
    cin >> n >> k;
    
    for(int i = 0; i<n;i++){
        cin>> arr[i];
    }
    
    sort(&arr[0],&arr[n]);
    
    for(int i = 1 ; i<n;i++){
        v.push_back(arr[i]-arr[i-1]);
    }
    sort(v.begin(), v.end());
    
    int ret = 0;
    for(int i = 0; i<n-k;i++){
        ret = ret + v[i];
    }
    cout<< ret;
    
}
