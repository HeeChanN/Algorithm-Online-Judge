#include<bits/stdc++.h>
using namespace std;
int n, k;
int visited[100001];
int salt[] = { -1,1 };
void bfs(int num) {
	visited[num] = 0;
	queue<int> q;
	q.push(num);
	while (q.size()) {
		int x = q.front();
		q.pop();
		for (int i = 0; i < 3; i++) {
			if (i == 2) {
				if (x * 2 > 100000) {
					continue;
				}
				if (visited[x * 2] == -1) {
					visited[x * 2] = visited[x];
					q.push(x * 2);
				}
				else if (visited[x * 2] > visited[x]) {
					visited[x * 2] = visited[x];
					q.push(x*2);
				}
				continue;
			}
			if (x + salt[i] < 0 || x + salt[i]>100000) {
				continue;
			}
			if (visited[x + salt[i]]==-1) {
				visited[x + salt[i]] = visited[x] + 1;
				q.push(x + salt[i]);
			}
			else if (visited[x + salt[i]]-1 > visited[x]) {
				visited[x + salt[i]] = visited[x] + 1;
				q.push(x + salt[i]);
			}

		}

	}
}

int main() {
	cin >> n >> k;
	memset(visited, -1, sizeof(visited));
	bfs(n);
	cout << visited[k];
}