#include<bits/stdc++.h>
using namespace std;
int y, x;

struct A {
	int y, x;
	int num;
};

vector<A> v;
int ret = 987654321;

bool comp(A a, A b) {
	if (a.num == b.num) {
		return a.num < b.num;
	}
	else {
		return a.num > b.num;
	}
}
struct board {
	int visited[9][9];
	void left(int s) {
		for (int i = v[s].x-1; i >= 0; i--) {
			if (visited[v[s].y][i] == 0) {
				visited[v[s].y][i] = 7;
			}
			if (visited[v[s].y][i] == 6) {
				break;
			}

		}
	}
	void right(int s) {
		for (int i = v[s].x; i < x; i++) {
			if (visited[v[s].y][i] == 0) {
				visited[v[s].y][i] = 7;
			}
			if (visited[v[s].y][i] == 6) {
				break;
			}

		}
	}
	
	void up(int s) {
		for (int i = v[s].y-1; i >=0; i--) {
			if (visited[i][v[s].x] == 0) {
				visited[i][v[s].x] = 7;
			}
			if (visited[i][v[s].x] == 6) {
				break;
			}
		}
	}
	void down(int s) {
		for (int i = v[s].y; i < y; i++) {
			if (visited[i][v[s].x] == 0) {
				visited[i][v[s].x] = 7;
			}
			if (visited[i][v[s].x] == 6) {
				break;
			}
		}
	}
	
	void check4(int i,int s) {
		if (i == 0) {
			up(s);
			down(s);
			right(s);
		}
		else if (i == 1) {
			up(s);
			down(s);
			left(s);
		}
		else if (i == 2) {
			up(s);
			left(s);
			right(s);
		}
		else {
			down(s);
			left(s);
			right(s);
		}
	}
	void check3(int i,int s) {
		if (i == 0) {
			up(s);
			right(s);
		}
		else if (i == 1) {
			right(s);
			down(s);
		}
		else if (i == 2) {
			down(s);
			left(s);
		}
		else {
			left(s);
			up(s);
		}
	}
	void check2(int i,int s) {
		if (i == 0) {
			up(s);
			down(s);
		}
		else {
			left(s);
			right(s);
		}
	}
	void check1(int i,int s) {
		if (i == 0) {
			up(s);
		}
		else if (i == 1) {
			left(s);
		}
		else if (i == 2) {
			right(s);
		}
		else {
			down(s);
		}
	}
};


void go(int s, board arr) {
	if (s == v.size()) {
		int cnt = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (arr.visited[i][j] == 0) {
					cnt++;
				}
			}
		}
		ret = min(ret, cnt);
		//최소 사각지대 크기 구하기
		return;
	}
	switch (v[s].num)
	{
	case 4:
		for (int i = 0; i < 4; i++) {
			board t = arr;
			t.check4(i,s);
			go(s + 1, t);
		}

		break;
	case 3:
		for (int i = 0; i < 4; i++) {
			board t = arr;
			t.check3(i,s);
			go(s + 1, t);
		}
		break;
	case 2:
		for (int i = 0; i < 2;i++) {
			board t = arr;
			t.check2(i, s);
			go(s + 1, t);
		}
		break;
	case 1:
		for (int i = 0; i < 4; i++) {
			board t = arr;
			t.check1(i, s);
			go(s + 1, t);
		}
		break;
	}
	return;
}

board a;

int main() {
	
	cin >> y >> x;
	
	for (int i = 0; i < y; i++) {
		for (int j = 0; j < x; j++) {
			cin >> a.visited[i][j];
			if (a.visited[i][j] >0 && a.visited[i][j]<6) {
				A tmp;
				tmp.y = i;
				tmp.x = j;
				tmp.num = a.visited[i][j];
				v.push_back(tmp);
				
			}
		}
	}
	
	sort(v.begin(), v.end(), comp);
	int tmp = 0;
	for (int i = 0; i < v.size(); i++) {
		if (v[i].num == 5) {
			tmp++;
			a.down(i);
			a.up(i);
			a.left(i);
			a.right(i);

		}
		else {
			break;
		}
	}
	if (tmp == v.size()) {
		int cnt = 0;
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (a.visited[i][j] == 0) {
					cnt++;
				}
			}
		}
		ret = min(ret, cnt);
	}
	else {
		go(tmp, a);
	}

	
	cout << ret;
	
}