#include<bits/stdc++.h>

using namespace std;

int go(int num) {
    if (num == 2) {
        return 1;
    }
    if (num % 2 == 0) {
        return 0;
    }
    int i = 2;
    while (i * i <= num) {
        if (num % i == 0) {
            return 0;
        }
        i++;
    }
    return 1;
}

int solution(int n) {
    int answer = 0;

    for (int i = 2; i <= n; i++) {
        if (go(i)) {
            answer++;
        }
    }
    return answer;
}