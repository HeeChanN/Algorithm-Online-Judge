#include<bits/stdc++.h>
using namespace std;
int dp[1001][2][32];
int t, m;
int jadu[1001];
int go(int time, int pos, int move) {
	if (move < 0) return -1e9;
	if (time == t) {
		if (move == 0) {
			return 0;
		}
		else {
			return -1e9;
		}
	}
	int& ret = dp[time][pos][move];
	if (ret != -1) {
		return ret; 
		//�� �ð��� �� ��ġ���� ���� �̵�Ƚ���� �Ҹ��ߴٸ� ���̻� ���� ����� �̾��
		// �ʰ� ������ ����� �̿��Ѵ�.
	}

	int tmp;
	if (jadu[time]-1 == pos ) {
		tmp = 1;
	}
	else {
		tmp = 0;
	}
	int next = go(time + 1, pos ^ 1, move - 1) + tmp; // �̵���������
	int stay = go(time + 1, pos, move) + tmp; //�̵���������� ��� ��ͷ� ���ϰ�

	ret = max(next, stay); // dp[1000][2][30]�� ���� ���� �����Ѵ�.

	return ret;


}

int main() {
	cin >> t >> m;
	memset(dp, -1, sizeof(dp));
	for (int i = 0; i < t; i++) {
		cin >> jadu[i];
	}
	//0�ʿ� ������ �ִ� ���� 0�ʿ� 1������ �̵��ϴ� ��� �� ��츦 ���������
	cout << max(go(0, 0, m), go(0, 1, m - 1));

}