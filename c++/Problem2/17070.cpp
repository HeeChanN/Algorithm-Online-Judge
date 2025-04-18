#include<bits/stdc++.h>
using namespace std;
int n;
int arr[18][18];
int dp[18][18][3];

int go(int y,int x,int dir) {
	if (dir == 0 || dir == 1) { // º®ÀÌ¸é ¾ÈµÊ
		if (arr[y][x] == 1) {
			return 0;
		}

	}
	if (dir == 2) {
		if (arr[y][x] == 1 || arr[y - 1][x] == 1 || arr[y][x - 1] == 1) {
			return 0;
		}
	}
	if (y == n - 1 && x == n - 1) {
		return 1;
	}
	
	if (y >= n || x >= n) {
		return 0;
	}

	int& ret = dp[y][x][dir];
	if (ret != -1) {
		return ret;
	}
	ret = 0;
	if (dir == 0) {
		ret = ret + go(y, x + 1, 0) + go(y + 1, x + 1, 2);
	}
	else if (dir == 1) {
		ret = ret + go(y + 1, x, 1) + go(y + 1, x + 1, 2);
	}
	else if (dir == 2) {
		ret = ret + go(y, x + 1, 0) + go(y + 1, x, 1) + go(y + 1, x + 1, 2);
	}

	return ret;
}


int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
		}
	}
	memset(dp, -1, sizeof(dp));
	cout <<go(0, 1, 0);
}