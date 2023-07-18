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

// 문제를 푸는 로직

/* 1. 먼저 dp를 이용한다. dp[0]=1 로 초기화 한 이유는 모든 수의 첫 시작은 항상 dp[0]을 참조해서 이렇게 설정해주었다.
*  2. 이후 메모리 4mb를 고려하여 따로 배열에 동전을 입력받지 않고 동전을 받는 즉시 dp에 적용시켜줬다.
*  3. 
* 
*/

/*
	
*/