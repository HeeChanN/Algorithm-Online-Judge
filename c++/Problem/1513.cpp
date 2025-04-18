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

/* 1. ���� dfs�� �������� �� ����Ǽ��� ���ϴµ� ���� ����� ����ϴ� �޸������̼��� �ʿ��ϴٴ°� �� �� �־���.
   2. ������ dp�� �ε����� ��� �����ؾ� ���� 1���� c������ �湮Ƚ���� �������� ���� ��������. ����
   3. ��� �����غ������� ������ ���� �湮�� 1������ C������ ������ �湮 Ƚ���� �����ϴ� ���� �𸣰ھ ���� ã�ƺôµ�
   4. ������ �ٽ��� 0�� �湮���� c�� �湮���� ����Ž���� �ϴµ� dp�� �� ��� �湮������ ���� �湮 �������� ������ �����
      ���� ���ϴ� ����̾���.
   5. DP�� �̿��Ϸ��� �Ѵٸ� ��ȯ���� ������ ��ȯ���� int�� �����ϰ� �� �ȿ��� �����Ϸ��� �ϴ� �Ͱ� ����ؼ����� ���� 
   ����� �����ϰ� �̿��Ϸ��� �ϴ� �������� ������ �ϴ� ������������ �� ���� dp ������ Ǯ����߰ڴ�.

*/