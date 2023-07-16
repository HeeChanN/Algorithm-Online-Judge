#include<bits/stdc++.h>
using namespace std;
int n, m;
int arr[51][51];
int dp[51][51]; //위치에서 최대이동 값을 저장
int visited[51][51];

int dy[] = { -1,0,1,0 };
int dx[] = { 0,1,0,-1 };

int go(int y, int x) {
	if (y < 0 || x < 0 || y >= n || x >= m) {
		return 0;
	}
	if (arr[y][x] == 10) {
		return 0;
	}
	if (visited[y][x] == 1) { // 싸이클이 생기면 압도적으로 큰 값을 내뱉어서 마지막에 987654321보다 큰값이 나올거임
		return 987654321;
	}
	int& ret = dp[y][x];
	if (ret != 0) {
		return ret;
	}
	for (int i = 0; i < 4; i++) {
		visited[y][x] = 1;
		ret = max(go(y + (dy[i]*arr[y][x]), x + (dx[i] * arr[y][x])) + 1, ret);
		visited[y][x] = 0;
	}
	return ret;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		string str;
		cin >> str;
		for (int j = 0; j < m; j++) {
			if (str[j] == 'H') {
				arr[i][j] = 10;
			}
			else {
				arr[i][j] = str[j]-'0';
			}
		}
	}
	int cost = go(0, 0);
	if (cost >= 987654321) { // 이값을 기준으로 이 값보다 크면 싸이클이 존재하는거임
		cout << -1;
	}
	else {
		cout << cost;
	}
}