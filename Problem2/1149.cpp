#include<bits/stdc++.h>
using namespace std;

int n;
int dp[2][100001][2];
int arr[2][100001];
// 선택할지 말지로 바꿔야함
int go(int y,int x,int flag) {
	if (x >= n || y >= 2) {
		return 0;
	}


	int& ret = dp[y][x];
	if (ret != -1) {
		return ret;
	}
	int check, nocheck = 0;
	if (flag != 1) {
		check = max(go(y, x + 1, 1), go(y + 1, x, 1)) + arr[y][x];
	}
	nocheck = max(go(y, x + 1, 0), go(y + 1, x, 0));

	ret = max(check, nocheck);

	return ret;
	
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(null);

	int t;
	cin >> t;
	while (t--) {
		cin >> n;
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				cin >> arr[i][j];
			}
		}
		memset(dp, -1, sizeof(dp));
		cout << go(0, 0, 0)<<'\n';
	}
}