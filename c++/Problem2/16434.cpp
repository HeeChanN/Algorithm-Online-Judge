#include<bits/stdc++.h>
using namespace std;
int n, atk;
long long ret= 1e18+4;
struct A {
	long long round, atk, hp;
};
vector<A> v;

bool check(long long max_hp) {
	long long attack=atk;
	long long Hp = max_hp;
	for (int i = 0; i < n; i++) {
		if (v[i].round == 1) {
			if (v[i].hp % attack) {
				Hp = Hp - (v[i].atk * (v[i].hp / attack));
			}
			else {
				Hp = Hp - (v[i].atk * ((v[i].hp / attack) - 1));
			}
		}
		else {
			attack = attack + v[i].atk;
			Hp = Hp + v[i].hp;
			if (Hp > max_hp) {
				Hp = max_hp;
			}
		}
		if (Hp <= 0) {
			return false;
		}
	}
	return true;

}
int main() {
	cin >> n >> atk;
	A tmp;
	for (int i = 0; i < n; i++) {
		cin >> tmp.round >> tmp.atk >> tmp.hp;
		v.push_back(tmp);
	}
	long long l = 1;
	long long r = 1e18+4;
	while (l <= r) {
		long long mid = (l + r) / 2;
		if (check(mid)) {
			ret = min(ret, mid);
			r = mid - 1;
		}
		else {
			l = mid + 1;
		}
	}
	cout << ret;
}