#include<bits/stdc++.h>
using namespace std;
int n, m;
int arr[1002][1002];
int visited[1002][1002][2];
int dy[] = { -1,0,1,0 };
int dx[] = { 0,1,0,-1 };
int ret=-1;
struct A {
	int y;
	int x;
	int block;
};

void bfs(A start) {
	visited[start.y][start.x][1] = 1;
	queue<A> q;
	q.push(start);

	while (q.size()) {
		int y = q.front().y;
		int x = q.front().x;
		int block = q.front().block;
		q.pop();

		for (int i = 0; i < 4; i++) {
			int ny = y + dy[i];
			int nx = x + dx[i];
			if (ny < 0 || nx < 0 || nx >= m || ny >= n || visited[ny][nx][block]) {
				continue;
			}
			
			if (ny == n - 1 && nx == m - 1) {
				ret = visited[y][x][block] + 1;
				return;
			}
			if (arr[ny][nx] == 1 && block == 0) {
				continue;
			}
			else if (arr[ny][nx] == 1 && block == 1) {
				visited[ny][nx][0] = visited[y][x][1] + 1;
				A tmp;
				tmp.y = ny;
				tmp.x = nx;
				tmp.block = 0;
				q.push(tmp);
			}
			else {
				visited[ny][nx][block] = visited[y][x][block] + 1;
				A tmp;
				tmp.y = ny;
				tmp.x = nx;
				tmp.block = block;
				q.push(tmp);
			}

		}

	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;
	string str;

	for (int i = 0; i < n; i++) {
		cin >> str;
		for (int j = 0; j < m; j++) {
			arr[i][j] = str[j] - '0';
		}
	}

	A start;
	start.y = start.x = 0;
	start.block = 1;

	bfs(start);
	if (n == 1 && m == 1) {
		cout << "1";
	}
	else if (ret==-1) {
		cout << -1;
	}
	else {
		cout << ret;
	}
}