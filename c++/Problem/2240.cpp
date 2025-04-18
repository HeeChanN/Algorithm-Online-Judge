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
		//그 시간에 그 위치에서 같은 이동횟수를 소모했다면 더이상 다음 계산을 이어가지
		// 않고 이전의 기록을 이용한다.
	}

	int tmp;
	if (jadu[time]-1 == pos ) {
		tmp = 1;
	}
	else {
		tmp = 0;
	}
	int next = go(time + 1, pos ^ 1, move - 1) + tmp; // 이동했을경우와
	int stay = go(time + 1, pos, move) + tmp; //이동안했을경우 계속 재귀로 구하고

	ret = max(next, stay); // dp[1000][2][30]에 최종 값을 저장한다.

	return ret;


}

int main() {
	cin >> t >> m;
	memset(dp, -1, sizeof(dp));
	for (int i = 0; i < t; i++) {
		cin >> jadu[i];
	}
	//0초에 가만히 있는 경우와 0초에 1번으로 이동하는 경우 두 경우를 따져줘야함
	cout << max(go(0, 0, m), go(0, 1, m - 1));

}