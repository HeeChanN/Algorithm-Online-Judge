#include <bits/stdc++.h>

using namespace std;

map<char, int> mp;

int solution(string skill, vector<string> skill_trees) {
    int answer = 0;
    
    for(int i = 0; i<skill.length() ; i++){
        mp[skill[i]] = i+1;
    }
    
    for(int i = 0;i<skill_trees.size();i++){
        int prev = 0;
        int flag = 0;
        for(int j = 0;j<skill_trees[i].size();j++){
            if(mp[skill_trees[i][j]] != 0){
                if(prev == 0 && mp[skill_trees[i][j]] == 1){
                    prev = 1;
                }
                else if (prev == mp[skill_trees[i][j]] - 1){
                    prev = prev + 1;
                }
                else{
                    flag = 1;
                    break;
                }
            }
        }
        if(flag == 0){
            answer++;
        }
    }
    return answer;
}
