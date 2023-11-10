#include<bits/stdc++.h>

using namespace std;

int t, n, k;
int u, v, w;
int cost[1004];
long long dp[1004];

vector<int> adj[1004];

long long go(int start) {
    if (adj[start].size()==0) {
        return cost[start];
    }
    long long& ret = dp[start];
    if (ret != -1) {
        return ret;
    }
    for (int need : adj[start]) {
        ret = max(go(need), ret);
    }
    ret = ret + cost[start];
    return ret;
}

void clean_adj() {
    for (int i = 0; i < n; i++) {
        adj[i].clear();
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> t;
    while (t--) {
        cin >> n >> k;
        memset(dp, -1, sizeof(dp));
        for (int i = 0; i < n; i++) {
            cin >> cost[i];
        }

        for (int i = 0; i < k; i++) {
            cin >> u >> v;
            adj[v-1].push_back(u-1);
        }
        cin >> w;
        cout << go(w-1)<<'\n';
        clean_adj();
    }
}