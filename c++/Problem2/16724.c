#include <bits/stdc++.h>

using namespace std;

int n, m;
string str;
int ret;

int visited[1001][1001];
int arr[1001][1001];

int dy[] = { -1,0,1,0 };
int dx[] = { 0,1,0,-1 };

void go(int y, int x, int flag) {
    visited[y][x] = flag;
    queue<pair<int, int>> q;
    q.push({ y,x });
    while (q.size()) {
        int hx = q.front().second;
        int hy = q.front().first;
        q.pop();
        int nx = hx + dx[arr[hy][hx]];
        int ny = hy + dy[arr[hy][hx]];
        if (visited[ny][nx] == 0) {
            visited[ny][nx] = flag;
            q.push({ ny,nx });
        }
        else if (visited[ny][nx] != flag){
            ret--;
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m;

    for (int i = 0; i < n; i++) {
        cin >> str;
        
        for (int j = 0; j < m; j++) {
            if (str[j] == 'U')
                arr[i][j] = 0;
            else if (str[j] == 'D')
                arr[i][j] = 2;
            else if (str[j] == 'L')
                arr[i][j] = 3;
            else
                arr[i][j] = 1;
        }
        
    }
    int cnt = 1;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < m; j++) {
            if(visited[i][j] == 0){
                go(i,j,cnt);
                ret++;
                cnt++;
            }
        }
    }

    cout << ret;
}
