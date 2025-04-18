#include <bits/stdc++.h>

// ���ͽ�Ʈ�� ���� --> ���� ����ġ�� ��� ����

using namespace std;

int dist[20004];

vector<pair<int,int>> adj[200004];
priority_queue<pair<int, int>, vector<pair<int, int>>, greater<pair<int, int>>> pq;

int v, e, k;

int s, f, w; // start, finish , weigh

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	
	cin >> v >> e;
	cin >> k;
	// ���� ����ġ �׷��� ����� �ֱ�
	for (int i = 0; i < e; i++) {
		cin >> s >> f >> w;
		adj[s].push_back({w, f});
	}

	fill(&dist[0], &dist[20003], 987654321);
	// ���ͽ�Ʈ�� �˰���
	dist[k] = 0;
	pq.push({ 0, k });
	while (pq.size() != 0)
	{
		int here = pq.top().second;
		int here_dist = pq.top().first;
		pq.pop();

		if (dist[here] != here_dist)
			continue;
		for (pair<int,int> next : adj[here]) {
			int _dist = next.first;
			int _next = next.second;
			if (dist[_next] > dist[here] + _dist)
			{
				dist[_next] = dist[here] + _dist;
				pq.push({ dist[_next], _next });
			}
		}
	}
	for (int i = 1; i <= v; i++) {
		if (dist[i] == 987654321)
			cout << "INF" << '\n';
		else 
			cout << dist[i] << "\n";	
	}
}