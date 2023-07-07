#include<bits/stdc++.h>
using namespace std;
long long s, c;
long long arr[1000001];
long long ret=0;
long long sum;
bool check(long long num) {
	int tmp = 0;
	for (int i = 0; i < s; i++) {
		tmp =tmp+ arr[i] / num;
		
	}
	if (tmp >= c) {
		return true;
	}
	else {
		return false;
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> s >> c;
	for (int i = 0; i < s; i++) {
		cin >> arr[i];
		sum = sum + arr[i];
	}
	int l = 1;
	int r = 1000000000;
	while (l <= r) {
		long long mid = (l + r) / (2);
		if (check(mid)) {
			ret = mid;
			l = mid + 1;
		}
		else {
			r = mid - 1;
		}
	}
	
	cout << sum-(ret*c);
}