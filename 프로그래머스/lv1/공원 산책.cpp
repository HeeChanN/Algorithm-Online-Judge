#include<bits/stdc++.h>

using namespace std;

pair<int,int> start;

char dir[]={'N','E','S','W'};
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

vector<int> solution(vector<string> park, vector<string> routes) {
    vector<int> answer;
    for(int i = 0; i<park.size();i++){
        for(int j = 0;j<park[i].size();j++){
            if(park[i][j] == 'S'){
                start = {i,j};
            }
        }
    }
    
    for(int i = 0;i < routes.size(); i++){
        int flag;
        for(int j = 0;j<4;j++){
            if(routes[i][0] == dir[j]){
                flag = j;
            }
        }
        int py = start.first;
        int px = start.second;
        for(int j = 0;j<routes[i][2]-'0';j++){
            py = py + dy[flag];
            px = px + dx[flag];
            if(py <0 || px < 0 || py >= park.size() || px >= park[0].size() || park[py][px] == 'X'){
                flag = -1;
                break;
            }
        }
        if(flag == -1){
            continue;
        }
        park[start.first][start.second] = 'O';
        start = {py, px};
    }
    
    answer.push_back(start.first);
    answer.push_back(start.second);
    return answer;
}
