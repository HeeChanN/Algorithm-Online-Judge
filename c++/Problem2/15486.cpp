#include<bits/stdc++.h>
using namespace std;
int n,cost;
int T[1500001];
int P[1500001];
int dp[1500001];

int go(int num) {
	if (num>n) { 
		return 0;
	}
	int& ret = dp[num];
	if (ret != 0) {
		return ret;
	}
	int select = 0;
	int unselect = 0;
	if (num + T[num] - 1 <= n) {
		select = go(num + T[num]) + P[num];
	}
	unselect = go(num + 1);
	ret = max(select, unselect);
	return ret;

}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> T[i] >> P[i];
	}

	cout << go(1);
}