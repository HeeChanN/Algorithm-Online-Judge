#include<bits/stdc++.h>

using namespace std;

int n , c;
vector<int> v;
int ret = 1;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> c;
    for(int i =0;i<n;i++){
        int num;
        cin>>num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());
    
    int start = 0;
    int end = v[n-1];
    
    while(start <= end){
        int mid = (start + end) / 2;
        
        int cnt = 1;
        int value = v[0];
        
        for(int i = 1; i <n; i++){
            if(v[i] - value>=mid){
                cnt++;
                value = v[i];
            }
        }
        if(cnt < c){
            end = mid - 1;
        }
        else{
            start = mid + 1;
            ret = max(ret, mid);
        }
    }
    cout<<ret;
}
