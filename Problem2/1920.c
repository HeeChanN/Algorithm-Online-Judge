#include<bits/stdc++.h>

using namespace std;

int arr[100001];
int n;
int m;
int num;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i =0;i<n;i++){
        cin>>arr[i];
    }
    sort(arr, arr+n);
    
    cin >> m;
    while(m--){
        cin>>num;
        int pos = lower_bound(arr,arr+n,num) -arr;
        int next = upper_bound(arr,arr+n,num) - arr;
        if(next - pos == 0){
            cout<<"0"<<"\n";
        }
        else{
            cout<<"1"<<"\n";
        }
    }
}
