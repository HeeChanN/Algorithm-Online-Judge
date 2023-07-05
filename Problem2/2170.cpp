#include<bits/stdc++.h>
using namespace std;
int n;
vector<pair<int, int>> v;
long long ret;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	int a, b;
	for (int i = 0; i < n; i++) {
		cin >> a >> b;
		v.push_back({ a,b });
	}
	sort(v.begin(), v.end());

	int start = -1000000001;
	for (int i = 0; i < n; i++) {
		if (v[i].first > start) {
			start = v[i].first;
		}
		else if (v[i].first < start && v[i].second <start) {
			continue;
		}
		ret = ret + (v[i].second - start);
		start = v[i].second;
	}
	cout << ret;
}