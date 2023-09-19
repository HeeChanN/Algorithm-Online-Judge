#include <bits/stdc++.h>

using namespace std;

int n, c;
long long ret;
int arr[31];
vector<int> dp1, dp2;


void go(int idx, int limit, vector<int> &v, int sum) {
	if (sum > c)
		return;
	if (idx > limit)
	{
		v.push_back(sum);
		return;
	}
	go(idx + 1, limit, v, sum + arr[idx]);
	go(idx + 1, limit, v, sum);
	return ;
}



int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> c;

	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}


	go(0, n / 2 - 1, dp1, 0);
	sort(dp1.begin(), dp1.end());
	
	go(n / 2, n - 1, dp2, 0);
	sort(dp2.begin(), dp2.end());

	for (int i : dp1)
	{
		if (c - i >= 0)
		{
			ret = ret + (int)(upper_bound(dp2.begin(), dp2.end(), c - i) - dp2.begin());
		}
	}
	cout << ret;
}