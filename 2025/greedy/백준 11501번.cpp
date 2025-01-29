#include<bits/stdc++.h>

using namespace std;

int n;
vector<long long> v;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int t;
    cin >> t;
    
    while(t--){
        cin >> n;
        
        for(int i = 0; i<n;i++){
            long long num;
            cin >> num;
            v.push_back(num);
        }
        long long line = v[n-1];
        long long sum = 0;
        
        
        for(int i = n-2 ;i>=0;i--){
            if(line > v[i]){
                sum = sum + line - v[i];
            }
            else{
                line = v[i];
            }
        }
        cout<<sum<<"\n";
        v.clear();
    }
}
