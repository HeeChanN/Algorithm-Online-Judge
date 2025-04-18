#include<bits/stdc++.h>


using namespace std;
int n, w; // n*n , w는 사건수
int dp[1002][1002];

vector<pair<int, int>> arr;

int calc(int i, int j) {
	return (abs(arr[i].first - arr[j].first) + abs(arr[i].second - arr[j].second));
}

int getDist(int a, int b) {
	if (a == w+1 || b == w+1) {
		return 0;
	}
	if (dp[a][b] != 0) {
		return dp[a][b];
	}
	int next = max(a, b) + 1;
	dp[a][b] = min(getDist(next, b) + calc(a,next), getDist(a, next) + calc(b,next));
	return dp[a][b];
}

void print()
{
	int a = 0; int b = 1;
	for (int i = 2; i < w + 2; i++) {
		if (dp[i][b] + calc(a, i) < dp[a][i] + calc(b, i)) {
			cout<<"1"<<"\n";
			a = i;
		}
		else {
			cout << "2" << "\n";
			b = i;
		}
	}
}

int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	int n1, n2;
	cin >> n >> w;
	arr.push_back({ 1,1 });
	arr.push_back({ n,n });
	for (int i = 0; i < w; i++) {
		cin >> n1 >> n2;
		arr.push_back({ n1,n2 });
	}

	cout << getDist(0, 1)<<"\n";
	print();
}