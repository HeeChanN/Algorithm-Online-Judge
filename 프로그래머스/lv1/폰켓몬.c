#include <bits/stdc++.h>

using namespace std;

map<int, int> mp;

int solution(vector<int> nums)
{
    int answer = 0;
    int cnt = 0;
    for(int i = 0; i<nums.size();i++){
        if(mp[nums[i]] != 1){
            mp[nums[i]] = 1;
            cnt++;
        }
    }
    
    if(cnt >= nums.size() / 2){
        answer = nums.size() / 2;
    }
    else
        answer = cnt;
    
    return answer;
}
