#include<bits/stdc++.h>

using namespace std;

long long solution(int k, int d) {
    long long answer = 0;
    long long x = 0;
    long long dist = (long long)d * d;
    while(x<=d){
        long long num = x * x;
        int r = (int)sqrt(dist - num);
        answer =answer + r / k + 1;
        x = x + k;
    }
    return answer;
}
