#include <bits/stdc++.h>


using namespace std;

map<string ,int> visited;
map<string, int> mp;
map<string, int> singo;
map<string, vector<string>> ret;

vector<string> split(string s){
    vector<string> tmp;
    
    int pos = s.find(" ");
    tmp.push_back(s.substr(0,pos));
    tmp.push_back(s.substr(pos+1));
    
    return tmp;
}

vector<int> solution(vector<string> id_list, vector<string> report, int k) {
    vector<int> answer;
    
    for(int i = 0;i<report.size();i++){
        if(mp[report[i]] != 1){
            mp[report[i]] = 1;
            vector<string> tmp = split(report[i]);
            singo[tmp[1]]++;
            ret[tmp[1]].push_back(tmp[0]);
        }
    }
    
    for(int i = 0;i<id_list.size();i++){
        if(singo[id_list[i]]>=k){
            for(string s : ret[id_list[i]]){
                visited[s]++;
            }
        }
    }
    
        
    for(int i = 0 ; i<id_list.size();i++){
        answer.push_back(visited[id_list[i]]);
    }
    
    return answer;
}
