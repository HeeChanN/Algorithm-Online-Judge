#include<bits/stdc++.h>
using namespace std;
int n, m;
long long arr[10002];
long long cnt;
long long ret;
bool check(long long num) {
	cnt = 0;
	for (int i = 0; i < m; i++) {
		if (i == 0) {
			cnt = cnt + m;
		}
		cnt = cnt + num / arr[i];
	}
	if (cnt >= n) {
		return true;
	}
	else {
		return false;
	}

}
int main() {
	cin >> n >> m; // n�� ���� ��, m�� ���̱ⱸ ��
	for (int i = 0; i < m; i++) {
		cin >> arr[i];
	}
	if (n <= m) {
		cout << n;
		return 0;
	}
	long long l = 0;
	long long r = 60000000001;
	while (l <= r) {
		long long mid = (l + r) / 2;
		if (check(mid)) {
			ret = mid;
			r = mid - 1;
		}
		else {
			l = mid + 1;
		}

	}// �ѽð� ���ϱ�

	cnt = 0;
	for (int i = 0; i < m; i++) {
		if (i == 0) {
			cnt = cnt + m;
		}
		cnt = cnt + ((ret - 1) / arr[i]);
	} // 1�� �������� ������
	for (int i = 0; i < m; i++) {
		if (ret % arr[i] == 0) {
			cnt++;
			if (cnt == n) {
				cout << i + 1;
				break;
			}
		}
	}

}