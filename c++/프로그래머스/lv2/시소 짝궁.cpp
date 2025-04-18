#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;

map<int,int> mp;

int sisow[3] = {2,3,4};

long long go(int num){
    long long cnt = 0;
    set<int> s;
    
    for(int i = 0; i<3;i++){
        int n = num * sisow[i];
        for(int j =0;j<3;j++){
            if(n%sisow[j] == 0){
                if(s.find(n/sisow[j]) == s.end() ){
                    cnt += mp[n/sisow[j]];
                    s.insert(n/sisow[j]);
                
                }
            }
        }
    }
    return cnt;
}

long long solution(vector<int> weights) {
    long long answer = 0;
    
    for(int i =0;i<weights.size();i++){
        mp[weights[i]]++;
    }
    
    for(int i = 0;i<weights.size();i++){
        
        mp[weights[i]]--;
        
        answer = answer + go(weights[i]);
        
        
        mp[weights[i]]++;
    }
    
    answer = answer / 2;
    return answer;
}
