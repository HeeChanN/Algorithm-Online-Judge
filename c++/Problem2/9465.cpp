#include<bits/stdc++.h>
using namespace std;

int n;
int dp[100001][3];
int arr[2][100001];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	int t;
	cin >> t;
	while (t--) {
		int ret = 0;
		cin >> n;
		
		for (int i = 0; i < 2; i++) {
			for (int j = 0; j < n; j++) {
				cin >> arr[i][j];
			}
		}
		memset(dp, -1, sizeof(dp));

		dp[0][0] = arr[0][0];
		dp[0][1] = arr[1][0];
		dp[0][2] = 0;

		for (int i = 1; i <n ; i++) {
			dp[i][0] = max(dp[i - 1][1], dp[i - 1][2]) + arr[0][i];
			dp[i][1] = max(dp[i - 1][0], dp[i - 1][2]) + arr[1][i];
			dp[i][2] = dp[i - 1][0] > dp[i - 1][1] ? max(dp[i - 1][0], dp[i - 1][2]) : max(dp[i - 1][1], dp[i - 1][2]);
		}
		ret = max(dp[n - 1][0], dp[n - 1][1]);
		ret = max(ret, dp[n - 1][2]);

		cout << ret << '\n';


	}
}