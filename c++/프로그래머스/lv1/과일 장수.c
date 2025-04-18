#include <bits/stdc++.h>


using namespace std;

bool comp(int a, int b){
    return a>b;
}

int solution(int k, int m, vector<int> score) {
    int answer = 0;
    
    int ret = k;
    int cnt = 0;
    sort(score.begin(),score.end(),comp);
    for(int i = 0; i<score.size();i++){
        ret = min(ret, score[i]);
        cnt++;
        if(cnt==m){
            answer = answer + m * ret;
            ret = k;
            cnt = 0;
        }
    }
    
    return answer;
}
