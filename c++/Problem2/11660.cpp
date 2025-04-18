#include<bits/stdc++.h>
using namespace std;
int n;
int t;
int arr[1025][1025];
int arr_sum[1025][1025];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> t;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
			if (j == 0) {
				arr_sum[i][j] = arr[i][j];
			}
			else {
				arr_sum[i][j] = arr_sum[i][j-1] + arr[i][j];
			}
		}
	}
	int y, x, ny, nx;
	for (int i = 0; i < t; i++) {
		int ret = 0;
		cin >> y >> x >> ny >> nx;
		for (int j = y; j <= ny; j++) {
			ret = ret + arr_sum[j - 1][nx - 1] - arr_sum[j - 1][x - 2];
		}
		cout << ret << '\n';
	}
}