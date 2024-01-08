#include <bits/stdc++.h>

using namespace std;

int visited[26];

string solution(string s, string skip, int index) {
    string answer = "";
    
    for(int i = 0;i < skip.size();i++){
        visited[skip[i]%97] = 1;
    }
    
    for(int i = 0; i < s.size(); i++){
        int cnt = index;
        int idx = s[i] % 97;
        while(cnt> 0){
            idx++;
            if(visited[idx%26] == 0){
                cnt--;
            }
        }
        
        s[i] = 97 +(idx % 26);
    }
    
    answer = s;
    
    return answer;
}
