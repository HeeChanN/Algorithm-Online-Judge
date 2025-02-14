#include<bits/stdc++.h>

using namespace std;

queue<pair<int,int>> q1;
queue<pair<int,int>> q2;
int need_server = 0;
int server = 0;

int solution(vector<int> players, int m, int k) {
    int answer = 0;
    
    for(int i = 0; i<players.size();i++){
        if(players[i] >= m){
            need_server = players[i]/m;
            need_server = need_server - server;
            if(need_server > 0){
                q1.push({k,need_server});
                server = server + need_server;
                answer = answer + need_server;
            }
        }
        while(q1.size()){
            pair<int,int> tmp = q1.front();
            q1.pop();
            if(tmp.first > 1){
                tmp.first = tmp.first - 1;
                q2.push(tmp);
            }
            else{
                server = server - tmp.second;
            }
        }
        q1.swap(q2);
        
    }
    cout<<answer;
    return answer;
}
