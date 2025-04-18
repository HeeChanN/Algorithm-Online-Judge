#include<bits/stdc++.h>

using namespace std;

int num;
int arr[100004];
int i;

int dp[5][5][100004];

int power(int prev, int next) {
	if (prev == next)
		return 1;
	if (prev == 0)
		return 2;
	if (prev + 2 == next || prev - 2 == next)
		return 4;
	return 3;
}

int go(int l, int r, int cnt)
{
	if (l == r)
		return 987654321;
	if (cnt == i)
		return 0;
	int& ret = dp[l][r][cnt];
	if (ret != 987654321) {
		return ret;
	}
	int left = go(arr[cnt], r, cnt + 1) + power(l, arr[cnt]);
	int right = go(l, arr[cnt], cnt + 1) + power(r, arr[cnt]);
	ret = min(left, right);
	if (ret > 987654321)
		return 987654321;
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (1)
	{
		cin >> num;
		if (num == 0) {
			break;
		}
		arr[i] = num;
		i++;
	}
	fill(&dp[0][0][0], &dp[4][4][100004], 987654321);
	if (i == 0)
	{
		cout << "0";
	}
	else {
		cout << go(arr[0], 0, 1) + 2;
	}
}