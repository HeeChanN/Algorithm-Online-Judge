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

/* 1. 먼저 사탕을 빼앗은 사람의 친구의 친구의 뜻은 해당 사람과 연결되어있는 모든 친구의 사탕을 빼앗는다는 소리이다.
   2. 이 내용을 바탕으로 일단 연결요소를 찾아야 된다는 생각에 dfs로 각 연결요소를 찾아서
      해당 하는 연결요소의 사탕수와 사람수를 파악하여 벡터에 저장하였다.
   3. 이후 이 연결 요소를 이용하여 K를 넘지않는 최대의 사탕 개수를 구하기 위해 dp를 이용하였다. 
   4. 바텀업 형식을 이용하였고 연결요소가 3만개에 K가 3000일경우에 1초의 시간제한을 넘지 않기에 이 방법을 사용하였다.
   5. 

*/
