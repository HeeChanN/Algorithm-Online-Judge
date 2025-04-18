#include<bits/stdc++.h>
using namespace std;
long long m, n;
long long ret = 1e18;
vector<int> v;
bool check(long long num) {
	long long children = 0;
	for (int i = 0; i < m; i++) {
		if (v[i] % num) {
			children =children+ (v[i] / num + 1);
		}
		else {
			children =children+ (v[i] / num);
		}
	}
	return n >= children;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	long long num;
	long long left = 1;
	long long right = 0;
	for (int i = 0; i < m; i++) {
		cin >> num;
		v.push_back(num);
		right = max(num, right);
	}
	while (left <= right) {
		long long mid = (left + right) / 2;
		if (check(mid)) {
			ret = min(ret, mid);
			right = mid - 1;
		}
		else {
			left = mid + 1;
		}
	}
	cout << ret;
	
}