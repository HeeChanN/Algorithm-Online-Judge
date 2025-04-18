#include<bits/stdc++.h>

using namespace std;

int dy[] = {-1,0,1,0};
int dx[] = { 0,1,0,-1 };

int n;
string board[100];
int visited[100][100];

int ret, ret2;

void go(int y, int x) {
	char color = board[y][x];
	if (color == 'R') {
		board[y][x] = 'G';
	}


	visited[y][x] = 1;


	queue<pair<int, int>> q;
	q.push({ y,x });
	while (q.size()) {
		int py = q.front().first;
		int px = q.front().second;
		q.pop();
		for (int i = 0; i < 4; i++) {
			int ny = py + dy[i];
			int nx = px + dx[i];
			if (ny >= n || nx >= n || ny < 0 || nx < 0 || visited[ny][nx] == 1) {
				continue;
			}
			if (board[ny][nx] != color) {
				continue;
			}
			if (board[ny][nx] == 'R') {
				board[ny][nx] = 'G';
			}
			visited[ny][nx] = 1;
			q.push({ ny,nx });
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;

	for (int i = 0; i < n; i++) {
		cin >> board[i];
	}

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visited[i][j] == 0) {
				go(i, j);
				ret++;
			}
		}
	}
	memset(visited, 0, sizeof(visited));

	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			if (visited[i][j] == 0) {
				go(i, j);
				ret2++;
			}
		}
	}
	cout << ret << " " << ret2 << "\n";
}