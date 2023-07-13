using namespace std;

int n;
int arr[1004][3]; // 각 집마다 색깔 비용
int dp[1004][3];

int go(int x, int color, int prev_color) {
	if (color == prev_color) {//이전집 색 확인하기
		return 987654321;
	}

	if (x == n - 1) { //마지막 집일 경우
		return arr[x][color]; // 그집의 비용을 return;
	}



	int& ret = dp[x][color];
	if (ret != 987654321) {
		return ret;
	}

	int r = go(x + 1, color, color);// 다음집 빨강
	int g = go(x + 1, (color + 1) % 3, color); // 다음집 초록
	int b = go(x + 1, (color + 2) % 3, color); // 다음집 파랑

	ret = min(r, g);
	ret = min(ret, b) + arr[x][color];

	return ret;

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	int cost;
	cin >> n;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 3; j++) {
			cin >> arr[i][j];
		}
	}
	fill(&dp[0][0], &dp[1003][3], 987654321);
	int r = go(0, 0, -1);// 색과 위치
	int g = go(0, 1, -1);
	int b = go(0, 2, -1);
	cost = min(r, g);
	cost = min(cost, b);

	cout << cost;
}