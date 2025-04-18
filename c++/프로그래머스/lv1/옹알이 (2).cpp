#include<bits/stdc++.h>

using namespace std;

map<char,int> mp;
map<int, string> str;



int solution(vector<string> babbling) {
    int answer = 0;
    
    mp['a'] = 1;
    mp['y'] = 2;
    mp['w'] = 3;
    mp['m'] = 4;
    str[1] = "aya";
    str[2] = "ye";
    str[3] = "woo";
    str[4] = "ma";
    
    for(int i = 0; i<babbling.size();i++){
        int idx = 0;
        int flag = 0;
        string prev = "";
        while(idx < babbling[i].size()){
            if(mp[babbling[i][idx]] == 0){
                flag = 1;
                break;
            }
            string tmp = str[mp[babbling[i][idx]]];
            string match = babbling[i].substr(idx,tmp.length());
            if (tmp.compare(match) == 0){
                if (prev.compare(match) == 0){
                    flag = 1;
                    break;
                }
                idx= idx + tmp.length();
                prev = match;
            }
            else{
                flag = 1;
                break;
            }
        }
        if(flag == 0){
            answer++;
        }
    }
    return answer;
}
