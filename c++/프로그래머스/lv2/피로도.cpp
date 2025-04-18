#include <bits/stdc++.h>

using namespace std;

vector<int> v;

int solution(int k, vector<vector<int>> dungeons) {
    int answer = -1;
    
    int n =dungeons.size();
    
    for(int i = 0; i<n;i++){
        v.push_back(i);
    }
    do{
        
        int hp = k;
        int cnt = 0;
        for(int i = 0;i<v.size();i++){
            int stage = v[i];
            if(hp <dungeons[stage][0]){
                break;
            }
            cnt++;
            hp = hp - dungeons[stage][1];
        }
        answer = max(answer, cnt);
    }while(next_permutation(v.begin(), v.end()));
    
    return answer;
}
