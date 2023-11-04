#include<bits/stdc++.h>

using namespace std;

int visited[104][104];
int info[104][104];
int dest[104][104];
queue<pair<int, int>> q;

int dy[] = { -1, 0, 1, 0 };
int dx[] = { 0, 1, 0, -1 };

int n, m;
string str;

void bfs(int sy, int sx)
{
    visited[sy][sx] = 1;
    dest[sy][sx] = 0;
    q.push({ sy,sx });
    while (q.size()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();

        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= n || nx >= m)
                continue;
            if (info[ny][nx] == 1) {
                if (dest[ny][nx] > dest[y][x] + info[ny][nx]) {
                    dest[ny][nx] = dest[y][x] + info[ny][nx];
                    q.push({ ny,nx });
                }
          
            }
            else {
                if (dest[ny][nx] > dest[y][x]) {
                    q.push({ ny ,nx });
                    dest[ny][nx] = dest[y][x] + info[ny][nx];
                }
            }
        }
    }
}

int main()
{
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> m >> n;

    for (int i = 0; i < n; i++) {
        cin >> str;
        for (int j = 0; j < m; j++) {
            info[i][j] = str[j] - '0';
        }
    }
    fill(&dest[0][0], &dest[103][104], 987654321);
    bfs(0, 0);
    cout << dest[n - 1][m - 1];
}