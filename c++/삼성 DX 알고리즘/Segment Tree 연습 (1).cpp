#include <bits/stdc++.h>

using namespace std;

vector<int> v;

pair<int, int> init(vector<pair<int, int>>& tree, int node, int s, int e) {
    if (s == e)
        return tree[node] = { v[s], v[s] };

    int m = (s + e) / 2;
    pair<int, int> a = init(tree, node * 2, s, m);
    pair<int, int> b = init(tree, node * 2 + 1, m + 1, e);

    tree[node].first = max(a.first, b.first);
    tree[node].second = min(a.second, b.second);
    return tree[node];
}

pair<int, int> query(vector<pair<int, int>>& tree, int node, int ts, int te, int qs, int qe) {
    if (ts >= qs && qe >= te)
        return tree[node];

    if (te < qs || qe < ts)
        return { 0,INT_MAX };
    int m = (ts + te) / 2; 
    pair<int, int> a = query(tree, node * 2, ts, m, qs, qe);
    pair<int, int> b = query(tree, node * 2 + 1, m + 1, te, qs, qe);
    pair<int, int> tmp;
    tmp.first = max(a.first, b.first);
    tmp.second = min(a.second, b.second);
    return tmp;
}

pair<int, int> update(vector<pair<int, int>>& tree, int node, int s, int e, int ii, int value) {
    if (s > ii || ii > e)
        return tree[node];
   
    if (s == e) {
        tree[node].first = value;
        tree[node].second = value;
        return tree[node];
    }
    int m = (s + e) / 2;
    pair<int, int> a = update(tree, node * 2, s, m, ii, value);
    pair<int, int> b = update(tree, node * 2 + 1, m + 1, e, ii, value);
    tree[node].first = max(a.first, b.first);
    tree[node].second = min(a.second, b.second);
    
    return tree[node];

}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;

    cin >> t;

    for (int i = 1; i <= t; i++) {
        int n, q;
        cin >> n >> q;
        vector<pair<int, int>> segTree(n * 4);
        vector<int> ret;
        v.clear();

        for (int i = 0; i < n; i++) {
            int tmp;
            cin >> tmp;
            v.push_back(tmp);
        }

        init(segTree, 1, 0, n - 1);


        for (int i = 0; i < q; i++) {
            int a, b, c;
            cin >> a >> b >> c;
            pair<int, int> tmp;
            if (a == 1) {
                tmp = query(segTree, 1, 0, n - 1, b, c - 1);
                ret.push_back(tmp.first - tmp.second);
            }
            else {
                tmp = update(segTree, 1, 0, n - 1, b, c);
            }

        }
        cout << "#" << i << " ";
        for (int i = 0; i < ret.size(); i++) {
            cout << ret[i] << " ";
        }
        cout << "\n";
    }
}