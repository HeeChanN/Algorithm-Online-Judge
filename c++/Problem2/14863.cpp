#include<bits/stdc++.h>

using namespace std;

int n, k;

struct vehicle {
	int min;
	int price;
};

vehicle walk[101];
vehicle bike[101];

int dp[100][100004];

int go(int city, int sum) {
	if (sum > k) {
		return -987654321;
	}
	if (city == n) {
		return 0;
	}

	int& ret = dp[city][sum];
	if (ret != 0) {
		return ret;
	}

	int w = go(city + 1, sum + walk[city].min) + walk[city].price;
	int b = go(city + 1, sum + bike[city].min) + bike[city].price;
	ret = max(w, b);
	
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> k;
	for (int i = 0; i < n; i++) {
		cin >> walk[i].min >> walk[i].price >> bike[i].min >> bike[i].price;
	}
	cout <<go(0, 0);
}