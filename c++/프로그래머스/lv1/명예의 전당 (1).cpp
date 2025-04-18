#include<bits/stdc++.h>

using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;


vector<int> solution(int k, vector<int> score) {
    vector<int> answer;
    
    for(int i = 0; i< min((int)score.size(),k) ;i++){
        pq.push(score[i]);
        answer.push_back(pq.top());
    }

    for(int i = k;i<score.size();i++){
        if(pq.top() < score[i]){
            pq.push(score[i]);
            pq.pop();
        }
        answer.push_back(pq.top());
    }
    
    return answer;
}

