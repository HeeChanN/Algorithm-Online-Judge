#include <bits/stdc++.h>

using namespace std;

int n,m;
int a,b;

vector<pair<int,int>> v;

bool comp(pair<int,int> a, pair<int,int> b){
    if (a.first == b.first){
        return a.second > b.second;
    }
    return a.first < b.first;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    
    for(int i = 0 ; i<n;i++){
        cin >> a>>b;
        v.push_back({b,a});
    }
    
    sort(v.begin(),v.end(),comp);
    long long ret = 2147483648;
    int w = v[0].second;
    int cost = v[0].first;
    int prev = v[0].first;;
    for(int i = 1;i<n;i++){
        if(v[i].first == prev){
            w = w + v[i].second;
            cost = cost + v[i].first;
        }
        else{
            prev = v[i].first;
            cost = v[i].first;
            w = w + v[i].second;
        }
        if(w >= m){
            ret = min((long long)cost,  ret);
        }
    }
    if(ret == 2147483648){
        cout<<-1;
    }
    else{
        cout<< ret;
    }
    return 0;
}
