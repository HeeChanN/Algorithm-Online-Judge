#include <bits/stdc++.h>

using namespace std;

int arr[1004][1004];
int n, m;
int ret;

int ft_min(int x, int y, int z)
{
	int a = x;
	if (a > y) {
		a = y;
	}
	if (a > z) {
		a = z;
	}
	return a;
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);

	cin >> n >> m;

	for (int i = 1; i <= n; i++)
	{
		string str;
		cin >> str;
		for (int j = 1; j <= m; j++) {
			arr[i][j] = str[j - 1]-'0';
		}
	}

	for (int i = 1; i <= n; i++) {
		for (int j = 1; j <= m; j++) {
			if (arr[i][j] != 0)
			{
				arr[i][j] += ft_min(arr[i - 1][j - 1], arr[i - 1][j], arr[i][j - 1]);
				if (ret < arr[i][j])
					ret = arr[i][j];
			}
		}
	}

	cout << ret * ret;
}