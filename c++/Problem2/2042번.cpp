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


// �ε��� idx ���� ������ ���ϱ�
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


	//ó�� �Է¹޴� ���ڷ� ������ ���س���
	for (int i = 1; i <= n; i++) {
		cin >> arr[i];
		update(tree, i, arr[i]);
	}

	// ������ ���ϱ�, ���� �ٲٱ�
	for (int i = 0; i < m + k; i++) 
	{
		cin >> a >> b >> c;
		if (a == 1) { // ���� �ٲٱ�
			update(tree, b, -arr[b]);
			arr[b] = c;
			update(tree, b, c);
		}
		else          // a == 2 ������ ���ϱ�
		{
			long long start = sum(tree, b - 1);
			long long finish = sum(tree, (int)c);
			cout << finish - start << '\n';
		}
	}
}