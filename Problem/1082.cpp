#include <bits/stdc++.h>

using namespace std;

vector<pair<int,int>> info;
vector<pair<int,int>> v;
int n,num;
int money;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    for(int i = 0; i<n;i++){
        cin >> num;
        info.push_back({num,i});
    }
    cin >> money;
    
    sort(info.begin(), info.end());
    int cost = money;
    if(n == 1){
        cout<<"0";
        return 0;
    }
    if(info[0].second == 0 ){
        v.push_back({info[1].second,info[1].first});
        int m = cost - info[1].first;
        if(m < 0){
            cout<<"0";
            return 0;
        }
        int cnt = m / info[0].first;;
        for(int i = 0; i<cnt;i++){
            v.push_back({info[0].second,info[0].first});
        }
        cost = m - (cnt *info[0].first);
    }
    else{
        int cnt = cost / info[0].first;
        for(int j = 0; j<cnt;j++){
            v.push_back({info[0].second,info[0].first});
        }
        cost = cost - (info[0].first * cnt);
    }
    
    for(int i = 0; i<v.size();i++){
        int p = v[i].second + cost;
        int tmp = 0;
        
        for(int j = info.size()-1;j>=0;j--){
            if(p >= info[j].first && v[i].first < info[j].second){
                tmp = info[j].first - v[i].second;
                v[i].first =info[j].second;
            }
        }
        cost =cost - tmp;;
    }
    for(int i = 0;i<v.size();i++){
        cout<<v[i].first;
    }
}
