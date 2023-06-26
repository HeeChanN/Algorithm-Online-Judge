#include<bits/stdc++.h>
using namespace std;

long long  a, b;
long long ret = -1;
struct A {
	long long  num;
	long long  cnt;
};
void go(long long  num) {
	queue<A> q;
	A tmp;
	tmp.num = num;
	tmp.cnt = 0;
	q.push(tmp);
	while (q.size()) {
		long long  p = q.front().num;
		long long  cnt = q.front().cnt;
		q.pop();
		for (int i = 0; i < 2; i++) {
			long long  np;
			if (i == 0) {
				np = p * 2;
			}
			else {
				np = p * 10 + 1;
			}
			if (np > b) {
				continue;
			}
			if (np == b) {
				ret = cnt + 1;
				return;
			}
			A temp;
			temp.num = np;
			temp.cnt = cnt + 1;
			q.push(temp);
		}
	}
}
int main() {
	cin >> a >> b;

	go(a);
	if (ret == -1) {
		cout << -1;
	}
	else {
		cout << ret + 1;
	}
}