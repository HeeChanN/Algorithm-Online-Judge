#include <bits/stdc++.h>

using namespace std;

int n, m;
int a, b, c;

vector<pair<int, int>> adj[503];
long long dist[503];
int flag=0;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		adj[a - 1].push_back({ b - 1,c });
	}
	
	fill(&dist[0], &dist[502], 987654321);
	dist[0] = 0;
	
	for (int i = 0; i < n; i++) { // V-1번 순회하면 모든 간선이 완화되고 V번째 때 완화가 일어나면 사이클이 있는 것
		for (int j = 0; j < n; j++) {
			for (pair<int, int> next : adj[j]) {
				int t = next.second;
				int _next = next.first;

				if ((dist[j] != 987654321) && dist[j] + t < dist[_next]) {
					if (i == n - 1)
						flag = 1;
					dist[_next] = dist[j] + t;
				}
			}
		}
	}

	if (flag == 1) {
		cout << -1;
	}
	else {
		for (int i = 1; i < n; i++) {
			if (dist[i] != 987654321)
				cout << dist[i] << '\n';
			else {
				cout << -1 << '\n';
			}
		}
	}
}