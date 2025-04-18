#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;

int t,f;
string str1, str2;
unordered_map<string,pair<string,int>> mp;

string find_parent(string str1){
    if(mp[str1].first == str1){
        return str1;
    }
    return mp[str1].first = find_parent(mp[str1].first);
}

int union_friend(string str1, string str2,int i){
    string p1 = find_parent(str1);
    string p2 = find_parent(str2);
    
    if(p1 == p2){
        return mp[p1].second;
    }
    
    int cnt1 = mp[p1].second;
    int cnt2 = mp[p2].second;
    mp[p1].first = p2;
    mp[p2].second = cnt1 + cnt2;
    return cnt1 + cnt2;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    while(t--){
        cin >> f;
        mp.clear();
        for(int i = 0; i<f;i++){
            cin >> str1 >> str2;
            if(mp.count(str1) == 0){
                mp[str1] = {str1,1};
            }
            if(mp.count(str2) == 0){
                mp[str2] = {str2,1};
            }
            cout <<union_friend(str1,str2,i) << "\n";
        }
    }
}
