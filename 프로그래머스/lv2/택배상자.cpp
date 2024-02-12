#include <bits/stdc++.h>

using namespace std;

stack<int> s;

int solution(vector<int> order) {
    int answer = 0;
    
    int idx = 0;
    int num = 1;
    while (true){
        if(idx == order.size() || num == order.size() + 2)
            break;
        if(s.size() && s.top() == order[idx]){
            s.pop();
            idx++;
        }
        else if(num == order[idx]){
            idx++;
            num++;
        }
        else{
            s.push(num);
            num++;
        }
    }
    answer = idx;
    return answer;
}
