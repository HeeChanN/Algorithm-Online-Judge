#include<bits/stdc++.h>
#include <unordered_map>

using namespace std;

int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};
int len;
unordered_map<string,int> mp;


int solution(vector<vector<string>> board, int h, int w) {
    int answer = 0;
    
    len = board.size();
    for(int i = 0; i<4;i++){
        int ny = dy[i] + h;
        int nx = dx[i] + w;
        if(ny <0 || nx < 0 || ny >= len || nx >= len){
            continue;
        }
        mp[board[ny][nx]]++;
    }
    
    answer = mp[board[h][w]];
    
    return answer;
}
