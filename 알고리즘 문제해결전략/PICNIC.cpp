#include<bits/stdc++.h>

using namespace std;

int c;
int n, p;
int a, b;
int ret;

vector<int> v[10];
int visited[10];


void go(int start, int cnt) {
	if (start == n) {
		if (cnt == n/2) {
			ret++;
		}
		return;
	}
	if (visited[start] == 1) {
		go(start + 1, cnt);
		return;
	}
	for (int e : v[start]) {
		if (visited[e] == 0) {
			visited[e] = 1;
			visited[start] = 1;
			go(start + 1, cnt+1);
			visited[e] = 0;
			visited[start] = 0;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> c;
	while (c--) {
		cin >> n >> p;
		for (int i = 0; i < 10; i++) {
			v[i].clear();
		}
		for (int i = 0; i < p; i++) {
			cin >> a >> b;
			v[a].push_back(b);
			v[b].push_back(a);
		}
		ret = 0;
		memset(visited, 0, sizeof(visited));
		go(0, 0);
		cout << ret << "\n";
	}
}