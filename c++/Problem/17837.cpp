#include<bits/stdc++.h>
using namespace std;

int n, k;
int arr[13][13];
int ret;
int dx[] = {0, 1,-1,0,0 };
int dy[] = {0, 0,0,-1,1 };

struct A {
	int y;
	int x;
	int dir;
};
vector<A> mal;
vector<int> board[14][14];

void move(int i) {
	int y = mal[i].y;
	int x = mal[i].x;
	int dir = mal[i].dir;

	int ny = y + dy[dir];
	int nx = x + dx[dir];

	if (ny > n || nx > n || ny < 1 || nx < 1||arr[ny][nx]==2 ) {
		if (mal[i].dir == 1) {
			mal[i].dir = 2;
		}
		else if (mal[i].dir == 2) {
			mal[i].dir = 1;
		}
		else if (mal[i].dir == 3) {
			mal[i].dir = 4;
		}
		else if (mal[i].dir == 4) {
			mal[i].dir = 3;
		}

		ny = y + dy[mal[i].dir];
		nx = x + dx[mal[i].dir];

		if (ny > n || nx > n || ny < 1 || nx < 1 || arr[ny][nx] == 2) {
			return;
		}
	}

	vector<int>& here_v = board[y][x];
	vector<int>& next_v = board[ny][nx];
	auto pos = find(here_v.begin(), here_v.end(), i);
	if (arr[ny][nx] == 1) {
		reverse(pos, here_v.end());
	}
	for (auto it = pos; it != here_v.end(); it++) {
		next_v.push_back(*it);
		mal[*it].y = ny;
		mal[*it].x = nx;
	}
	here_v.erase(pos, here_v.end());
	return;

}

bool gameOver() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (board[i][j].size() >= 4) {
				return 1;
			}
		}
	}
	return 0;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);

	cin >> n >> k;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> arr[i][j];
		}
	}
	mal.push_back({0,0,0});
	for (int i = 1; i <= k; i++) {
		A tmp;
		cin >> tmp.y >> tmp.x >> tmp.dir;
		mal.push_back(tmp);
		board[tmp.y][tmp.x].push_back(i);
	}


	int i = 1;
	int flag = 0;
	for (i; i <= 1000; i++) {
		for (int j = 1; j <= k; j++) { // ��縻 �����̱�;
			move(j);
			if (gameOver()) {
				flag = 1;
				break;
			}
		}
		if (flag == 1) {
			break;
		}
	}

	if (flag==0) {
		cout << -1;
	}
	else {
		cout << i;
	}

}


/* 1. vector<int> v[y][x] �� �迭�� ��Ҹ� ���ͷ� ���� �� ����. ���ǿ� ���� ���� �����ϴ°� ��������
*  2. (y,x) ��ǥ�� �ִ� ���͸� �ս��� ����ϴ� ���� & ������ �̿��ϱ�
*  3. vector<int> &tmp = v[y][x] --> (y,x) ��ǥ�� �ִ� ���͸� tmp�� ǥ���ϴµ� ��ȭ�� ������
*  4.  find(tmp.begin(),tmp.end(),1), reverse(tmp.begin(), tmo.end() ) �� ���� ���� ������ �ս��� ���� ����
*  5. �̷� ������� �̿��ؼ� ���߿��� ���������� ������ Ǯ���!



*/