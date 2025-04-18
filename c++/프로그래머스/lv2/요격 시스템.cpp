#include <bits/stdc++.h>
using namespace std;

bool comp(pair<int,int> a, pair<int,int> b){
    if(a.first == b.first){
        return a.second < b.second;
    }
    return a.first < b.first;
}

int solution(vector<vector<int>> targets) {
    int answer = 0;
    vector<pair<int,int>> v;
    
    for(int i = 0; i<targets.size();i++){
        v.push_back({targets[i][0],targets[i][1]});
    }
    
    sort(v.begin(), v.end(), comp);
    
    
    
    pair<int,int> start = {v[0].first, v[0].second};
    int cnt = 1;
    for(int i = 1; i<v.size();i++){
        
        if(v[i].first < start.second){
            if(v[i].first > start.first){
                start.first = v[i].first;
            }
            if(v[i].second < start.second){
                start.second = v[i].second;
            }
        }
        else{
            cnt++;
            start.first = v[i].first;
            start.second = v[i].second;
        }
    }
    answer = cnt;
    
    
    return answer;
}
