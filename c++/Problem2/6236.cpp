#include<bits/stdc++.h>
using namespace std;

int n, m;
int arr[100001];
int l = 0;
int sum = 0;
int ret = 1000000000;
bool check(int num) {
	int cnt = 0;
	int money = 0;
	for (int i = 0; i < n; i++) {
		if (money == 0 || arr[i]>money) {
			cnt++;
			money = num;
		}
		money = money - arr[i];

	}

	if (m >= cnt) {
		return true;
	}
	else {
		return false;
	}
	
}

int main() {
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		l = max(arr[i], l);
		sum = sum + arr[i];
	}
	int r = sum;
	while (l <= r) {
		int mid = (l + r) / 2;
		if (check(mid)) {
			ret = min(ret, mid);
			r = mid - 1;
		}
		else {
			l = mid + 1;
		}
	}
	cout << ret;
}