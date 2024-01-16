#include <bits/stdc++.h>

using namespace std;

int ret;
int l, r;



int solution(int n, int k, vector<int> enemy) {
    int answer = 0;

    l = 0;
    r = enemy.size() - 1;

    while (l <= r) {
        int m = (l + r) / 2;
        long long sum = 0;
        priority_queue<int, vector<int>, less<int>> pq;
        for (int i = 0; i <= m; i++) {
            sum = sum + enemy[i];
            pq.push(enemy[i]);
        }

        for (int i = 0; i < k; i++) {
            int num = pq.top();
            pq.pop();
            sum = sum - num;
        }

        if (sum > n) {
            r = m - 1;
        }
        else {
            l = m + 1;
            ret = max(ret, m);
        }
    }
    answer = ret + 1;
    return answer;
}