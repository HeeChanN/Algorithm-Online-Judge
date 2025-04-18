#include<bits/stdc++.h>
using namespace std;
int arr[1000001]; 
int list_idx[1000001]; 
int n;
int ret[1000001]; 
vector<int> v;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int len = 0;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
		if (i == 0) {
			ret[0] = arr[0];
			list_idx[0] = 0;
			len++;
			continue;
		}
		if (ret[len - 1] < arr[i]) {
			ret[len] = arr[i];
			list_idx[i] = len;
			len++;
		}
		else {
			auto pos = lower_bound(ret, ret + len, arr[i]);
			int _pos = (int)(lower_bound(ret, ret + len, arr[i]) - ret);
			*pos = arr[i];
			list_idx[i] = _pos;

		}
	}

	cout << len << '\n';
	int start = len - 1;

	for (int i = n - 1; i >= 0; i--) {
		if (start == list_idx[i]) {
			v.push_back(arr[i]);
			start--;
		}
	}
	for (int i = v.size() - 1; i >= 0; i--) {
		cout << v[i] << ' ';
	}
}