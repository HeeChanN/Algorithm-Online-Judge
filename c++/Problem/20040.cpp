#include<bits/stdc++.h>

using namespace std;

int parent[500000];
int n, m;
int u, v;
int ret;
int find(int u) {
    if (parent[u] == u)
        return u;
    return parent[u] = find(parent[u]);
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;

    for (int i = 0; i < 500000; i++) {
        parent[i] = i;
    }
    for (int i = 1; i <= m; i++) {
        cin >> u >> v;
        int pu = find(u);
        int pv = find(v);
        if (pu == pv && ret == 0) {
            ret = i;
        }
        parent[pu] = pv;
    }
    cout << ret;
}
