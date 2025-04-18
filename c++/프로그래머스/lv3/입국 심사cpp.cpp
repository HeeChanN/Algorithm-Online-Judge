#include <bits/stdc++.h>

using namespace std;


long long solution(int n, vector<int> times) {
    long long answer = 0;
    long long m=0;
    for(int i = 0; i<times.size();i++){
        m = max((long long)times[i],m);
    }
    
    long long l =1;
    long long r = m * n;
    
    while(l<=r){
        long long mid = l+ ((r-l) / 2);
        long long cnt = 0;
        
        for(int i = 0; i<times.size();i++){
            cnt += mid / times[i];
        }
        
        if(cnt >= n){
            answer = mid;
            r = mid-1;
        }
        else{
            l = mid+1;
        }
    }
    
    return answer;
}
