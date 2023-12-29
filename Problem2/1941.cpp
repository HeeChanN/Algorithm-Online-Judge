#include<bits/stdc++.h>

using namespace std;

int dy[] = { -1,0,1,0 };
int dx[] = { 0,1,0,-1 };

string str[5];
int visited[5][5];
int c[5][5] = { 0 };
int ret;

int is_valid(int y,int x) {
	memset(c, 0, sizeof(c));
	int cnt = 1;

	c[y][x] = 1;
	queue<pair<int,int>> q;
	q.push({ y,x });
	while (q.size()) {
		int py = q.front().first;
		int px = q.front().second;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = py + dy[i];
			int nx = px + dx[i];
			if (ny < 0 || nx < 0 || ny >= 5 || nx >= 5) {
				continue;
			}
			if (visited[ny][nx] == 1 && c[ny][nx] == 0) {
				c[ny][nx] = 1;
				q.push({ ny,nx });
				cnt++;
			}
		}

	}
	if (cnt == 7) {
		return 1;
	}
	else
		return 0;
}

void go(int start, int sum_y, int sum_s) {
	if (sum_y >= 4) {
		return;
	}
	if (sum_y + sum_s == 7) {
		if (is_valid((start-1)/5,(start-1)%5)) {
			ret++;
		}
		return;
	}
	for (int i = start; i < 25; i++) {
		visited[i / 5][i % 5] = 1;
		if (str[i / 5][i % 5] == 'Y')
			go(i+1, sum_y + 1, sum_s);
		else
			go(i+1, sum_y, sum_s + 1);
		visited[i / 5][i % 5] = 0;
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	for (int i = 0; i < 5; i++) {
		cin >> str[i];
	}
	go(0, 0, 0);
	cout << ret;
}