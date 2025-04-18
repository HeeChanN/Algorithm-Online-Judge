#include <bits/stdc++.h>

using namespace std;

int solution(vector<int> number) {
    int answer = 0;
    
    sort(number.begin(), number.end());
    
    for(int i = 0;i<number.size();i++){
        for(int j = i+1; j<number.size();j++){
            int num = -(number[i] + number[j]);
            int pos = lower_bound(number.begin() +j + 1, number.end(),num) - number.begin();
            int lim = upper_bound(number.begin() + j + 1, number.end(), num) - number.begin();
            
            answer = answer + lim - pos;
        }
    }
    
    return answer;
}
