#include <bits/stdc++.h>

using namespace std;

int attack[100004];

int go(int num){
    int cnt = 0;
    int i = 1;
    
    
    while(i * i <= num){
        if(num %i == 0){
            if(num / i != i){
                cnt = cnt + 2;
            }
            else{
                cnt = cnt + 1;
            }
        }
        i++;
    }
    return cnt;
}

int solution(int number, int limit, int power) {
    int answer = 0;
    
    attack[1] = 1;
    attack[2] = 2;
    
    for(int i = 3; i <=number;i++){
        int tmp = go (i);
        if(limit < tmp){
            attack[i] = power;
        }
        else
            attack[i] = tmp;
    }
    
    for(int i = 1; i<=number;i++){
        answer = answer + attack[i];
    }
    
    return answer;
}