#include<bits/stdc++.h>
using namespace std;
int n, k;
int cnt;
int flag;
int arr[101][101];
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
struct A {
	int y;
	int x;
};
deque<A> d;

// 대가리랑 맨뒤만 움직이면 됨
bool move(int idx) {
	int a = 0;
	A prev;
	int i = 0;
	int limit = d.size();
	int fruit = 0;
	while (i < limit) {
		i++;
		A tmp;
		tmp = d.front();
		if (a == 0) { // 머리 이동
			prev = tmp;
			tmp.y = tmp.y + dy[idx];
			tmp.x = tmp.x + dx[idx];
			if (tmp.y >= n || tmp.x >= n || tmp.y < 0 || tmp.x < 0 || arr[tmp.y][tmp.x] == 1) {
				return false;
			}
			if (arr[tmp.y][tmp.x] == 2) {
				fruit = 1;
			}
			arr[tmp.y][tmp.x] = 1;
			a = 1;
			d.pop_front();
			d.push_back(tmp);
		}
		else { // 나머지 이동
			d.pop_front();
			d.push_back(prev);
			prev = tmp;
		}
	}

	if (fruit == 0) {
		arr[prev.y][prev.x] = 0;
	}
	else {
		arr[prev.y][prev.x] = 1;
		d.push_back(prev);
	}
	return true;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> k;
	int y, x;
	for (int i = 0; i < k; i++) {
		cin >> y >> x;
		arr[y-1][x-1] = 2;
	}

	int L;
	cin >> L;
	A tmp;
	tmp.y = 0;
	tmp.x = 0;
	d.push_back(tmp);
	arr[0][0] = 1;
	int rotate=0;

	for (int i = 0; i < L; i++) {
		int t;
		char d;
		cin >> t >> d;
		while (cnt < t) {
			cnt++;
			if (move(rotate) == 0) {
				flag = 1;
				break;
			}

		}
		if (flag == 1) {
			break;
		}
		if (d == 'D') {
			rotate = (rotate + 1) % 4;
		}
		else {
			rotate = rotate - 1;
			if (rotate < 0) {
				rotate = rotate + 4;
			}
		}
	}

	if (flag == 0) {
		while (move(rotate)) {
			cnt++;
		}
		cnt++;
		cout << cnt;
	}
	else {
		cout << cnt;
	}

}