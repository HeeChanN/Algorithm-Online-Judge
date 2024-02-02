#include<bits/stdc++.h>

using namespace std;

string hour[24]={"00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
                "22","23"};
string minute[60]={
    "00","01","02","03","04","05","06","07","08","09","10","11","12","13","14","15","16","17","18","19","20","21",
    "22","23","24","25","26","27","28","29","30","31","32","33","34","35","36","37","38","39","40","41","42","43",
    "44","45","46","47","48","49","50","51","52","53","54","55","56","57","58","59"
};

bool comp(pair<int,int> a , pair<int,int> b){
    if(a.first == b.first){
        return a.second < b.second;
    }
    return a.first < b.first;
}

int solution(vector<vector<string>> book_time) {
    int answer = 0;
    vector<pair<int,int>> v;
    
    for(int i = 0; i<book_time.size();i++){
        int s_min;
        int e_min;
        for(int j = 0; j < 24;j++){
            if(book_time[i][0].substr(0,2) == hour[j]){
                s_min = j * 60;
            }
            if(book_time[i][1].substr(0,2) ==hour[j]){
                e_min = j *60;
                break;
            }
        }
        
        for(int j = 0; j < 60;j++){
            if(book_time[i][0].substr(3,2) == minute[j]){
                s_min = s_min + j;
            }
            if(book_time[i][1].substr(3,2) == minute[j]){
                e_min = e_min + j;
            }
        }
        v.push_back({s_min, e_min+10});
    }
    sort(v.begin(), v.end(), comp);
    
    priority_queue<int, vector<int>, greater<int>> pq;
    pq.push(v[0].second);
    for(int i = 1; i<v.size();i++){
        if(v[i].first < pq.top()){
            pq.push(v[i].second);
        }
        else{
            pq.pop();
            pq.push(v[i].second);
        }
        // cout<< v[i].first << " " << v[i].second << "\n";
    }
    answer = pq.size();
    return answer;
}
