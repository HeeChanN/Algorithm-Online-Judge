#include<bits/stdc++.h>
using namespace std;

int n, l;
int idx;
int ret;
int main() {
	cin >> n>>l;
	vector<pair<int, int>> v(n);
	for (int i = 0; i < n; i++) {
		cin >> v[i].first >> v[i].second;
	}
	sort(v.begin(), v.end());

	for (int i = 0; i < v.size(); i++) {
		if (idx < v[i].first) {
			idx = v[i].first;
		}
		while (idx < v[i].second) {
			idx = idx + l;
			ret++;
		}
	}
	cout << ret;


}