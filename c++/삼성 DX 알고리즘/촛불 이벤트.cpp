#include <bits/stdc++.h>

using namespace std;

int t;
long long num;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    for(int i = 1; i <=t; i ++){
        long long ret = -1;
        cin >> num;
        
        
        long long l = 0;
        long long r = 2000000000;
        while(l <= r){
            long long mid = l + (r-l)/2;
            long long tmp;
            if(mid%2 == 1){
                tmp = (mid + 1) / 2;
                tmp = tmp * mid;
            }
            else{
                tmp = mid / 2;
                tmp = tmp * (mid + 1);
            }
            if(tmp < num){
                l = mid + 1;
            }
            else{
                if (tmp == num){
                    ret = mid;
                    break;
                }
                r = mid - 1;
            }
        }
        cout<<"#"<<i <<" "<<ret<<"\n";
    }
    
    return 0;
}
