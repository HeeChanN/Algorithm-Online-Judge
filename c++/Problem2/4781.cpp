#include<bits/stdc++.h>
using namespace std;
int dp[10002];
int n;
double m;

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (cin >> n >> m) { // m 은 최대 비용
		if (n == 0 && m == 0) {
			break;
		}
		int max_cost = (m * 100)+0.5;
		int c;
		double p;
		int ret = 0;
		memset(dp, -1, sizeof(dp));
		dp[0] = 0;
		for (int i = 0; i < n; i++) {
			cin >> c >> p;
			int tmp = (p * 100) + 0.5;
			for (int j = tmp; j <= max_cost; j++) {
				if (dp[j - tmp] == -1) {
					continue;
				}
				else{
					dp[j] = max(dp[j], dp[j - tmp] + c);
					ret = max(dp[j], ret);
				}
			}
			
		}
		cout << ret << '\n';


	}
}