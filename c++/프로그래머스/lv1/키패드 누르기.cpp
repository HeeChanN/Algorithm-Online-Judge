#include <bits/stdc++.h>

using namespace std;

map<int, pair<int,int>> mp;


string solution(vector<int> numbers, string hand) {
    string answer = "";
    mp[0] ={3,1};
    mp[1] = {0,0};
    mp[2] = {0,1};
    mp[3] = {0,2};
    mp[4] = {1,0};
    mp[5] = {1,1};
    mp[6] = {1,2};
    mp[7] = {2,0};
    mp[8] = {2,1};
    mp[9] = {2,2};
    
    pair<int,int> l;
    pair<int,int> r;
    l = {3,0};
    r = {3,2};
    
    for(int i =0;i<numbers.size(); i++){
        if(numbers[i]==1 || numbers[i]==4 || numbers[i] == 7){
            l.first = mp[numbers[i]].first;
            l.second = mp[numbers[i]].second;
            answer = answer + 'L';
        }
        else if (numbers[i] == 3 || numbers[i] == 6 || numbers[i] == 9){
            r.first = mp[numbers[i]].first;
            r.second = mp[numbers[i]].second;
            answer = answer + 'R';
        }
        else{
            int ld = abs(l.first - mp[numbers[i]].first) + abs(l.second - mp[numbers[i]].second);
            int rd = abs(r.first - mp[numbers[i]].first) + abs(r.second - mp[numbers[i]].second);
            cout<<i << " " <<ld <<" " <<rd << "\n";
            if (ld < rd){
                l.first = mp[numbers[i]].first;
                l.second = mp[numbers[i]].second;
                answer = answer + 'L';
            }
            else if (ld > rd){
                r.first = mp[numbers[i]].first;
                r.second = mp[numbers[i]].second;
                 answer = answer + 'R';
            }
            else{
                if(hand == "right")
                {
                    r.first = mp[numbers[i]].first;
                    r.second = mp[numbers[i]].second;
                    answer = answer + 'R';
                }
                else{
                    l.first = mp[numbers[i]].first;
                    l.second = mp[numbers[i]].second;
                    answer = answer + 'L';
                }
            }
        }
    }
    return answer;
}
