#include<bits/stdc++.h>
using namespace std;
int ans[10];
int ret;
vector<int>v;
void go(int num, int cnt) {
	if (v.size() == 10) { //10문제 다 찍었을 경우
		if (cnt >= 5) {
			ret++;
		}
		return;
	}
	if (num>=6 && cnt==0) {//6번 문제 까지 풀었는데 답이 0개면 다음부터는 볼필요없음 백트래킹
		return;
	}
	for (int i = 1; i <= 5; i++) {
		if (v.size() < 2) { // 아직 2번이면 영재의 찍기방법은 생각 안해도 됨
			if (i == ans[num]) {
				v.push_back(i);
				go(num + 1, cnt+1);
				v.pop_back();
			}
			else {
				v.push_back(i);
				go(num + 1, cnt);
				v.pop_back();
			}
		}
		else {
			if (v[num - 1] == i && v[num-2] == i) {
				continue;
			}
			if(i == ans[num]) {
				v.push_back(i);
				go(num + 1, cnt + 1);
				v.pop_back();
			}
			else {
				v.push_back(i);
				go(num + 1, cnt);
				v.pop_back();
			}
		}
	}
	return;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	for (int i = 0; i < 10; i++) {
		cin >> ans[i];
	}
	go(0,0);

	cout << ret;
}