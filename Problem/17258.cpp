#include<bits/stdc++.h> 
using namespace std;


int n, m, k, t; 
int a, b;
int cnt[301];
int dp[301][301];
vector<pair<int, int>> v;

int go(int here, int num, int prev) {
    if (here == v.size()) 
        return 0;
    if (dp[here][num]) 
        return dp[here][num];

    int cost = max(0, t - v[here].second); // 추가로 필요한 사람
    int real_cost = (prev >= cost) ? 0 : cost; 
    // prev는 이전에 친구들이 들어가 있는 명 수로 만약 추가로 필요한 사람보다 많이 들어가 있다면 
    // 모든 친구들이 나오게되므로 0이되고 아니라면 cost가 그 실제 비용이 된다.


    int& ret = dp[here][num];
    if (num - real_cost >= 0) { // 지금 대기하고 있는 친구의 수가 num이고 음수로 가면 안됨

        // 친구를 투입할 경우와 친구 투입 x 를 나눠서 재귀를 돌림
        return ret = max(go(here + 1, num - real_cost, cost) + v[here].first, go(here + 1, num, 0));
    }
    else // 현재 대기하는 친구로는 t를 만족할 수 없음
        return ret = go(here + 1, num, 0);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m >> k >> t;
    for (int j = 0; j < m; j++) {
        cin >> a >> b;
        for (int i = a; i < b; i++)
            cnt[i] = min(t, ++cnt[i]);
    }

    int temp = cnt[1]; // 사람 수
    int _count = 1; // 시간

    // 구간 나누기 시간 1 부터 n까지 사람 수를 기준으로 시간대를 나눈다.
    for (int i = 2; i <= n; i++) {
        if (temp != cnt[i]) {
            v.push_back({ _count, temp });
            _count = 0;
            temp = cnt[i];
        }
        _count++;
    }
    v.push_back({ _count, temp });
    cout << go(0, k, 0) << "\n";
    return 0;
}
