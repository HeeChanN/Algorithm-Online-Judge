#include<bits/stdc++.h>

using namespace std;

int n,m;
int s;
vector<int> v(10004);

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i = 0;i<n;i++){
        cin>>v[i];
        s = s + v[i];
    }
    cin >> m;
    sort(v.begin(), v.begin() + n);
    if(s <= m){
        cout << v[n-1];
    }
    else{
        int l = 0;
        int r = v[n-1];
        while(l<=r){
            int mid = l + (r-l)/2;
            int cnt = 0;
            int ret = 0;
            for(int i = 0; i <n;i++){
                if(v[i] > mid){
                    break;
                }
                ret = ret + v[i];
                cnt++;
            }
            ret = ret + (n-cnt) * mid;
            if(ret <= m){
                s = mid;
                l = mid+1;
            }
            else{
                r = mid-1;
            }
        }
        cout<<s;
    }
}
