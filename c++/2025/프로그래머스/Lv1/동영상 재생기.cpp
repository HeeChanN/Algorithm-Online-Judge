#include<bits/stdc++.h>

using namespace std;

int t[4];
int pos;
char buffer[6];

void split(int i,string str){
    pos = str.find(':');
    t[i] = stoi(str.substr(0,pos)) * 60 + stoi(str.substr(pos+1));
}


string solution(string video_len, string pos, string op_start, string op_end, vector<string> commands) {
    
    split(0, pos);
    split(1, video_len);
    split(2, op_start);
    split(3, op_end);
    
    // 첫 시작 위치가 오프닝이면 움직이기
    if(t[0] >= t[2] && t[0] < t[3]){
        t[0] = t[3];
    }
    for(int i = 0; i<commands.size();i++){
        if(commands[i] == "next"){
            t[0] = min(t[1], t[0]+10);
        }
        else{
            t[0] = max(0, t[0]-10);
        }
        
        if(t[0] >= t[2] && t[0] < t[3]){
            t[0] = t[3];
        }
    }
    sprintf(buffer,"%02d:%02d",t[0]/60,t[0]%60);
    string answer(buffer);
    return answer;
}
