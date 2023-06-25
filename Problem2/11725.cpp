#include<bits/stdc++.h>
using namespace std;
vector<int> v[100002];
int n;
int visited[100001];
void dfs(int num) {
	for (int i = 0; i < v[num].size(); i++) {
		if (visited[v[num][i]] == 0) {
			visited[v[num][i]] = num;
			dfs(v[num][i]);
		}
	}

}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n;
	int a, b;
	for (int i = 0; i < n-1; i++) {
		cin >> a >> b;
		v[a].push_back(b);
		v[b].push_back(a);
	}

	visited[1] = 1;
	dfs(1);
	for (int i = 2; i <= n; i++) {
		cout << visited[i]<<'\n';
	}
}