#include<bits/stdc++.h>
using namespace std;
int n, k;
int dp[100001];

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> k;
	int num;
	dp[0] = 1;
	for (int i = 0; i < n; i++) {
		cin >> num;
		for (int j = num; j <= k; j++) {
	
			dp[j] = dp[j] + dp[j - num];
		}
		
	}
	cout << dp[k];

}

// ������ Ǫ�� ����

/* 1. ���� dp�� �̿��Ѵ�. dp[0]=1 �� �ʱ�ȭ �� ������ ��� ���� ù ������ �׻� dp[0]�� �����ؼ� �̷��� �������־���.
*  2. ���� �޸� 4mb�� ����Ͽ� ���� �迭�� ������ �Է¹��� �ʰ� ������ �޴� ��� dp�� ����������.
*  3. 
* 
*/

/*
	
*/