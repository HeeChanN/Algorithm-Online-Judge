#include<bits/stdc++.h>
using namespace std;
int n, k;
vector<int>v;
int dp[10001];
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int tmp;
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> tmp;
		v.push_back(tmp);
	}
	sort(v.begin(), v.end());

	for (int i = 1; i <= k; i++) {
		for (int j = 0; j < n; j++) {
			if (i < v[j]) {
				break;
			}
			if (i % v[j] != 0 && dp[i-v[j]]==0) {
				continue;
			}
			if (dp[i] == 0) {
				dp[i] = dp[i - v[j]] + 1;
			}
			else {
				if (dp[i] > dp[i - v[j]]) {
					dp[i] = dp[i - v[j]] + 1;
				}
			}
		}
	}
	if (dp[k] == 0) {
		cout << -1;
	}
	else {
		cout << dp[k];
	}
}