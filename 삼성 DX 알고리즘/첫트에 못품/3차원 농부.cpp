#include <bits/stdc++.h>

using namespace std;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    for(int i = 1; i <= t; i++){
        int n,m;
        int c1,c2;
        
        vector<int> cow;
        int ret=INT_MAX;
        int cnt = 0;
        
        cin>>n>>m;
        cin>>c1>>c2;
        
        
        for(int i = 0; i<n;i++){
            int num;
            cin>>num;
            cow.push_back(num);
        }
        
        sort(cow.begin(),cow.end());
        
        for(int i = 0; i<m;i++){
            int num;
            cin>> num;
        
            int pos = lower_bound(cow.begin(), cow.end(), num) - cow.begin();
            if (0 <= pos && pos < n) {
                    int tmp = cow[pos];
                    int dz = abs(tmp - num);
                    if (ret > dz) {
                        ret = dz;
                        cnt = 1;
                    } else if (ret == dz) {
                        cnt++;
                    }
                }
                
            if (0 < pos && pos <= n) {
                int tmp = cow[pos - 1];
                int dz = abs(tmp - num);
                if (ret > dz) {
                    ret = dz;
                    cnt = 1;
                } else if (ret == dz) {
                    cnt++;
                }
                    
            }
            
        }
        cout<<"#"<<i<<" "<< (abs(c1 - c2) + ret)<<" "<< cnt <<"\n";
        
    }
}
