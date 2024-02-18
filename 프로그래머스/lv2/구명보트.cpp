#include <bits/stdc++.h>

using namespace std;

bool comp(int a, int b){
    return a > b;
}

priority_queue<int, vector<int>, less<int>> pq;

int solution(vector<int> people, int limit) {
    int answer = 0;
    
    sort(people.begin(), people.end(), comp);
    for(int i = 0; i<people.size();i++){
        if(pq.size() == 0){
            pq.push(limit - people[i]);
        }
        else if(pq.top() >= people[i]){
            pq.pop();
            answer++;
        }
        else{
            pq.push(limit-people[i]);
        }
    }
    
    answer = answer + pq.size();
    return answer;
}
