#include<bits/stdc++.h>
using namespace std;
int n;
int ret;
struct Board {
	int a[21][21];

	void left() {
		int tmp[21][21];
		for (int i = 0; i < n; i++) {
			int prev = 0, start = -1;
			for (int j = 0; j < n; j++) {
				if (a[i][j] == 0) {
					continue;
				}
				if (prev == 1 && a[i][j] == tmp[i][start]) {
					tmp[i][start] *= 2;
					prev = 0;
				}
				else {
					start++;
					tmp[i][start] = a[i][j];
					prev = 1;

				}
			}
			for (int j = start + 1; j < n; j++) {
				tmp[i][j] = 0;
			}
		}
		memcpy(a, tmp, sizeof(a));
	}
	void right() {
		int tmp[21][21];
		for (int i = 0; i < n; i++) {
			int prev = 0, start = n;
			for (int j = n-1; j >=0; j--) {
				if (a[i][j] == 0) {
					continue;
				}
				if (prev == 1 && a[i][j] == tmp[i][start]) {
					tmp[i][start] *= 2;
					prev = 0;
				}
				else {
					start--;
					tmp[i][start] = a[i][j];
					prev = 1;

				}
			}
			for (int j = start -1; j >= 0; j--) {
				tmp[i][j] = 0;
			}
		}
		memcpy(a, tmp, sizeof(a));
	}
	void up() {
		int tmp[21][21];
		for (int i = 0; i < n; i++) {
			int prev = 0, start = -1;
			for (int j = 0; j < n; j++) {
				if (a[j][i] == 0) {
					continue;
				}
				if (prev == 1 && a[j][i] == tmp[start][i]) {
					tmp[start][i] *= 2;
					prev = 0;
				}
				else {
					start++;
					tmp[start][i] = a[j][i];
					prev = 1;

				}
			}
			for (int j = start + 1; j < n; j++) {
				tmp[j][i] = 0;
			}
		}
		memcpy(a, tmp, sizeof(a));
	}
	void down() {
		int tmp[21][21];
		for (int i = 0; i < n; i++) {
			int prev = 0, start = n;
			for (int j = n-1; j >= 0; j--) {
				if (a[j][i] == 0) {
					continue;
				}
				if (prev == 1 && a[j][i] == tmp[start][i]) {
					tmp[start][i] *= 2;
					prev = 0;
				}
				else {
					start--;
					tmp[start][i] = a[j][i];
					prev = 1;

				}
			}
			for (int j = start -1; j >= 0; j--) {
				tmp[j][i] = 0;
			}
		}
		memcpy(a, tmp, sizeof(a));
	}
	
};





void go(Board c, int cnt) {
	if (cnt == 5) {
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n; j++) {
				ret = max(ret, c.a[i][j]);
			}
		}

		return;
	}
	for (int i = 0; i < 4; i++) {
		Board d = c;
		switch (i) {
			case 0:
				d.up();
				break;
			case 1:
				d.left();
				break;
			case 2:
				d.down();
				break;
			case 3:
				d.right();
				break;
		}
		go(d, cnt + 1);
		
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	Board c;

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> c.a[i][j];
		}
	}

	go(c, 0);
	cout << ret << "\n";


}