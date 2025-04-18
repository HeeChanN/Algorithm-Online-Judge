#include<bits/stdc++.h>
using namespace std;
int R, C;
int M;

int arr[101][101];
int tmp[101][101];
struct s {
	int y, x;
	int weight;
	int velocity;
	int dir;
};
s shark[10004];
int ret;

void sharkCatch(int num) {
	for (int i = 0; i < R; i++) {
		if (arr[i][num] != 0) {
			ret = ret + shark[arr[i][num]].weight;
			shark[arr[i][num]].weight = 0;
			arr[i][num] = 0;
			return;
		}
	}
}
void moveShark() {
	fill(&tmp[0][0], &tmp[0][0] + 101 * 101, 0);
	for (int i = 1; i <= M; i++) {
		if (shark[i].weight == 0) {
			continue;
		}
		int velocity = shark[i].velocity;
		int y = shark[i].y;
		int x = shark[i].x;
		int a;
		switch (shark[i].dir) {
		case 1://방향 위
			a = velocity / (R - 1);
			if (a % 2 == 0) {
				y = y - (velocity % (R - 1));
				if (y == 0 ) {
					shark[i].dir = 2;
				}
				if (y < 0) {
					y = 0 - y;
					shark[i].dir = 2;
				}
			}
			else { //방향 바꾸기
				shark[i].dir = 2;
				y = R - 1 - y + (velocity % (R - 1));
				if (y == R-1) {
					shark[i].dir = 1;
				}
				if (y >= R) {
					y = (R-1) - (y - (R - 1));
					shark[i].dir = 1;
				}
			}
			
			break;
		case 2://방향 아래
			a = velocity / (R - 1);
			if (a % 2 == 0) { // 같은 방향
				y = y + (velocity % (R - 1));
				if (y == R-1) {
					shark[i].dir = 1;
				}
				if (y >= R) {
					y = (R-1) - (y - (R - 1));
					shark[i].dir = 1;
				}
			}
			else {
				shark[i].dir = 1;
				y = R - 1 - y - (velocity % (R - 1));
				if (y == 0) {
					shark[i].dir = 2;
				}
				if (y < 0) {
					y = 0 - y;
					shark[i].dir = 2;
				}
			}
			break;
		case 3://방향 오른쪽
			a = velocity / (C - 1);
			if (a % 2 == 0) { // 같은 방향
				x = x + (velocity % (C - 1));
				if(x == C - 1) {
					shark[i].dir = 4;
				}
				if (x >= C) {
					x = (C-1) - (x - (C - 1));
					shark[i].dir = 4;
				}
			}
			else { // 다른 방향
				shark[i].dir = 4;
				x = C - 1 - x - (velocity % (C - 1));
				if (x == 0) {
					shark[i].dir = 3;
				}
				if (x < 0) {
					x = 0 - x;
					shark[i].dir = 3;
				}
			}
			break;
		case 4://방향 왼쪽
			a = velocity / (C - 1);
			if (a % 2 == 0) { // 같은 방향
				x = x - (velocity % (C - 1));
				if (x == 0) {
					shark[i].dir = 3;
				}
				if (x < 0) {
					x = 0 - x;
					shark[i].dir = 3;
				}
			}
			else { // 다른 방향
				shark[i].dir = 3;
				x = C - 1 - x + (velocity % (C - 1));
				if (x == C - 1) {
					shark[i].dir = 4;
				}
				if (x >= C) {
					x = (C-1) - (x - (C - 1));
					shark[i].dir = 4;
				}
			}
			break;
		}
		if (tmp[y][x]) { //큰상어가 잡아먹음
			if (shark[tmp[y][x]].weight < shark[i].weight) {
				shark[tmp[y][x]].weight = 0;
				shark[i].y = y;
				shark[i].x = x;
				tmp[y][x] = i;
			}
			else {
				
				shark[i].weight = 0;
			}
		}
		else {
			shark[i].y = y;
			shark[i].x = x;
			tmp[y][x] = i;
		}
		/*for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				cout << tmp[i][j] << ' ';
			}
			cout << "\n";
		}
		cout << "\n"; */
		
	}
	
	memcpy(arr, tmp, sizeof(arr));
}
int main() {
	cin >> R >> C >> M;
	int y, x;
	for (int i = 1; i <= M; i++) {
		cin >> y >> x >> shark[i].velocity >> shark[i].dir >> shark[i].weight;
		shark[i].y = y-1;
		shark[i].x = x-1;
		arr[y - 1][x - 1] = i;
	}

	for (int i = 0; i < C; i++) {
		//상어잡기
		sharkCatch(i);
		moveShark();
	}
	cout << ret;
}