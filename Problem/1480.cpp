#include <bits/stdc++.h>

using namespace std;


int n, m, c;
int arr[15];
int dp[12][22][1 << 14];


int go(int idx, int lim, int jewl)
{
	if (idx == m)
	{
		return 0;
	}
	int &ret = dp[idx][lim][jewl];
	if (ret != 0)
		return ret;

	int no = go(idx + 1, c, jewl);
	for (int i = 0; i < n; i++) {
		int jflag = (1 << i) & jewl;
		int cflag = 0;

		if ((lim - arr[i]) >= 0)
			cflag = 1;

		if (jflag == 0 && cflag == 1)
			ret = max(ret, go(idx, lim - arr[i], jewl | (1 << i)) + 1);
	}
	ret = max(no, ret);
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> c;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	cout << go(0, c, 0);
}