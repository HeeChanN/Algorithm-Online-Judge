#include<bits/stdc++.h>

using namespace std;

int n;
int arr[101];
long long dp[100][22];
long long go(int idx, int num) {
	if (num < 0 || num >20) {
		return 0;
	}
	if (idx == n - 2) {
		if (num == arr[n - 1]) {
			return 1;
		}
		else {
			return 0;
		}
	}

	long long & ret = dp[idx][num];
	if (ret != -1) {
		return ret;
	}

	ret = go(idx + 1, num + arr[idx + 1]) + go(idx + 1, num - arr[idx + 1]);

	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}

	fill(&dp[0][0], &dp[99][22], -1);

	cout << go(0, arr[0]);
}