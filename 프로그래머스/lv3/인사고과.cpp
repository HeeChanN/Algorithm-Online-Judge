#include<bits/stdc++.h>


using namespace std;
struct A{
    int num1;
    int num2;
    int idx;
};

vector<A> v;
vector<pair<int,int>> ret;
int abc;

bool comp(struct A a, struct A b){
    if(a.num1 == b.num1){
        return a.num2 > b.num2;
    }
    return a.num1 > b.num1;
}

bool comp2(pair<int,int> a, pair<int,int> b){
    return a.first >= b.first;
}

int solution(vector<vector<int>> scores) {
    int answer = 0;
    for(int i =0;i<scores.size();i++){
        v.push_back({scores[i][0], scores[i][1], i});
    }
    
    sort(v.begin(), v.end(), comp);
    
    int prev_num1 = v[0].num1;
    int prev_num2 = v[0].num2;
    int big = 0;
    ret.push_back({v[0].num1 + v[0].num2, v[0].idx});
    
    for(int i = 1;i<v.size();i++){
        if(v[i].num1 != v[i-1].num1){
            prev_num1 = v[big].num1;
            prev_num2 = v[big].num2;
            if(v[i].num2 > prev_num2){
                big = i;
            }
        }
        if(v[i].num1 == prev_num1){
            ret.push_back({v[i].num1 + v[i].num2, v[i].idx});
        }
        else if (v[i].num1 < prev_num1){
        
            if(v[i].num2 >= prev_num2){
                ret.push_back({v[i].num1 + v[i].num2, v[i].idx});
            }
        }
    }
    
    int flag = 0;
    for(int i =0;i<ret.size();i++){
        if(ret[i].second == 0){
            flag = 1;
        }
    }
    if(flag == 0){
        return -1;
    }
    sort(ret.begin(), ret.end(), comp2);
    int rank = 1;
    int num = ret[0].first;
    int cnt = 0;
    if(ret[0].second == 0){
        return 1;
    }
    for(int i = 1; i< ret.size();i++){
        if(ret[i].first == num){
            cnt++;
        }
        else{
            rank = rank + cnt + 1;
            num = ret[i].first;
            cnt = 0;
        }
        if(ret[i].second == 0){
            answer = rank;
            break;
        }
        
    }
    return answer;
}
