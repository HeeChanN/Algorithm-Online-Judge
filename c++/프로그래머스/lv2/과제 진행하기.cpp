#include <bits/stdc++.h>

using namespace std;

struct A{
    string name;
    int time;
    int play;
};

bool comp(struct A a, struct A b){
    return a.time < b.time;
}

vector<string> solution(vector<vector<string>> plans) {
    vector<string> answer;
    
    vector<A> easy;
    
    for(int i = 0 ;i<plans.size();i++){
        int h = stoi(plans[i][1].substr(0,2)) * 60;
        int m = stoi(plans[i][1].substr(3,2));
        struct A tmp = {plans[i][0], h+m, stoi(plans[i][2])};
        easy.push_back(tmp);
    }
    
    sort(easy.begin(),easy.end(),comp);
    
    stack<A> s;
    s.push(easy[0]);
    
    for(int i = 1; i<easy.size();i++){
        
        while(s.top().time + s.top().play <= easy[i].time){
            string p_name = s.top().name;
            int next_start = s.top().time + s.top().play;
            s.pop();
            answer.push_back(p_name);
            if(s.size() != 0){
              struct A tmp = s.top();
              tmp.time = next_start;
              s.pop();
              s.push(tmp);
            }
            else {
                break;
            }
        }
        
        if(s.size() != 0){
            struct A tmp = s.top();
            tmp.play = tmp.play - (easy[i].time - tmp.time);
            s.pop();
            s.push(tmp);
        }
        s.push(easy[i]);
    }
    
    while(s.size()){
        answer.push_back(s.top().name);
        s.pop();
    }
    
    
    return answer;
}
