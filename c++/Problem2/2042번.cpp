#include <bits/stdc++.h>

using namespace std;

int n, m, k;

int a, b;
long long c;

void update(vector<long long>& tree, int idx, long long num)
{
	while (idx < tree.size())
	{
		tree[idx] = tree[idx] + num;
		idx = idx + (idx & -idx);
	}
}


// 인덱스 idx 까지 누적합 구하기
long long sum(vector<long long>& tree, int idx) {
	
	long long ret = 0;

	while (idx > 0) {
		ret = ret + tree[idx];
		idx = idx - (idx & -idx);
	}

	return ret;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m >> k;

	vector<long long> arr(n + 1);
	vector<long long> tree(n + 1);


	//처음 입력받는 숫자로 구간합 구해놓기
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		update(tree, i, arr[i]);
	}

	// 구간합 구하기, 숫자 바꾸기
	for (int i = 0; i < m + k; i++) 
	{
		cin >> a >> b >> c;
		if (a == 1) { // 숫자 바꾸기
			update(tree, b, -arr[b]);
			arr[b] = c;
			update(tree, b, c);
		}
		else          // a == 2 구간합 구하기
		{
			long long start = sum(tree, b - 1);
			long long finish = sum(tree, (int)c);
			cout << finish - start << '\n';
		}
	}
}