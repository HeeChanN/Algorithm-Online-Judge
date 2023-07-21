#include<bits/stdc++.h>
using namespace std;
int n;
int visited[1000004];
int people[100004];
int ret[1000004];

void check(int num) {
	if (num == 1) {
		return;
	}
	
	for (int i = 1; i * i <= num; i++) {
		if (num % i == 0) {
			
			if (visited[i] == 1) {
				ret[i]++;
				ret[num]--;
			}
			if (visited[num / i] == 1 && i*i!=num) {
				ret[num/i]++;
				ret[num]--;
			}
		}
	
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n;
	for (int i = 0; i < n; i++) {
		cin >> people[i];
		visited[people[i]] = 1;
	}

	for (int i = 0; i < n; i++) {
		check(people[i]);
	}

	for (int i = 0; i < n; i++) {
		cout << ret[people[i]] << ' ';
	}



	return 0;
}


/* 1. 먼저 10만명이 각각 자기를 제외하고 모두와 승부하는 법 = 10만 * 10만으로 100억이 된다 
*  2. 문제의 조건은 1초, 메모리는 1024mb이고 중복되지 않는 수를 1부터 100만 까지 사용하는 문제였다.
*  3. 따라서 입력받은 수의 약수를 구하는 로직을 만들어 해당 약수를 갖는 사람이 존재하면 그 수의 승점을 +1 해주고 상대의 승점을 -1 
*  4. 여기서 약수는 어떻게 구하나? --> 소수를 구하는 공식을 반대로 생각하면 된다. 또한 특정 사람은 특정 수로 인식될 수 있기 때문에 
*  5. ret라는 배열을 이용하여 승점을 보관하고 이후에 people의 수로 ret를 인덱스로 찾아 승점을 O(1)의 시간에 확인 가능
*  6. 소수를 구하는 공식을 짧게 아래 짜보면 아래 코드가 되고 이걸 문제의 조건에 맞게 고쳐 쓴게 바로 위의 코드이다
*   	

*/
/*
bool check(int num) {
	if (num < 2) {
		return 0;
	}
	if (num == 2) {
		return 1;
	}
	if (num % 2 == 0) {
		return 0;
	}
	for (int i = 2; i * i <= num; i++) {
		if (num % i == 0) {
			return 0;
		}
	}
	return 1;

}
*/