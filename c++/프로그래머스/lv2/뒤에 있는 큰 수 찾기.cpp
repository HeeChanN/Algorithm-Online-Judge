#include<bits/stdc++.h>

using namespace std;

stack<int> s;
int arr[1000004];


vector<int> solution(vector<int> numbers) {
    vector<int> answer;
    
    s.push(0);
    
    for(int i = 1; i<numbers.size();i++){
        while(!s.empty() && numbers[s.top()] < numbers[i]){
            int idx = s.top();
            s.pop();
            arr[idx] = numbers[i];
        }
        s.push(i);
    }
    
    while(s.size()){
        int idx = s.top();
        s.pop();
        arr[idx] = -1;
    }
    for(int i = 0; i<numbers.size();i++){
        answer.push_back(arr[i]);
    }
    
    return answer;
}
