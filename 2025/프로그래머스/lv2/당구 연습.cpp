#include<bits/stdc++.h>

using namespace std;

int dy[4];
int dx[4];
double dist;

vector<int> solution(int m, int n, int startX, int startY, vector<vector<int>> balls) {
    vector<int> answer;
    
    dy[0] = 2 *(n - startY) + startY;
    dx[0] = startX;
    dy[1] = startY;
    dx[1] = 2 * (m - startX) + startX;
    dy[2] = -startY;
    dx[2] = startX;
    dy[3] = startY;
    dx[3] = -startX;
     
    for(int i = 0; i<balls.size();i++){
        int x = balls[i][0];
        int y = balls[i][1];
        dist = INT_MAX;
        for(int j = 0; j<4;j++){
            if(y == dy[j]){
                if((x>dx[j] && x < startX) ||(x>startX) && x<dx[j] )
                    continue;
            }
            if(x == dx[j]){
                if((y>dy[j] && y < startY) ||(y>startY) && y<dy[j] )
                    continue;
            }
            dist = min(dist, pow((dy[j] - y),2) + pow((dx[j] - x),2));
        }
        answer.push_back(dist);
    }
    return answer;
}
