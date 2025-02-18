#include <bits/stdc++.h>

using namespace std;

bool comp (const int &a,const int &b){
    return a > b;
}

int solution(vector<int> A, vector<int> B)
{
    int answer = 0;
    
    sort(A.begin(), A.end());
    sort(B.begin(), B.end(),comp);
    
    for(int i = 0; i<B.size();i++){
        answer = answer + A[i] * B[i];
    }

    return answer;
}
