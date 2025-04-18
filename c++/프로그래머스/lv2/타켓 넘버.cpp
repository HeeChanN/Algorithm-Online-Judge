#include <bits/stdc++.h>

using namespace std;

vector<int> number;
int answer;
int t;

void go(int idx, int sum){
    if(idx == number.size()){
        if(sum == t){
            answer++;
        }
        return;
    }
    go(idx + 1, sum - number[idx]);
    go(idx + 1,sum + number[idx]);
}

int solution(vector<int> numbers, int target) {
    number = numbers;
    t = target;
    go(0,0);
    
    return answer;
}
