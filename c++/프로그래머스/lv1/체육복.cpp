#include <bits/stdc++.h>

using namespace std;
int person[32];


int solution(int n, vector<int> lost, vector<int> reserve) {
    int answer = 0;

    fill(&person[0], &person[32], 1);

    for (int i = 0; i < lost.size(); i++) {
        person[lost[i]] -= 1;
    }

    for (int i = 0; i < reserve.size(); i++) {
        person[reserve[i]]++;
    }

    for (int i = 1; i <= n; i++) {
        if (person[i] == 0) {
            if (person[i - 1] == 2) {
                answer++;
                person[i - 1] = 1;
            }

            else if (person[i + 1] == 2) {
                answer++;
                person[i + 1] = 1;
            }
        }
        else {
            answer++;
        }
    }

    return answer;
}