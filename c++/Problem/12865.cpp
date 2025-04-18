#include<bits/stdc++.h>
using namespace std;

int n, lim;
int dp[100001];

int main() {
	cin >> n >> lim;
	for (int i = 0; i < n; i++) {
		int weight, value;
		cin >> weight >> value;
		for (int j = lim; j >= weight; j--) {
			dp[j] = max(dp[j], dp[j - weight] + value);
		}

	}
	cout << dp[lim];
	
}