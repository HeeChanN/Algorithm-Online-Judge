#include<bits/stdc++.h>

using namespace std;

int n;
int ret = 2000000000;
vector<int> v;

int a, b;

int main() {

    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        v.push_back(num);
    }
    sort(v.begin(), v.end());

    int l = 0;
    int r = n - 1;

    while (l < r) {
        int num = abs(v[l] + v[r]);
        if (ret > num) {
            ret = num;
            a = v[l];
            b = v[r];
        }
        if (abs(v[l]) < abs(v[r])) {
            r = r - 1;
        }
        else
            l = l + 1;
    }
    cout << a << " " << b;
}