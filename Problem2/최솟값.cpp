#include <bits/stdc++.h>

using namespace std;

vector<int> v;

int init(vector<int>& tree, int node, int s, int e) {
    if (s == e)
        return tree[node] = v[s];

    int m = (s + e) / 2;
    int a = init(tree, node * 2, s, m);
    int b = init(tree, node * 2 + 1, m + 1, e);

 
    tree[node] = min(a,b);
    return tree[node];
}

int query(vector<int>& tree, int node, int ts, int te, int qs, int qe) {
    if (ts >= qs && qe >= te)
        return tree[node];

    if (te < qs || qe < ts)
        return 1000000000;
    int m = (ts + te) / 2;
    int a = query(tree, node * 2, ts, m, qs, qe);
    int b = query(tree, node * 2 + 1, m + 1, te, qs, qe);
    return min(a, b);
}


int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);



    int n, q;
    cin >> n >> q;
    vector<int> segTree(n * 4);
    v.clear();

    for (int i = 0; i < n; i++) {
        int tmp;
        cin >> tmp;
        v.push_back(tmp);
    }

    init(segTree, 1, 0, n - 1);

    for (int i = 0; i < q; i++) {
        int s, e;
        cin >> s >> e;
        cout << query(segTree, 1, 0, n - 1, s-1, e-1) << "\n";

    }


}