#include<bits/stdc++.h>

using namespace std;
int visited[30001];
int arr[30001];
vector<int> adj[30001];
int dp[3002];
vector<pair<int, int>> v;
int n, m, k;
int cnt;
int value;

void dfs(int num) {
	visited[num] = 1;

	for (int i : adj[num]) {
		if (visited[i] == 0) {
			cnt++;
			value = value + arr[i];
			dfs(i);
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> k;
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
	}
	int a, b;
	for (int i = 0; i < m; i++) {
		cin >> a >> b;
		adj[a].push_back(b);
		adj[b].push_back(a);
	}
	for (int i = 1; i <= n; i++) {
		
		if (visited[i] == 0) {
			cnt = 1, value = arr[i];
			dfs(i);
			v.push_back({ cnt, value });
		}
		
	}
	
	sort(v.begin(), v.end());

	memset(dp, -1, sizeof(dp));
	dp[0] = 0;
	int ret = 0;

	for (int i = 0; i < v.size(); i++) {
		for (int j = k-1; j >= v[i].first; j--) {
			if (dp[j-v[i].first] != -1) {
				dp[j] = max(dp[j], dp[j - v[i].first]+v[i].second);
				ret = max(ret, dp[j]);
			}

		}
	}
	cout << ret;


}

/* 1. ���� ������ ������ ����� ģ���� ģ���� ���� �ش� ����� ����Ǿ��ִ� ��� ģ���� ������ ���Ѵ´ٴ� �Ҹ��̴�.
   2. �� ������ �������� �ϴ� �����Ҹ� ã�ƾ� �ȴٴ� ������ dfs�� �� �����Ҹ� ã�Ƽ�
      �ش� �ϴ� �������� �������� ������� �ľ��Ͽ� ���Ϳ� �����Ͽ���.
   3. ���� �� ���� ��Ҹ� �̿��Ͽ� K�� �����ʴ� �ִ��� ���� ������ ���ϱ� ���� dp�� �̿��Ͽ���. 
   4. ���Ҿ� ������ �̿��Ͽ��� �����Ұ� 3������ K�� 3000�ϰ�쿡 1���� �ð������� ���� �ʱ⿡ �� ����� ����Ͽ���.
   5. 

*/
