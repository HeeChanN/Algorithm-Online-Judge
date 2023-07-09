#include<bits/stdc++.h>
using namespace std;
int n;
long long dp[31][31][2];
// 알약은 0이면 하나 1이면 반개임

long long pick(int one, int half, int pill) {
	//반개는 한개를 뽑아야 반개가 만들어짐 따라서 한개를 초과하는
	//반개는 없는 취급 해야함
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
		
		cout<<pick(0, 0, 0)<<'\n'; // 처음에 그냥 시작
	}
}