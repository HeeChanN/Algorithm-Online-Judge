#include<bits/stdc++.h>
using namespace std;

int t;
int n, m;
int arr[21];
int dp[10002];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >>t;
	while (t--) {
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		cin >> m;
		memset(dp, 0, sizeof(dp));
		dp[0] = 1;
		for (int i = 0; i < n; i++) {
			for (int j = arr[i]; j <= m; j++) {
				if (dp[j-arr[i]] != 0) {
					dp[j] = dp[j] + dp[j - arr[i]];
				}
			}
		}
		cout << dp[m]<<'\n';
	}
}