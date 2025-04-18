#include<bits/stdc++.h>

using namespace std;

int n,num;
long long m;
long long sum;
int ret = 0;
vector<int> v;

bool comp(int a, int b){
    return a>b;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    
    for(int i = 0;i<n;i++){
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end(),comp);
    
    int l = 1; 
    int r = v[0];
    
    while(l<=r){
        int mid = l + (r-l)/2;
        sum = 0;
        for(int i =0 ;i<v.size();i++){
            sum = sum + max(0,v[i] - mid);
        }
        if(sum >= m){
            l = mid + 1;
            ret = max(ret, mid);
        }
        else if(sum < m){
            r = mid-1;
        }
    }
    cout<<ret;
}
