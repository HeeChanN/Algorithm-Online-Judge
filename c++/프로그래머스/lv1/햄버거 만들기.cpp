#include<bits/stdc++.h>

using namespace std;
stack<pair<int,int>> s;

int solution(vector<int> ingredient) {
    int answer = 0;
    
    int cnt = 0;
    for(int i =0;i<ingredient.size();i++){
        if(s.size() == 0){
            if(ingredient[i] == 1){
                s.push({ingredient[i],1});
            }
            else{
                s.push({ingredient[i],0});
            }
            continue;
        }
        if(ingredient[i] == 1){
            if(s.top().first == 3 && s.top().second == 3){
                for(int i = 0;i<3;i++){
                    s.pop();
                }
                answer++;
            }
            else{
                s.push({ingredient[i],1});
            }
            
        }
        else if(ingredient[i] == 2){
            if(s.top().first == 1 && s.top().second == 1){
                s.push({ingredient[i],2});
            }
            else
                s.push({ingredient[i],0});
        }
        else if (ingredient[i] == 3){
            if(s.top().first == 2 && s.top().second == 2){
                s.push({ingredient[i],3});
            }
            else{
                s.push({ingredient[i],0});
            }
        }
    }
    
    return answer;
}
