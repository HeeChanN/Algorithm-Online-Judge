#include<bits/stdc++.h>

using namespace std;

int n, m, r;
int items[104];
int adj[104][104];

int a, b, l;

// n = 지역 개수, m = 수색 범위, r = 길의 개수
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> r;

	for (int i = 0; i < n; i++) {
		cin >> items[i];
	}
	fill(&adj[0][0], &adj[103][104],987654321);
	for (int i = 0; i < r; i++) {
		cin >> a >> b >> l;
		adj[a - 1][b - 1] = l;
		adj[b - 1][a - 1] = l;
	}
	for (int i = 0; i < n; i++) {
		adj[i][i] = 0;
	}

	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				adj[i][j] = min(adj[i][j], adj[i][k] + adj[k][j]);
			}
		}
	}
	int tmp = 0;
	int ret = 0;
	for (int i = 0; i < n; i++) {
		tmp = 0;
		for (int j = 0; j < n; j++) {
			if (adj[i][j] <= m) {
				tmp = tmp + items[j];
			}
		}
		if (tmp > ret) {
			ret = tmp;
		}
	}
	cout << ret;

}