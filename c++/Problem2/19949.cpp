#include<bits/stdc++.h>
using namespace std;
int ans[10];
int ret;
vector<int>v;
void go(int num, int cnt) {
	if (v.size() == 10) { //10���� �� ����� ���
		if (cnt >= 5) {
			ret++;
		}
		return;
	}
	if (num>=6 && cnt==0) {//6�� ���� ���� Ǯ���µ� ���� 0���� �������ʹ� ���ʿ���� ��Ʈ��ŷ
		return;
	}
	for (int i = 1; i <= 5; i++) {
		if (v.size() < 2) { // ���� 2���̸� ������ ������� ���� ���ص� ��
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