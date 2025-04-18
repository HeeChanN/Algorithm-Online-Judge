#include <bits/stdc++.h>

using namespace std;

int n, m;

vector<pair<long long, long long>> adj[200002];
pair<long long, long long> dist[200002];
int visited[200002];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    int t;
    cin >> t;
    for (int i = 1; i <= t; i++) {
        cin >> n >> m;
        for (int i = 0; i < 200001; i++) {
            adj[i].clear();
            visited[i] = 0;
        }
        for (int i = 0; i < m; i++) {
            int u, v, w;
            cin >> u >> v >> w;
            adj[u].push_back({ w,v });
            adj[v].push_back({ w,u });
        }
        priority_queue<pair<long long, long long>, vector<pair<long long, long long>>, greater<pair<long long, long long>>> pq;
        for (int i = 1; i < 200001; i++) {
            dist[i].first = 10000000000000000;
            dist[i].second = 0;
        }

        pq.push({ 0,1 });
        dist[1].first = 0;
        dist[1].second = 0;
        while (pq.size()) {
            long long d = pq.top().first;
            long long pos = pq.top().second;

            visited[pos] = 1;
            pq.pop();
            if (dist[pos].first != d) {
                continue;
            }

            for (pair<long long, long long> next : adj[pos]) {
                long long nd = next.first;
                long long npos = next.second;
                if (visited[npos] == 0 && dist[npos].first >= dist[pos].first + nd) {
                    if (dist[npos].first == dist[pos].first + nd) {
                        dist[npos].second = min(dist[npos].second, nd);
                    }
                    dist[npos].first = dist[pos].first + nd;
                    dist[npos].second = nd;
                    pq.push({ dist[npos].first,npos });
                }
            }
        }
        long long ret = 0;
        for (int i = 1; i <= n; i++) {
            ret = ret + dist[i].second;
        }
        cout << "#" << i << " " << ret << "\n";

    }
}