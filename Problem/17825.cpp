#include<bits/stdc++.h>
using namespace std;
int arr[10];


int visited[] = { 0,2,4,6,8,10,12,14,16,18,20,22,24,26,28,30,32,34,36,38,40,41,
13,16,19,25,30,35,40,41,
22,24,25,30,35,40,41,
28,27,26,25,30,35,40,41};

int horse[4]={0, 0, 0, 0};

int ret;

int move(int idx,int cnt) {
	if (visited[idx] == 41) {
		return idx;
	}
	if (idx == 5) {
		idx = 22;
		cnt--;
	}
	else if (idx == 10) {
		idx = 30;
		cnt--;
	}
	else if (idx == 15) {
		idx = 37;
		cnt--;
	}

	for (int i = 0; i < cnt; i++) {
		idx = idx + 1;
		if(visited[idx]==41){
			return idx;
		}
		if (idx == 28) {
			idx = 20;
		}
		if (idx == 32) {
			idx = 25;
		}
		if (idx == 40) {
			idx = 25;
		}
	}
	return idx;

}
bool same(int next_h, int i) {
	if (visited[next_h] == 41) {
		return false;
	}
	for (int j = 0; j < 4; j++) {
		if (j == i) {
			continue;
		}
		if (horse[j] == next_h) {
			return true;
		}
	}
	return false;
	
}

void go(int k,int sum) {
	if (k == 10) {
		ret = max(ret, sum);
		return;
	}

	for (int i = 0; i < 4; i++) {
		int tmp = horse[i];
		int next_h = move(tmp, arr[k]);
		if (same(next_h, i)) {
			continue;
		}
		horse[i] = next_h;
		int ad;
		if (visited[horse[i]] == 41) {
			ad = 0;
		}
		else {
			ad = horse[i];
		}
		
		go(k + 1, sum + visited[ad]);
		horse[i] = tmp;
	}
}
int main(){
	for (int i = 0; i < 10; i++) {
		cin >> arr[i];
	}

	go(0,0);
	cout << ret;
}