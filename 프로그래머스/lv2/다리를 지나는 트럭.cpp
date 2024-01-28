#include<bits/stdc++.h>

using namespace std;

int cnt,sum,idx;
    

int solution(int bridge_length, int weight, vector<int> truck_weights) {
    int answer = 0;
    queue<int> q;
    
    q.push(truck_weights[0]);
    cnt++;
    sum = sum + q.front();
    idx = 1;
    
    while(sum != 0){
        int next;
        if(idx == truck_weights.size()){
            next = 987654321;
        }
        else
            next = truck_weights[idx];
        if(q.size() == bridge_length){
            int tmp = q.front();
            q.pop();
            sum = sum - tmp;
        }
        if(sum + next <= weight){
            q.push(next);
            idx++;
            sum = sum + next;
        }
        else{
            q.push(0);
        }
        cnt++;
    }
    answer = cnt;
    return answer;
}
