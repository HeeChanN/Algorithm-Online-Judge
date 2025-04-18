#include <bits/stdc++.h>

using namespace std;

int n,m,ret,num;

vector<int> mi;
vector<int> pl;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    for(int i = 0; i<n;i++){
        cin >> num;
        if(num < 0){
            mi.push_back(num);
        }
        else{
            pl.push_back(num);
        }
    }
    
    sort(pl.begin(),pl.end());
    sort(mi.begin(),mi.end());
    
    for(int i = pl.size()-1; i>=0;i = i-m){
        ret += pl[i] * 2;
    }
    for(int i = 0; i< mi.size(); i = i+m){
        ret += abs(mi[i]) * 2;
    }
    if(pl.size() > 0 && mi.size() > 0){
        if(abs(mi[0]) < pl[pl.size()-1]){
            ret -= pl[pl.size()-1];
        }
        else{
            ret -= abs(mi[0]);
        }
    }
    else if (pl.size() >0){
        ret -= pl[pl.size()-1];
    }
    else{
        ret -= abs(mi[0]);
    }
    cout<< ret;
}
