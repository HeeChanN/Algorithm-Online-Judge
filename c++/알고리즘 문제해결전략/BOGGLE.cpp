#include <bits/stdc++.h>

using namespace std;

int dy[] = { -1,-1,0,1,1,1,0,-1 };
int dx[] = { 0,1,1,1,0,-1,-1,-1 };

int c;
int num;
int dp[10][5][5];

string str[5];
string words[10];

int find_word(int y, int x, int p, int idx) {
    if (y<0 || x < 0|| y >=5 || x >=5) {
        return 0;
    }
    if (str[y][x] != words[idx][p]) {
        return 0;
    }
    if (p == words[idx].size()-1) {
        return 1;
    }
    int& ret = dp[p][y][x];
    if (ret != -1) {
        return ret;
    }
    int flag = 0;
    for (int i = 0; i < 8; i++) {
        if (find_word(y + dy[i], x + dx[i], p + 1, idx) == 1) {
            flag = 1;
        }
    }
    if (flag == 1) {
        ret = 1;
    }
    else
        ret = 0;
    return ret;
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> c;
    while (c--) {
        for (int i = 0; i < 5; i++) {
            cin >> str[i];
        }
        cin >> num;
        for (int i = 0; i < num; i++) {
            cin >> words[i];
        }
        for (int i = 0; i < num; i++) {
            int op = 0;
            memset(dp, -1, sizeof(dp));
            for (int j = 0; j < 5; j++) {
                for (int k = 0; k < 5; k++) {
                    if (find_word(j, k, 0, i) == 1) {
                        op = 1;
                    }
                }
            }
            if (op == 1) {
                cout << words[i] << " YES\n";
            }
            else
                cout << words[i] << " NO\n";
        }
    }
}