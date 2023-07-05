#include <bits/stdc++.h>
using namespace std;

int n;
vector<pair<int, int>> v;
int ret;
int lis[102];
int main() {
    cin >> n;
    int a, b;
    for (int i = 0; i < n; i++) {
        cin >> a >> b;
        v.push_back({ a,b });
    }
    sort(v.begin(), v.end());
    int len = 0;
    for (int i = 0; i < n; i++) {
        auto pos = lower_bound(lis, lis + len, v[i].second);
        if (*pos == 0) {
            len++;
        }
        *pos = v[i].second;
    }
    cout << n - len;
}

