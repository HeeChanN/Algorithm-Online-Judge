#include <bits/stdc++.h>

using namespace std;

int n, m, l;
vector<int> v;
int len;
int ret = 987654321;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n >> m >> l;

    for (int i = 0; i < n; i++) {
        int num;
        cin >> num;
        v.push_back(num);
    }


    v.push_back(0);
    v.push_back(l);
    sort(v.begin(), v.end());


    int start = 1;
    int end = l - 1;

    while (start <= end) {
        int mid = (start + end) / 2;

        int count = 0;

        for (int i = 1; i < v.size(); i++) {
            len = v[i] - v[i - 1];
            int cnt = len / mid;
            if (len % mid == 0) {
                count = count + cnt - 1;
            }
            else
                count = count + cnt;
        }

        if (count > m) {
            start = mid + 1;
        }
        else {
            end = mid - 1;
            ret = min(ret, mid);
        }
    }
    cout << ret;

}