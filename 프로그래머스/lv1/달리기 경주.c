#include<bits/stdc++.h>

using namespace std;

map<string, int> mp;

vector<string> solution(vector<string> players, vector<string> callings) {
    vector<string> answer;

    for(int i =0;i<players.size();i++){
        mp[players[i]] = i;
    }


    for(int i =0; i < callings.size(); i++){
        int rank = mp[callings[i]];
        string tmp = players[rank - 1];
        players[rank-1] = players[rank];
        players[rank] = tmp;
        mp[callings[i]]--;
        mp[tmp]++;
    }
    answer = players;
    return answer;
}
