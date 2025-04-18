#include<bits/stdc++.h>

using namespace std;

int T;
int n, e;

int parent[102];
int r[102];
int visited[102];

int ft_find(int x) {
    if (x == parent[x])
        return x;
    return parent[x] = ft_find(parent[x]);
}

void ft_union(int a, int b) {
    if (a == b)
        return;
    if (r[a] < r[b])
        parent[a] = b;
    else if (r[a] > r[b])
        parent[b] = a;
    else
        parent[b] = a;
    r[a]++;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> T;
    for (int i = 1; i <= T; i++) {
        cin >> n >> e;
        for (int i = 0; i < 101; i++) {
            parent[i] = i;
        }
        memset(r, 0, sizeof(r));
        memset(visited, 0, sizeof(visited));
        int cnt = 0;
        for (int i = 0; i < e; i++) {
            int a, b;

            cin >> a >> b;
            int pa = ft_find(a);
            int pb = ft_find(b);
            ft_union(pa, pb);
        }
        for (int i = 1; i <= n; i++) {
            int tmp = ft_find(i);
            if (visited[tmp] == 0) {
                cnt++;
                visited[tmp] = 1;
            }
        }
        cout << "#" << i << " " << cnt << "\n";
    }
}