#include<bits/stdc++.h>
using namespace std;

int n;
char arr[3080][6160];

void go(int num,int y,int x) {
	if (num == 3) {
		arr[y][x] = '*';
		arr[y + 1][x - 1] = arr[y + 1][x + 1] = '*';
		for (int i = 0; i < 5; i++) {
			arr[y+2][x-2+i]='*';
		}
		return;
	}
	go(num / 2, y, x);
	go(num / 2, y + num / 2, x - num / 2);
	go(num / 2, y + num / 2, x + num / 2);
}
int main() {
	cin >> n;
	
	fill(&arr[0][0],&arr[3079][6160], ' ');

	go(n, 0, n - 1);
	for (int i = 0; i < n; i++) {
		for (int j = 0; j < 2 * n - 1; j++) {
			cout << arr[i][j];
		}
		cout << "\n";
	}
	
}