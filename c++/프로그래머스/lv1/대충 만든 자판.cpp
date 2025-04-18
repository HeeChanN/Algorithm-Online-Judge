#include<bits/stdc++.h>

using namespace std;

map<char, int> mp;

vector<int> solution(vector<string> keymap, vector<string> targets) {
    vector<int> answer;
    
    for(int i = 0; i<keymap.size();i++){
        int cnt = 1;
        for(int j = 0;j<keymap[i].size();j++){
            if(mp[keymap[i][j]] == 0){
                mp[keymap[i][j]] = cnt;
            }
            else if (mp[keymap[i][j]] >=cnt){
                mp[keymap[i][j]] = cnt;
            }
            cnt++;
        }
    }
    
    
    for(int i = 0; i<targets.size();i++){
        int sum = 0;
        for(int j = 0; j<targets[i].size();j++){
            if(mp[targets[i][j]] == 0){
                sum = -1;
                break;
            }
            sum = sum + mp[targets[i][j]];

        }
        answer.push_back(sum);
    }
    
    
    return answer;
}
