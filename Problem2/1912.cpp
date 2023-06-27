#include<bits/stdc++.h>
using namespace std;

int n;
int arr[100001];
int ret;
int m = -1000;
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		if (ret== 0) {
			ret = arr[i];
			m = max(m, ret);
			if (ret < 0) {
				ret = 0;
			}
			continue;
		}
		ret = ret + arr[i];
		if (ret < 0) {
			ret = ret - arr[i];
			m = max(m, ret);
			ret = 0;
		}
		m = max(m, ret);
	}
	cout << m;
}