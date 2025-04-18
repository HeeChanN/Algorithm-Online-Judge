#include<bits/stdc++.h>

using namespace std;

int l,r,sum;
int len;

vector<int> solution(vector<int> sequence, int k) {
    vector<int> answer;
    
    sum = sequence[0];
    answer.push_back(0);
    answer.push_back(sequence.size()-1);
    len = answer[1] - answer[0];

    while(l<=r && r < sequence.size()){
        if(sum < k){
            r++;
            sum = sum + sequence[r];
        }
        else if (sum == k){
            if (len == r-l){
                if(answer[0] > l){
                    answer[0] = l;
                    answer[1] = r;
                    len = r-l;
                }
            }
            else if (len > r-l){
                answer[0] = l;
                answer[1] = r;
                len = r-l;
            }
            sum = sum - sequence[l];
            l++;
        }
        else{
            sum = sum - sequence[l];
            l++;
        }
    }
    
    return answer;
}
