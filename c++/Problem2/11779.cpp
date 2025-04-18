#include<bits/stdc++.h>

using namespace std;

priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int post[1002];
int dist[1002];
vector<pair<int, int>> adj[1002];

int n, m;
int u, v, w;
int s, e;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    cin >> m;
    for (int i = 0; i < m; i++) {
        cin >> u >> v >> w;
        adj[u].push_back({ w,v });
    }

    cin >> s >> e;
    fill(&dist[0], &dist[1002], 987654321);

    dist[s] = 0;
    pq.push({ 0,s });

    while (pq.size()) {
        int d = pq.top().first;
        int start = pq.top().second;
        pq.pop();
        if (dist[start] != d) {
            continue;
        }
        for (pair<int, int> next : adj[start]) {
            int n_d = next.first;
            int n_p = next.second;
            if (dist[n_p] > n_d + d) {
                dist[n_p] = n_d + d;
                pq.push({ dist[n_p],n_p });
                post[n_p] = start;
            }
        }
    }
    cout << dist[e] << "\n";
    int tmp = e;
    vector<int> ret;
    ret.push_back(tmp);
    while (1) {
        tmp = post[tmp];
        if (tmp == 0) {
            break;
        }
        ret.push_back(tmp);
    }
    cout << ret.size()<<'\n';

    for (int i = ret.size() - 1; i >= 0; i--) {
        cout << ret[i] << " ";
    }

}