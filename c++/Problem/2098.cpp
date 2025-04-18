#include<bits/stdc++.h>
using namespace std;
int n;
int dp[16][1<<16];
int arr[16][16];
int go(int num, int visited) {
	if (visited == (1 << n) - 1) {
		if (arr[num][0] == 0) {//���� ��������ġ���� ��������� �� �� ���ٸ� �ּڰ��� �� �� ����
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
		if (visited & (1 << i)) { // �ش� ��Ʈ�� �湮�ߴٸ� �ٸ� ���� �湮
			continue;
		}
		if (arr[num][i] == 0) {//���� �������� ���� ����� 0�̸� ����
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