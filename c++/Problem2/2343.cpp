#include<bits/stdc++.h>
using namespace std;
int n, m;
long long lef = 1;
long long sum = 0;
int arr[100004];
long long ret =1e16;
bool check(int num) { // 해당 크기로 각 블루레일 설정시 들어가는지 확인
	int j = 0;
	long long tmp = 0;
	for (int i = 0; i < n; i++) {
		if ((tmp + arr[i]) > num) {
			j++;
			tmp = 0;
			tmp = tmp + arr[i];
		}
		else {
			tmp = tmp + arr[i];
		}
	}

	if (j >= m) {
		return false;
	}
	else {
		return true;
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		sum = sum + arr[i];
		lef = max(lef, (long long)arr[i]);
	}
	long long right = sum;
	while (lef <= right) {
		long long mid = (lef + right) / 2;
		if (check(mid)) {
			ret = min(ret, mid);
			right = mid - 1;
		}
		else {
			lef = mid + 1;
		}
	}
	cout << ret;

}