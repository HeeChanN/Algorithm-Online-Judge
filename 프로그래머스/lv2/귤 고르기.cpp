#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;

unordered_map<int,int> mp;
vector<pair<int,int>> v;

bool comp(pair<int,int> a, pair<int,int> b){
    return a.first>=b.first;
}

int solution(int k, vector<int> tangerine) {
    int answer = 0;
    
    for(int i = 0 ;i<tangerine.size();i++){
        mp[tangerine[i]]++;
    }
    for(int i = 0;i<tangerine.size();i++){
        if(mp[tangerine[i]] != 0){
            v.push_back({mp[tangerine[i]],tangerine[i]});
            mp[tangerine[i]] = 0;
        }
    }
    sort(v.begin(), v.end(), comp);
    for(int i =0;i<v.size();i++){
        k = k - v[i].first;
        answer++;
        if(k<=0){
            break;
        }
    }
    
    return answer;
}
