#include<bits/stdc++.h>
using namespace std;
int n;
long long dp[31][31][2];
// �˾��� 0�̸� �ϳ� 1�̸� �ݰ���

long long pick(int one, int half, int pill) {
	//�ݰ��� �Ѱ��� �̾ƾ� �ݰ��� ������� ���� �Ѱ��� �ʰ��ϴ�
	//�ݰ��� ���� ��� �ؾ���
	if (half > one || one > n) {
		return 0;
	}
	if (one +half==2*n) {
		return 1;
	}
	long long& ret = dp[one][half][pill];
	if (ret != -1) {
		return ret;
	}
	long long _one = pick(one + 1, half, 0);
	long long _half = pick(one, half + 1, 1);
	
	ret = _one+_half;
	return ret;
	

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	memset(dp, -1, sizeof(dp));
	int t = 1000;
	while (t--) {
		cin >> n;
		if (n == 0) {
			break;
		}
		
		cout<<pick(0, 0, 0)<<'\n'; // ó���� �׳� ����
	}
}