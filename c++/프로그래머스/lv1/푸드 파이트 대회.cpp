#include <bits/stdc++.h>

using namespace std;


string solution(vector<int> food) {
    string answer = "";
    
    queue<int> q;
    int sum = 1;
    
    for(int i = 1; i< food.size();i++){
        int num = food[i] / 2;
        if(food[i] % 2 == 1){
            sum = sum + food[i] - 1;
        }
        else{
            sum = sum + food[i];
        }
        
        while (num){
            q.push(i);
            num--;
        }
    }
    
    int l = 0;
    int r = sum-1;
    
    vector<char> v(sum);
    
    while(q.size()){
        int num = q.front();
        q.pop();
        v[l] = v[r] = num+'0';
        l += 1;
        r -= 1;
    }
    v[l] = '0';
    for(int i = 0; i<v.size();i++){
        answer = answer + v[i];
    }
    
    return answer;
}
