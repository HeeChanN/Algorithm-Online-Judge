#include<bits/stdc++.h>
using namespace std;
int m, n;
int pizza;
int a, b;
int arr[1004];
int arr2[1004];
vector<int> v;
vector<int> v2;
int ret;
int main() {
	cin >> pizza;
	cin >> m >> n;

	for (int i = 0; i < m; i++) {
		cin >> arr[i];
		a = a + arr[i];
	}
	for (int i = 0; i < n; i++) {
		cin >> arr2[i];
		b = b + arr2[i];
	}
	// A 피자 나누기
	for (int i = 0; i < m; i++) {
		int sum = 0;
		for (int j = i; j < m + i - 1; j++) {
			sum = sum + arr[j % m];
			v.push_back(sum);
		}
		
	}
	v.push_back(a);
	// B 피자 나누기
	for (int i = 0; i < n; i++) {
		int sum = 0;
		for (int j = i; j < n + i - 1; j++) {
			sum = sum + arr2[j % n];
			v2.push_back(sum);
		}
	}
	v2.push_back(b);

	sort(v.begin(), v.end());
	sort(v2.begin(), v2.end());

	//피자 제공 가지 수 세기 --> 투포인터
	int i = 0;
	int j = v2.size() - 1;
	while (i < v.size() && j >= 0) {
		int pizza_A = v[i];
		int pizza_B = v2[j];
		if (pizza_A + pizza_B == pizza) {
			int acnt = 0;
			while (i < v.size() && v[i] == pizza_A) {
				acnt++;
				i++;
			}
			int bcnt = 0;
			while (j >= 0 && v2[j] == pizza_B) {
				bcnt++;
				j--;
			}
			ret += acnt * bcnt;
		}

		if (pizza_A + pizza_B < pizza) {
			i++;
		}
		if (pizza_A + pizza_B > pizza) {
			j--;
		}
	}

	for (int i = 0; i < v.size(); i++) {
		if (v[i] == pizza) {
			ret++;
		}
	}
	for (int i = 0; i < v2.size(); i++) {
		if (v2[i] == pizza) {
			ret++;
		}
	}
	
	cout << ret;


}