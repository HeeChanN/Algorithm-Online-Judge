#include<bits/stdc++.h>
using namespace std;
string s;
int a;
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	while (cin >> s >> a) {
		vector<string> v;
		int cnt = 0;
		v.push_back(s);
		do {
			cnt++;
			if (cnt == a) {
				cout << s<<" "<<a<<" = "<< v[0]<<'\n';
				break;
			}
		} while (next_permutation(v[0].begin(), v[0].end()));
		if (cnt < a) {
			cout<< s << " " << a << " = " << "No permutation" << '\n';
		}
	}
}