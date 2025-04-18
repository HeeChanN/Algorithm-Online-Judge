#include<bits/stdc++.h>
using namespace std;


int n,m,c,y,x;
int arr[52][52];
int dp[52][52][52][52];

int go(int y,int x, int cnt, int p) {
	if (cnt < 0) {
		return 0;
	}
	if (y > n || x > m) {
		return 0;
	}
	if (y == n && x == m) {
		if (cnt == 0 && arr[y][x] == 0) {
			return 1;
		}
		if (cnt == 1 && arr[y][x] > p) {
			return 1;
		}
		return 0;
	}

	int& ret = dp[y][x][cnt][p];
	if (ret != -1) {
		return ret;
	}
	ret = 0;
	if (arr[y][x] == 0) {
		ret = (go(y, x + 1, cnt, p) + go(y + 1, x, cnt, p)) % 1000007;
	}
	else if (arr[y][x] > p) {
		ret = (go(y, x + 1, cnt - 1, arr[y][x]) + go(y + 1, x, cnt - 1, arr[y][x])) % 1000007;
	}
	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	memset(dp, -1, sizeof(dp));

	cin >> n >> m >> c;
	for (int i = 1; i <= c; i++) {
		cin >> y >> x;
		arr[y][x] = i;
	}
	for (int i = 0; i <= c; i++) {
		cout<<go(1,1,i,0)<<" ";
	}
}

/* 1. 먼저 dfs로 접근했을 때 경우의수를 구하는데 이전 계산을 기록하는 메모이제이션이 필요하다는걸 알 수 있었다.
   2. 하지만 dp의 인덱스를 어떻게 설정해야 이전 1부터 c까지의 방문횟수를 저장할지 감이 안잡혔다. 따라서
   3. 계속 생각해보았지만 도무지 이전 방문때 1번부터 C번까지 종류별 방문 횟수를 저장하는 법을 모르겠어서 답을 찾아봤는데
   4. 문제의 핵심은 0번 방문부터 c번 방문까지 완점탐색을 하는데 dp에 이 몇번 방문인지와 이전 방문 오락실을 저장해 경우의
      수를 구하는 방식이었다.
   5. DP를 이용하려고 한다면 반환값을 무조건 반환값을 int로 고정하고 그 안에서 생각하려고 하는 것과 어떻게해서든지 이전 
   기록을 저장하고 이용하려고 하는 생각으로 접근을 하는 마음가짐으로 더 많은 dp 문제를 풀어봐야겠다.

*/