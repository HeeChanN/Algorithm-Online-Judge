#include <bits/stdc++.h>

using namespace std;

pair<long long, long long> ret;
priority_queue<pair<long long, long long>, vector<pair<long long, long long >>, greater<pair<long long, long long>>> pq;
vector < pair <long long , long long >> adj[804];

long long dist[804];
long long v,u,w,n,e,a,b;
int flag;
long long m;

void calc_dist(long long start) {
	dist[start] = 0;
	pq.push({ 0,start });
	while (pq.size()) {
		long long here = pq.top().second;
		long long d = pq.top().first;
		pq.pop();
		if (dist[here] != d)
			continue;
		for (pair<long long, long long> next : adj[here]) {
			long long _next = next.second;
			long long _d = next.first;
			if (dist[_next] > _d + dist[here]) {
				dist[_next] = _d + dist[here];
				pq.push({ dist[_next],_next });
			}
		}
	}
}
int main() {
	ios_base::sync_with_stdio(false);
	cin.tie(NULL);
	cout.tie(NULL);
	cin >> n >> e;

	for (int i = 0; i < e; i++) { // �����
		cin >> v >> u >> w;
		adj[v-1].push_back({ w,u-1 });
		adj[u-1].push_back({ w,v-1 });
	}

	cin >> a >> b;
	if (((a-1) == 0) && ((b-1) == (n - 1)))
		flag = 1;
	else if (((a-1) == 0) || ((b-1) == (n - 1)))
		flag = 2;

	fill(&dist[0], &dist[803], 987654321);
	
	/* 0������ a�� �Ǵ� b������ �Ÿ� dist�� �����ϱ�  */
	calc_dist(0);
	if (flag == 1) {
		m = dist[n - 1];
	}
	else
	{
		if (flag == 2) {
			if ((a-1) == 0) {
				m = dist[b - 1];
				fill(&dist[0], &dist[803], 987654321);
				calc_dist(b - 1);
				m = m + dist[n - 1];
			}
			else if ((b-1) == n - 1) {
				m = dist[a - 1];
				fill(&dist[0], &dist[803], 987654321);
				calc_dist(a - 1);
				m = m + dist[n - 1];
			}
		}
		else {
			ret.first = ret.first + dist[a - 1];
			ret.second = ret.second + dist[b - 1];

			/* a ������ b������ �ִ� �Ÿ� ���ϱ�*/
			fill(&dist[0], &dist[803], 987654321);
			calc_dist(a - 1);
			ret.first = ret.first + dist[b - 1];
			ret.second = ret.second + dist[n - 1]; // b������ a��, a���� n���� �ѹ��� ���� ������

			/* b������ n������ �ִ� �Ÿ� ���ϱ�*/
			fill(&dist[0], &dist[803], 987654321);
			calc_dist(b - 1);
			ret.first = ret.first + dist[n - 1];
			ret.second = ret.second + dist[a - 1];
			m = min(ret.first, ret.second);
		}
	}
	
	if (m >= 987654321) {
		cout << -1;
	}
	else
		cout << m;
}