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


/* 1. ���� 10������ ���� �ڱ⸦ �����ϰ� ��ο� �º��ϴ� �� = 10�� * 10������ 100���� �ȴ� 
*  2. ������ ������ 1��, �޸𸮴� 1024mb�̰� �ߺ����� �ʴ� ���� 1���� 100�� ���� ����ϴ� ��������.
*  3. ���� �Է¹��� ���� ����� ���ϴ� ������ ����� �ش� ����� ���� ����� �����ϸ� �� ���� ������ +1 ���ְ� ����� ������ -1 
*  4. ���⼭ ����� ��� ���ϳ�? --> �Ҽ��� ���ϴ� ������ �ݴ�� �����ϸ� �ȴ�. ���� Ư�� ����� Ư�� ���� �νĵ� �� �ֱ� ������ 
*  5. ret��� �迭�� �̿��Ͽ� ������ �����ϰ� ���Ŀ� people�� ���� ret�� �ε����� ã�� ������ O(1)�� �ð��� Ȯ�� ����
*  6. �Ҽ��� ���ϴ� ������ ª�� �Ʒ� ¥���� �Ʒ� �ڵ尡 �ǰ� �̰� ������ ���ǿ� �°� ���� ���� �ٷ� ���� �ڵ��̴�
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