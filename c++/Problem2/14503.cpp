#include <bits/stdc++.h>

using namespace std;

int dy[] = { -1,0,1,0 };
int dx[] = { 0,1,0,-1 };

pair<int, int> start;
int dir;
int board[52][52];

int go(int i, int j) {
    int cnt = 0;
    queue<pair<int, int>> q;
    q.push({ i,j });

    while (q.size()) {
        int y = q.front().first;
        int x = q.front().second;
        if (board[y][x] == 0) {
            board[y][x] = 2;
            cnt++;
        }
        q.pop();
        int blank = 0;
        for (int k = 0; k < 4; k++) {
            int ny = dy[k] + y;
            int nx = dx[k] + x;
            if (board[ny][nx] == 0) {
                blank = 1;
                break;
            }
        }
        if (blank == 0) {
            int ny = y + dy[(dir + 2) % 4];
            int nx = x + dx[(dir + 2) % 4];
            if (board[ny][nx] == 1) {
                return cnt;
            }
            q.push({ ny,nx });
        }
        else {
            int tmp = 4;
            while (tmp--) {
                dir = (dir - 1 + 4) % 4;
                int ny = y + dy[dir];
                int nx = x + dx[dir];
                if (board[ny][nx] == 0) {
                    q.push({ ny,nx });
                    break;
                }
            }
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int n, m;
    cin >> n >> m;

    cin >> start.first >> start.second >> dir;

    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            cin >> board[i][j];
        }
    }
    cout << go(start.first, start.second);
}