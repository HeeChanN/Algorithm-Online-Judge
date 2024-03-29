#include <bits/stdc++.h>

using namespace std;

map<string, int> mp;

vector<int> solution(vector<string> name, vector<int> yearning, vector<vector<string>> photo) {
    vector<int> answer;

    for (int i = 0; i < name.size(); i++) {
        mp[name[i]] = yearning[i];
    }

    for (int i = 0; i < photo.size(); i++) {
        int point = 0;
        for (int j = 0; j < photo[i].size(); j++) {
            point += mp[photo[i][j]];
        }
        answer.push_back(point);
    }


    return answer;
}