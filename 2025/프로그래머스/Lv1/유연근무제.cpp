#include<bits/stdc++.h>


using namespace std;

int visited[1004];

int solution(vector<int> schedules, vector<vector<int>> timelogs, int startday) {
    int answer = 0;
    
    for(int i = 0; i<schedules.size();i++){
        schedules[i] = schedules[i] + 10;
        if((schedules[i] % 100) > 59){
            schedules[i] = schedules[i] + 40;
        }
    }
    
    for(int i = 0; i<7;i++){
        if(startday % 7 == 6 || startday % 7 == 0){
            startday++;
            continue;
        }
        for(int j = 0;j<timelogs.size();j++){
            if(timelogs[j][i] > schedules[j]){
                visited[j] = 1;
            }
        }
        startday++;
    }
    
    for(int j = 0;j<timelogs.size();j++){
        if(visited[j] == 0){
            answer++;
        }
    }
    
    return answer;
}
