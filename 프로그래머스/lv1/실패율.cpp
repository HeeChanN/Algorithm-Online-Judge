#include<bits/stdc++.h>

using namespace std;

map<int, int> mp;

bool compare(pair<double,int> a, pair<double,int> b){
    if(a.first == b.first){
        a.second < b.second;
    }
    return a.first > b.first;
}

vector<int> solution(int N, vector<int> stages) {
    vector<int> answer;
    vector<pair<double,int>> result;
    for(int i =0;i<stages.size();i++){
        mp[stages[i]]++;
    }
    
    int person = stages.size();
    for(int i = 1; i<=N;i++){
        int fail = mp[i];
        if(fail == 0){
            result.push_back({fail, i});
            continue;
        }
        double total = fail / (double)person;
        person = person - fail;
        result.push_back({total,i});
    }
    
    
    stable_sort(result.begin(), result.end(),compare);
    
    
    
    for(int i = 0; i<result.size();i++){
        answer.push_back(result[i].second);
    }
    
    return answer;
}
