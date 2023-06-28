#include<bits/stdc++.h>
using namespace std;
string arr[1001];
int T;// 톱니개수
int k;//회전수
int ret;

void left(int idx,int rot);
void right(int idx,int rot);
void rotation(int idx,int rot);

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> T;
	for (int i = 0; i < T; i++) {
		cin >> arr[i];
	}

	cin >> k;

	int stand, rot;
	for (int i = 0; i < k; i++) {
		cin >> stand >> rot;
		stand = stand - 1; // 배열 인덱스와 톱니 번호 맞추기
		if (stand == 0) {
			right(stand + 1, rot);
		}
		else if (stand == T - 1) {
			left(stand - 1, rot);
		}
		else {
			left(stand - 1, rot);
			right(stand + 1, rot);
		}
		rotation(stand, rot);
	}
	for (int i = 0; i < T; i++) {
		if (arr[i][0] == '1') {
			ret++;
		}
	}
	cout<<ret;

}
void rotation(int idx, int rot) {
	int tmp;
	if (rot == 0) {
		return;
	}
	else if (rot == 1) {
		tmp = arr[idx][7];
		for (int i = 7; i >0; i--) {
			arr[idx][i] = arr[idx][i-1];
		}
		arr[idx][0] = tmp;
	}
	else if (rot == -1) {
		tmp = arr[idx][0];
		for (int i = 0; i < 7; i++) {
			arr[idx][i] = arr[idx][i + 1];
		}
		arr[idx][7] = tmp;
	}
}
void left(int idx,int rot) {
	int tmp; // 현재 톱니바퀴의 회전방향 결정하는 변수
	if (arr[idx][2] == arr[idx + 1][6] || rot == 0) {
		tmp = 0;
	}
	else {
		tmp = rot * -1;
	}
	if (idx > 0) {
		left(idx-1,tmp);
	}
	rotation(idx, tmp);
}
void right(int idx,int rot) {
	int tmp; // 현재 톱니바퀴의 회전방향 결정하는 변수
	if (arr[idx][6] == arr[idx-1][2] || rot == 0) {
		tmp = 0;
	}
	else {
		tmp = rot * -1;
	}
	if (idx < T - 1) {
		right(idx + 1,tmp);
	}
	rotation(idx, tmp);
}
