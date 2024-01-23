#include <bits/stdc++.h>

using namespace std;

map<string, pair<int,int>> mp;

string solution(vector<string> cards1, vector<string> cards2, vector<string> goal) {
    string answer = "";
    
    for(int i = 0; i < cards1.size();i++){
        mp[cards1[i]] = {0,i};
    }
    for(int i = 0;i < cards2.size();i++){
        mp[cards2[i]] = {1,i};
    }
    int start1 = 0;
    int start2 = 0;
    
    for(int i = 0;i<goal.size();i++){
        if(mp[goal[i]].first == 0){
            if(start1 != mp[goal[i]].second){
                answer = "No";
                return answer;
            }
            else{
                start1++;
            }
        }
        else if(mp[goal[i]].first == 1){
            if(start2 != mp[goal[i]].second){
                answer = "No";
                return answer;
            }
            else{
                start2++;
            }
        }
    }
    answer = "Yes";
    return answer;
}
