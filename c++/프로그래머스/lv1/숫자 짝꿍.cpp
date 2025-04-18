#include<bits/stdc++.h>

using namespace std;

bool comp(int a, int b){
    return a > b;
}


map<char,int> mp1;
map<char, int> mp2;
int flag;

string solution(string X, string Y) {
    string answer = "";
    
    for(int i = 0 ; i<X.size();i++){
        mp1[X[i]]++;
    }
    
    for(int i = 0;i<Y.size();i++){
        mp2[Y[i]]++;
    }
    
    
    for(char i = '9'; i>='0';i--){
        int tmp = min(mp1[i], mp2[i]);
        if (i =='0')
            flag = tmp;
        if(tmp ==0){
            continue;
        }
        for(int j = 0; j<tmp;j++){
            answer+=i;
        }
    }
    if(answer == "")
        answer = "-1";
    if(answer.size() == flag)
        answer = "0";
    
    return answer;
}
