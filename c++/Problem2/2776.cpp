#include<bits/stdc++.h>
using namespace std;
int T;
int n, m;
int arr[1000001];
int answer[1000001];

bool check(int num) {
	int left = 0;
	int right = n - 1;
	while (left <= right) {
		int mid = (left + right) / 2;
		if (arr[mid] > num) {
			right = mid - 1;
		}
		else if (arr[mid] == num) {
			return true;
		}
		else {
			left = mid + 1;
		}
	}
	return false;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> T;
	while (T--) {
		cin >> n;
		for (int i = 0; i < n; i++) {
			cin >> arr[i];
		}
		cin >> m;
		sort(&arr[0], &arr[n]);
		for (int i = 0; i < m; i++) {
			cin >> answer[i];
		}

		for (int i = 0; i < m; i++) {
			if (check(answer[i])) {
				cout << 1 << "\n";
			}
			else {
				cout << 0 << "\n";
			}
		}
	}
}