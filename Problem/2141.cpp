#include <bits/stdc++.h>

using namespace std;

vector<pair<int,int>> town;

bool comp(pair<int,int> a, pair<int,int> b){
    if(a.first == b.first){
        return a.second < b.second;
    }
    return a.first<b.first;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    long long sum = 0;
    cin >> n;
    
    for(int i = 0; i<n;i++){
        int num, count;
        cin >> num >> count;
        town.push_back({num,count});
        sum = sum + count;
    }
    
    sort(town.begin(),town.end(), comp);
    
    long long lim = 0;
    int ret;
    
    for(int i = 0 ; i<town.size();i++){
        lim = town[i].second + lim;
        if (lim >= (sum+1)/2){
            ret = town[i].first;
            break;
        }
    }
    
    cout << ret;
}
