#include<bits/stdc++.h>
using namespace std;
int n;
int dp[16][1<<16];
int arr[16][16];
int go(int num, int visited) {
	if (visited == (1 << n) - 1) {
		if (arr[num][0] == 0) {//만약 마지막위치에서 출발점으로 갈 수 없다면 최솟값이 될 수 없음
			return 987654321;
		}
		else {
			return arr[num][0];
		}
	}

	int& ret = dp[num][visited];
	if (ret != -1) {
		return ret;
	}
	ret = 987654321;
	for (int i = 0; i < n; i++) {
		if (visited & (1 << i)) { // 해당 비트가 방문했다면 다른 지점 방문
			continue;
		}
		if (arr[num][i] == 0) {//다음 방향으로 가는 비용이 0이면 못감
			continue;
		}

		ret = min(go(i, visited | (1 << i)) + arr[num][i], ret);
	}
		
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < n; j++) {
			cin >> arr[i][j];
			
		}
	}
	memset(dp, -1, sizeof(dp));

	cout << go(0,1);
}

/*
4
0 7 3 3
7 0 9 2
1 9 0 12
7 7 12 0
*/