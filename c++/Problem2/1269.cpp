#include<bits/stdc++.h>
using namespace std;
int n, m;
int A[200002];
int B[200002];
int ret;

bool check(int num,int right,int flag) {
	int l = 0;
	int r = right - 1;
	while (l <= r) {
		int mid = (l + r) / 2;
		int tmp;
		if (flag == 1) {
			tmp = B[mid];
		}
		else {
			tmp = A[mid];
		}

		if (tmp > num) {
			r = mid - 1;
		}
		else if(tmp==num){
			return true;
		}
		else {
			l = mid + 1;
		}
	}
	return false;
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> m;
	for (int i = 0; i < n; i++) {
		cin >> A[i];
	}
	for (int i = 0; i < m; i++) {
		cin >> B[i];
	}
	
	sort(&A[0], &A[n]);
	sort(&B[0], &B[m]);
	

	for (int i = 0; i < n; i++) {
		if (!check(A[i],m,1)) {
			ret++;
		}
		
	}
	for (int i = 0; i < m; i++) {
		if (!check(B[i], n,0)) {
			ret++;
		}

	}
	cout << ret;
	
}