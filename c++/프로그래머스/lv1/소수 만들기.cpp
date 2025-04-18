#include <vector>
#include <iostream>
using namespace std;

int go(int num){
    if (num % 2 == 0){
        return 0;
    }
    int i =3;
    while(i*i <= num){
        if(num%i == 0){
            return 0;
        }
        i++;
    }
    return 1;
}

int solution(vector<int> nums) {
    int answer = -1;
    int cnt = 0;
    
    for(int i = 0; i< nums.size();i++){
        for(int j = i+1; j<nums.size(); j++){
            for(int k = j+1;k<nums.size();k++){
                if(go(nums[i] + nums[j] + nums[k]) ==1)
                    cnt++;
            }
        }
    }
    
    answer = cnt;

    return answer;
}
