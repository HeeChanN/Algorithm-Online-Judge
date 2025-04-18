#include<bits/stdc++.h>
using namespace std;
int N, M, T;

int arr[52][52];
int visited[52][52];
int ret;
int dy[] = { -1,0,1,0 };
int dx[] = { 0,1,0,-1 };
bool num_same() {
	int flag = 1;
	memset(visited, 0, sizeof(visited));
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			if (arr[i][j] == 0) {
				continue;
			}
			if (visited[i][j] == 1) {
				continue;
			}
			for (int k = 0; k < 4; k++) {
				int ny = i + dy[k];
				int nx = (j + dx[k] + M) % M;
				if (ny < 0 || ny > N) {
					continue;
				}
				if (arr[i][j] == arr[ny][nx]) {
					flag = 0;
					visited[i][j] = 1;
				}
			}

			
		}
	}
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			if (visited[i][j] == 1) {
				arr[i][j] = 0;
			}

		}
	}
	return flag;
}
void change() {
	int sum = 0;
	int cnt = 0;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			if (arr[i][j]== 0) {
				continue;
			}
			sum = sum + arr[i][j];
			cnt++;

		}
	}
	double avg = sum / (double)cnt;

	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			if (arr[i][j] == 0) {
				continue;
			}
			if ((double)arr[i][j] > avg) arr[i][j]--;
			else if ((double)arr[i][j] < avg)arr[i][j]++;
		}
	}

}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL); cout.tie(NULL);
	cin >> N >> M >> T;
	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			cin >> arr[i][j];
		}
	}
	int x, d, k;//원판번호, 방향, 칸 M칸

	for (int i = 0; i < T; i++) {
		cin >> x >> d >> k;
		for (int j = x; j <= N; j =  j+x) {
			if (d == 1) {//반시계방향
				int c = 0;
				while (c < k) {
					int tmp = arr[j][0];
					for (int z = 0; z < M; z++) {
						arr[j][z] = arr[j][z + 1];
					}
					arr[j][M - 1] = tmp;
					c++;
				}
			}
			else if (d == 0) {//시계방향
				int c = 0;
				while (c < k) {
					int tmp = arr[j][M - 1];
					for (int z = M - 1; z > 0; z--) {
						arr[j][z] = arr[j][z - 1];

					}
					arr[j][0] = tmp;
					c++;
				}
			}
		}

		if (num_same()) {
			change();
		}
		
		
	}

	for (int i = 1; i <= N; i++) {
		for (int j = 0; j < M; j++) {
			if (arr[i][j] != 0) {
				ret += arr[i][j];
			}

		}
	}
	cout<<ret;
}
