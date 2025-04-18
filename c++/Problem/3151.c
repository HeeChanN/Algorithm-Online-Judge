#include <bits/stdc++.h>

using namespace std;

int n;

long long cnt;


vector<int> arr;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>n;
    
    for(int i =0;i<n;i++){
        int num;
        cin>> num;
        arr.push_back(num);
    }
    
    sort(arr.begin(), arr.end());
    
    for(int i =0;i<n;i++){
        for(int j =i+1;j<n;j++){
            int num = arr[i] + arr[j];
            int pos = lower_bound(arr.begin() + j + 1, arr.end(),-num) - (arr.begin() +j + 1);
            int lim = upper_bound(arr.begin() + j + 1,arr.end(),-num) - (arr.begin() + j + 1);
        
            cnt = cnt + lim - pos;
        }
    }
    
    cout<<cnt;
}
