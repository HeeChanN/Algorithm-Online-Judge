#include<bits/stdc++.h>

using namespace std;

int ret;
int total;

void combi(vector<vector<int>> users, vector<int> emoticons,vector<int> v){
    if(v.size() == emoticons.size()){
        int tmp_ret = 0;
        int tmp_sum = 0;
        for(int i = 0;i<users.size();i++){
            int sum = 0;
            for(int j =0;j<v.size();j++){
                if(v[j] >= users[i][0]){
                    sum = sum + emoticons[j] - ((emoticons[j] * v[j]) / 100);
                }
            }
            if(sum >= users[i][1]){
                tmp_ret++;
            }
            else{
                tmp_sum += sum;
            }
        }
        
        if(tmp_ret == ret){
            total = max(total, tmp_sum);
        }
        else if(tmp_ret > ret){
            ret = tmp_ret;
            total = tmp_sum;
        }
        return;
    }
    for(int i = 10;i<=40;i = i+10){
        v.push_back(i);
        combi(users, emoticons,v);
        v.pop_back();
    }
}

vector<int> solution(vector<vector<int>> users, vector<int> emoticons) {
    vector<int> answer;
    vector<int> v;
    combi(users, emoticons,v);
    answer.push_back(ret);
    answer.push_back(total);
    return answer;
}
