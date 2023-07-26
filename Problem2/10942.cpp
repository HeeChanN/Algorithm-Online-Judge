#include<bits/stdc++.h>
using namespace std;
int n, m;
int dp[2001][2001];
int arr[2001];

int go(int s, int e) {
	if (s == e) {
		return 1;
	}
	if (s > e) {
		return 1;
	}
	int& ret = dp[s][e];
	if (ret != -1) {
		return ret;
	}
	
	if (arr[s] == arr[e]) {
		ret = go(s + 1, e - 1);
	}
	else {
		ret = 0;
	}
	return ret;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	cin >> m;
	int s, e;
	memset(dp, - 1,sizeof(dp));
	for (int i = 0; i < m; i++) {
		cin >> s >> e;
		cout<<go(s, e)<<'\n';
		
	}

}