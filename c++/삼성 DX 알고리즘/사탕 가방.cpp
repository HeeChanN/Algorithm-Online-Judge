#include <bits/stdc++.h>

using namespace std;

int t;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    for(int i = 1; i <= t; i++){
        int n;
        long long m;
        vector<long long> v;
        long long max_value = 0;
        long long ret = 0;
        
        cin >>n >> m;
        for(int j = 0; j<n;j++){
            long long num;
            cin >> num;
            max_value = max(num, max_value);
            v.push_back(num);
        }
        
        long long l = 1;
        long long r = max_value;
        
        while(l <= r){
            long long mid = l + (r-l)/2;
            long long count=0;
            
            for(int i = 0;i<v.size();i++){
                count += v[i] / mid;
            }
            if (count < m){
                r = mid - 1;
            }
            else{
                ret = max(ret, mid);
                l = mid + 1;
            }
        }
        cout<< "#" <<i<<" "<< ret << "\n";
        
    }
}
