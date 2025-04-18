#include<bits/stdc++.h> 
using namespace std;


int a[12][12], ret = 987654321;
int papper[] = { 0,5,5,5,5,5 };

bool check(int y, int x, int i) {
    if (y + i > 10 || x + i > 10){
        return false;
    }
    for (int j = y; j < y + i; j++) {
        for (int k = x; k < x + i; k++) {
            if (a[j][k] == 0) {
                return false;
            }
        }
    }
    return true;
}
void draw(int y, int x, int cnt, int v) {
    for (int i = y; i < y + cnt; i++) {
        for (int j = x; j < x + cnt; j++) {
            a[i][j] = v;
        }
    }
}
void dfs(int y, int x, int cnt) {
    if (cnt >= ret) return; // ��Ʈ��ŷ
    if (x == 10) { // �ش� �� �� ������ ���� ��
        dfs(y + 1, 0, cnt);
        return;
    }
    if (y == 10) {  // ��� �� �� ������ ret �ּڰ� ���
        ret = min(cnt, ret);
        return;
    }
    if (a[y][x] == 0) { // �ش� ��ġ�� 0�̸� ���͵� ���� ���� x �� �����
        dfs(y, x + 1, cnt); return;
    }
    for (int i = 5; i >= 1; i--) {
        if (papper[i] == 0) {
            continue;
        }
        if (check(y, x, i)) {
            papper[i]--;
            draw(y, x, i, 0);
            dfs(y, x + i, cnt + 1);
            draw(y, x, i, 1);
            papper[i]++;
        }
    }
    return;
}

int main() {
    ios_base::sync_with_stdio(0);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 0; i < 10; i++) {
        for (int j = 0; j < 10; j++) {
            cin >> a[i][j];
        }
    }
    dfs(0, 0, 0);
    if (ret == 987654321) {
        cout << -1;
    }
    else {
        cout << ret;
    }
    return 0;
}
/*
* 
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 1 1 0 0 0
1 1 1 1 1 0 0 0 0 0
1 1 1 1 1 0 0 0 0 0
1 1 1 1 1 0 0 0 0 0
1 1 1 1 1 0 0 0 0 0
0 0 0 0 0 0 0 0 0 0

�� : 5
*