#include<bits/stdc++.h>
using namespace std;

int n;
int arr[12];
char oper[4];
long long  small = -100000000, big = 1000000000;
vector<int> v;
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	int num;
	for (int i = 0; i < 4; i++) {
		cin >> num;
		for (int j = 0; j < num; j++) {
			v.push_back(i);
		}
	}

	do {
		int cnt = 1;
		long long ret = arr[0];
		for (int i = 0; i < v.size(); i++) {
			switch (v[i]) {
			case 0:
				ret = ret + arr[cnt++];
				break;
			case 1:
				ret = ret - arr[cnt++];
				break;
			case 2:
				ret = ret * arr[cnt++];
				break;
			case 3:
				ret = ret / arr[cnt++];
				break;
			}
		}
		small = max(ret, small);
		big = min(ret, big);
	} while (next_permutation(v.begin(), v.end()));

	cout << small << "\n" << big;
}