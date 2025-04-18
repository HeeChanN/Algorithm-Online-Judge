#include<bits/stdc++.h>
using namespace std;
int n;
int dy[] = { 0,-1,0,1 };
int dx[] = { 1,0,-1,0 };
struct A {
	int x, y;
	int d; // 커브 방향
	int g; // 커브 단계
};
A curve; //커브 정보
int visited[104][104];
int ret;
void moveCurve() {
	int cnt = 0;
	stack<int> s;
	int ny = curve.y + dy[curve.d];
	int nx = curve.x + dx[curve.d];
	while (cnt <= curve.g) {
		if (cnt == 0) {
			s.push(curve.d);
			visited[curve.y][curve.x] = 1;
			visited[ny][nx] = 1;
		}
		else {
			stack<int> tmp = s;
			while (tmp.size()) {
				int a = tmp.top();
				tmp.pop();
				a = (a + 1) % 4;
				ny = ny + dy[a];
				nx = nx + dx[a];
				visited[ny][nx] = 1;
				s.push(a);
			}
		}
		cnt++;
	}
}
int main() {
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> curve.x >> curve.y >> curve.d >> curve.g;
		moveCurve();
	}
	for (int i = 0; i < 101; i++) {
		for (int j = 0; j < 101; j++) {
			if (visited[i][j] == 1) {
				if (visited[i + 1][j] == 1 && visited[i][j + 1] == 1 && visited[i + 1][j + 1] == 1) {
					ret++;
				}
			}
		}
	}
	cout << ret;
	
}