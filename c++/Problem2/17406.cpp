#include<bits/stdc++.h>
using namespace std;

int n, m, k;
int rot[6][3];
int a[] = { 0,1,2,3,4,5 };
int dy[] = { 0,1,0,-1 };
int dx[] = { 1,0,-1,0 };
int ret=987654321;
// rot = r행, c열, s가중치
struct Board {
	int arr[51][51];
	// 2가 중복됨
	void rotatation(int num) {

		int y = rot[num][0]-1;
		int x = rot[num][1]-1;
		int s = rot[num][2];


		while (s != 0) {
			int prevy = y - s;
			int prevx = x - s; // 첫시작 좌표

			int limy = prevy;
			int limx = prevx; // 첫좌표 기억

			
			int nx, ny;
			int a = arr[prevy][prevx+1]; // 다음 좌표의 값 저장
			arr[prevy][prevx+1] = arr[prevy][prevx]; // 다음 좌표의 값을 첫좌표의 값으로 바꾸기
			prevx = prevx + 1;
			int idx = 0; // 방향 전환 표시

			while (prevy != limy || prevx != limx) { // 첫좌표로 돌아오면 반복문 종료

				switch (idx) {
				case 0:
					ny = prevy + dy[idx];
					nx = prevx + dx[idx];
					if (nx > x + s) {
						ny = prevy;
						nx = prevx;
						idx++;
						break;
					}
					swap(arr[ny][nx], a);
					prevy = ny;
					prevx = nx;
					break;
				case 1:
					ny = prevy + dy[idx];
					nx = prevx + dx[idx];
					if (ny > y + s) {
						idx++;
						break;
					}
					swap(arr[ny][nx], a);
					prevy = ny;
					prevx = nx;
					break;
				case 2:
					ny = prevy + dy[idx];
					nx = prevx + dx[idx];
					if (nx < x - s) {
						idx++;
						break;
					}
					swap(arr[ny][nx], a);
					prevy = ny;
					prevx = nx;
					break;
				case 3:
					ny = prevy + dy[idx];
					nx = prevx + dx[idx];
					if (ny < y - s) {
						idx++;
						break;
					}
					swap(arr[ny][nx], a);
					prevy = ny;
					prevx = nx;
					break;
				}
			}
			s--;
		}
	}
};


int main() {
	cin >> n >> m >> k;
	Board c;
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < m; j++) {
			cin >> c.arr[i][j];
		}
	}

	for (int i = 0; i < k; i++) {
		cin >> rot[i][0] >> rot[i][1] >> rot[i][2];
	}

	// 순열 
	do {
		Board tmp = c;
		for (int i = 0; i < k; i++) {
			tmp.rotatation(a[i]);
		}

		for (int i = 0; i < n; i++) {
			int sum = 0;
			for (int j = 0; j < m; j++) {
				sum += tmp.arr[i][j];
			}
			ret = min(ret, sum);
		}
	} while (next_permutation(&a[0],&a[k]));
	
	cout << ret;


}