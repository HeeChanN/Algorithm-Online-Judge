#include <bits/stdc++.h>

using namespace std;

int visited[104];
vector<int> v;

bool comp(int a, int b){
    return a > b;
}

int solution(vector<int> cards) {
    int answer = 0;
    for(int i = 0;i<cards.size();i++){
        if (visited[i] == 1){
            continue;
        }
        int cnt = 0;
        int num = i;
        while(visited[cards[num]-1] == 0){
            visited[num] = 1;
            num = cards[num]-1;
            cnt++;
        }
        if(visited[num] == 0){
            visited[num] = 1;
            v.push_back(cnt+1);
        }
        else{
            v.push_back(cnt);
        }
    }
    
    if(v.size() == 1){
        answer = 0;
    }
    else{
        sort(v.begin(), v.end(),comp);
        answer = v[0] * v[1];
    }
    return answer;
}
