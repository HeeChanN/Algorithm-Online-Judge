#include <bits/stdc++.h>

using namespace std;

int  n, m;
int a, b, c;

int arr[102][102];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m; // 정점, 간선
	
	fill(&arr[0][0], &arr[101][102], 987654321);
	for (int i = 0; i < m; i++) {
		cin >> a >> b >> c;
		arr[a - 1][b - 1] = min(c, arr[a - 1][b - 1]);
	}

	for (int k = 0; k < n; k++) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				arr[i][j] = min(arr[i][j], arr[i][k] + arr[k][j]);
			}
		}
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (i == j) {
				cout << "0 ";
			}
			else if (arr[i][j] == 987654321) {
				cout << "0 ";
			}
			else {
				cout << arr[i][j] << " ";
			}
		}
		cout << '\n';
	}
	return 0;
}