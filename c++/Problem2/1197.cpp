#include<bits/stdc++.h>

using namespace std;

int v, e;
int a, b, w;
int ret;

priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
vector<pair<int, int>> adj[10001];
int visited[10001];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> v >> e;

    for (int i = 0; i < e; i++) {
        cin >> a >> b >> w;
        adj[a - 1].push_back({ w,b - 1 });
        adj[b - 1].push_back({ w,a - 1 });
    }

    pq.push({ 0, 0 });
    while (pq.size()) {
        int here = pq.top().second;
        int d = pq.top().first;
        pq.pop();
        if (visited[here] == 1) {
            continue;
        }
        ret = d + ret;
        visited[here] = 1;
        for (pair<int, int> next : adj[here]) {
            if (visited[next.second] == 0) {
                pq.push(next);
            }
        }
    }
    cout << ret;
    return 0;
}