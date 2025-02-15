#include<bits/stdc++.h>

using namespace std;

string str[] = {"code", "date", "maximum", "remain"};
int search_idx;
int sort_idx;
int num;

bool comp(const vector<int>& a, const vector<int>& b){
    return a[sort_idx] < b[sort_idx];
}

vector<vector<int>> solution(vector<vector<int>> data, string ext, int val_ext, string sort_by) {
    vector<vector<int>> answer;
    
    for(int i = 0;i <4;i++){
        if(str[i] == ext){
            search_idx = i;
        }
        if(str[i] == sort_by){
            sort_idx = i;
        }
    }
    for(int i = 0; i<data.size();i++){
        num = data[i][search_idx];
        if(num < val_ext){
            answer.push_back(data[i]);
        }
    }
    //정렬
    sort(answer.begin(), answer.end(), comp);
    return answer;
}
