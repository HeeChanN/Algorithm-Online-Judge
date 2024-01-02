#include <bits/stdc++.h>

using namespace std;

int n;
int arr[1000];
int ret = -1;
vector<int> v;

int find_num(int num){
    int pos = lower_bound(v.begin(), v.end(), num) - v.begin();
    int lim = upper_bound(v.begin(), v.end(), num) - v.begin();
    if(lim - pos == 0){
        return -1;
    }
    return pos;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
       
    cin>>n;
    for(int i =0;i<n;i++){
        cin>>arr[i];
    }
    
    int lim = 3;
    for(int i =0;i<n;i++){
        for(int j =i;j<n;j++){
            v.push_back(arr[i]+arr[j]);
        }
    }
    sort(arr,arr+n);
    sort(v.begin(),v.end());
    
    for(int i=n-1;i>=0;i--){
        for(int j = i;j >=0;j--){
            int num = arr[i] - arr[j];
            if(find_num(num) >= 0){
                cout<<arr[i]<<"\n";
                return 0;
            }
        }
    }
    
}
