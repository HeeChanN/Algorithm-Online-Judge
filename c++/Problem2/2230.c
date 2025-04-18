#include <bits/stdc++.h>

using namespace std;

int n,m;
vector<int> v;
int ret = 2000000000;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    
    cin>>n>>m;
    for(int i = 0;i<n; i++){
        int num;
        cin>>num;
        v.push_back(num);
    }
    
    sort(v.begin(), v.end());
    
    int i = 0;
    int j = 0;
    
    if(m == 0){
        cout<<"0";
        return 0;
    }
    
    while(j < v.size()){
        if(abs(v[i] - v[j]) < m){
            j++;
        }
        else{
            int tmp = abs(v[i]- v[j]);
            ret = min(ret, tmp);
            i++;
        }
    }
    cout<<ret;
    
    
    
}
