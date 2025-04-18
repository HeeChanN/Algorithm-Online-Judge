#include <bits/stdc++.h>

using namespace std;

vector<int> solution(vector<string> wallpaper) {
    vector<int> answer;
    
    int min_x = wallpaper[0].size();
    int min_y = wallpaper.size();
    int max_x = 0;
    int max_y = 0;
    
    for(int i = 0; i<wallpaper.size();i++){
        for(int j = 0;j<wallpaper[i].size();j++){
            if(wallpaper[i][j] == '#'){
                min_y = min(min_y,i);
                min_x = min(min_x,j);
                max_y = max(max_y,i+1);
                max_x = max(max_x,j+1);
            }
        }
    }
    answer.push_back(min_y);
    answer.push_back(min_x);
    answer.push_back(max_y);
    answer.push_back(max_x);
    
    
    return answer;
}
