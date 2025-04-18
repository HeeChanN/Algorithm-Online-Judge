#include<bits/stdc++.h>
using namespace std;
int t, n, m, tree[200004], temp;
map<int, int> mp;
void update(int idx, int num) {
    while (idx <= 200004) {
        tree[idx] += num;
        idx += (idx & -idx);
    }
}
int sum(int j) {
    int ret = 0;
    while (j > 0) {
        ret += tree[j];
        j -= (j & -j);
    }
    return ret;
}
int main() {
    ios_base::sync_with_stdio(false); cin.tie(NULL); cout.tie(NULL);
    cin >> t;
    while (t--) {
        cin >> n >> m;
        memset(tree, 0, sizeof(tree));
        mp.clear();
        int start = 100001;
        for (int i = 1; i <= n; i++) {
            update(i + start, 1);
            mp[i] = i + start;
        }
        for (int i = 0; i < m; i++) {
            cin >> temp;
            int idx = mp[temp];
            cout << sum(idx) - 1 << " ";
            update(idx, -1);
            update(--start, 1);
            mp[temp] = start;
        }
        cout << "\n";
    }
}