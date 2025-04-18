#include <bits/stdc++.h>
using namespace std;

int visited[102][102];
int ret;
int cnt;

int dy[] = { -1,0,1,0 };
int dx[] = { 0,1,0,-1 };

void go(int i, int j, int m, int n, vector<vector<int>> picture) {
    int value = picture[i][j];
    int loc_max = 1;

    visited[i][j] = 1;
    cnt++;
    queue<pair<int, int>> q;
    q.push({ i, j });
    while (q.size()) {
        int y = q.front().first;
        int x = q.front().second;
        q.pop();
        for (int i = 0; i < 4; i++) {
            int ny = y + dy[i];
            int nx = x + dx[i];
            if (ny < 0 || nx < 0 || ny >= m || nx >= n || visited[ny][nx] == 1)
                continue;
            if (picture[ny][nx] != value) {
                continue;
            }
            visited[ny][nx] = 1;
            q.push({ ny,nx });
            loc_max++;
        }
    }
    ret = max(ret, loc_max);
}

vector<int> solution(int m, int n, vector<vector<int>> picture) {
    int number_of_area = 0;
    int max_size_of_one_area = 0;
    cnt = 0;
    ret = 0;

    memset(visited, 0, sizeof(visited));

    for (int i = 0; i < m; i++) {
        for (int j = 0; j < n; j++) {
            if (visited[i][j] == 0 && picture[i][j] != 0)
                go(i, j, m, n, picture);
        }
    }

    number_of_area = cnt;
    max_size_of_one_area = ret;

    vector<int> answer(2);
    answer[0] = number_of_area;
    answer[1] = max_size_of_one_area;
    return answer;
}