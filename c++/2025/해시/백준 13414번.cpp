#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;

unordered_map<string,int> mp;
int k,l;
vector<string> v;
vector<string> ret;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> k >> l;
    //1차 대기열
    for(int i = 0; i<l;i++){
        string str;
        cin>>str;
        mp[str]++;
        v.push_back(str);
    }
    int cnt  = 0;
    for(int i = 0; i<l;i++){
        if(mp[v[i]]==1){
            ret.push_back(v[i]);
            cnt++;
        }
        else{
            mp[v[i]]--;
        }
        if(cnt == k){
            break;
        }
    }
    for(int i = 0; i<ret.size();i++){
        cout<<ret[i]<<"\n";
    }
}
