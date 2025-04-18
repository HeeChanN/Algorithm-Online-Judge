#include<bits/stdc++.h>
using namespace std;
int n, m, k;
int arr[12][12];
int pluss[12][12];
int dy[] = { -1,-1,0,1,1,1,0,-1 };
int dx[] = { 0,1,1,1,0,-1,-1,-1 };

vector<int> a[12][12];

void ss() { // 나무가 나이먹고 양분 부족하면 죽는 구간
	
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (a[i][j].size() == 0) {
				continue;
			}
			sort(a[i][j].begin(), a[i][j].end());
			int die = 0;
			vector<int> temp;
			
			for (int k : a[i][j]) {
				if (arr[i][j] < k) {
					die = die + k / 2;
					
				}
				else {
					arr[i][j] =arr[i][j]-k;
					temp.push_back(k + 1);
				}
			}
			a[i][j] = temp;
			arr[i][j] += die;
		}
	
	
	}
	
	
}

void fall() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			if (a[i][j].size() == 0) {
				continue;
			}
			for (int tree : a[i][j]) {
				if (tree % 5 == 0) {
					for (int d = 0; d < 8; d++) {
						int ny = i + dy[d];
						int nx = j + dx[d];
						if (ny < 1 || ny > n || nx < 1 || nx > n) {
							continue;
						}
						a[ny][nx].push_back(1);
					}
				}
			}
		}
	}
}
void winter() {
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			arr[i][j] += pluss[i][j];
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> k;
	fill(&arr[0][0], &arr[11][12], 5);
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			cin >> pluss[i][j];
		}
	}
	int x, y, z;
	for (int i = 0; i < m; i++) {
		cin >> x >> y >> z;
		a[x][y].push_back(z);
	}
	
	for (int i = 0; i < k; i++) { //K년 동안의 변화를 살펴보기
		ss();
		fall();
		winter();
	}
	int ret = 0;
	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= n; j++) {
			ret += a[i][j].size();
		}
	}
	cout << ret;
	return 0;

}