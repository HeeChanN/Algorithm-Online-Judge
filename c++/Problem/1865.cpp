#include<bits/stdc++.h>

using namespace std;

int n, m, w;
int te;
int s, e, t;

int dist[504];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> te;

	while (te--) {
		vector<pair<int, int>> adj[504];
		cin >> n >> m >> w; // ���� ����, ���� ����, ��Ȧ ����
		
		for (int i = 0; i < m; i++) { //������ ��� �����
			cin >> s >> e >> t;
			adj[s-1].push_back({ e-1,t });
			adj[e-1].push_back({ s-1,t });
		}

		for (int i = 0; i < w; i++) {// ��Ȧ�� ��� �ܹ��� ���� ����ġ
			cin >> s >> e >> t;
			adj[s-1].push_back({ e-1,-t });
		}
		fill(&dist[0], &dist[503], 987654321);
		dist[0] = 0;
		int flag = 0;
		for (int i = 0; i < n; i++) { // V-1�� ��ȭ
			for (int j = 0; j < n; j++) {
				for (pair<int, int> next : adj[j]) {
					int _next = next.first;
					int d = next.second;
					if (d + dist[j] < dist[_next]) {
						if (i == n - 1) {
							flag = 1;
						}
						dist[_next] = dist[j] + d;
					}
				}
			}
		}
		if (flag == 1) {
			cout << "YES\n";
		}
		else {
			cout << "NO\n";
		}
	}
}