#include<bits/stdc++.h>

using namespace std;

int n, m, v, u, w;
int a, b;
vector<pair<int, int>> adj[1004];
priority_queue < pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;
int dist[1004];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	cin >> m;
	for (int i = 0; i < m; i++) {
		cin >> v >> u >> w;
		adj[v].push_back({ w,u });
	}
	cin >> a >> b;
	fill(&dist[0], &dist[1003],1111111111);
	dist[a] = 0;
	pq.push({ 0,a });

	while (pq.size()) {
		int here = pq.top().second;
		int d = pq.top().first;
		pq.pop();

		if (d != dist[here]) {
			continue;
		}
		for (pair<int, int> next : adj[here]) {
			int _next = next.second;
			int _d = next.first;

			if (dist[_next] > dist[here] + _d) {
				dist[_next] = dist[here] + _d;
				pq.push({ dist[_next],_next });
			}
		}

	}
	cout << dist[b];
}