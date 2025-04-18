#include<bits/stdc++.h>

using namespace std;

int board[9][9];
int col[10];
int row[10];
int box[10];

int wx[] = { 1,1,1,2,2,2,3,3,3 };
int wy[] = { 0,0,0,3,3,3,6,6,6 };

void show() {
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            cout << board[i][j];
        }
        cout << "\n";
    }
}

int is_valid(int y, int x, int num) {
    if (row[y + 1] & (1 << (num - 1))) {
        return 0;
    }
    if (col[x + 1] & (1 << (num - 1))) {
        return 0;
    }
    if (box[wx[x] + wy[y]] & (1 << (num - 1))) {
        return 0;
    }
    return 1;
}

void check_value(int y, int x, int num) {
    row[y + 1] |= (1 << (num - 1));
    col[x + 1] |= (1 << (num - 1));
    box[wx[x] + wy[y]] |= (1 << (num - 1));
    board[y][x] = num;
}
void uncheck_value(int y, int x, int num) {
    row[y + 1] &= ~(1 << (num - 1));
    col[x + 1] &= ~(1 << (num - 1));
    box[wx[x] + wy[y]] &= ~(1 << (num - 1));
    board[y][x] = 0;
}

void solve(int y, int x) {
    if (y == 9) {
        show();
        exit(0);
    }
    if (board[y][x] != 0) {
        solve(y + (x + 1) / 9, (x + 1) % 9);
        return;
    }
    // 행, 열, 박스를 확인해 가능한 숫자 넣기
    for (int i = 1; i <= 9; i++) {
        if (is_valid(y, x, i)) {
            check_value(y, x, i);
            solve(y + (x + 1) / 9, (x + 1) % 9);
            uncheck_value(y, x, i);
        }
    }
}

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    for (int i = 0; i < 9; i++) {
        string str;
        cin >> str;
        for (int j = 0; j < 9; j++) {
            board[i][j] = str[j] - '0';
        }
    }

    // visited 처리
    for (int i = 0; i < 9; i++) {
        for (int j = 0; j < 9; j++) {
            if (board[i][j] == 0) {
                continue;
            }
            row[i + 1] = row[i + 1] | (1 << (board[i][j] - 1));
            col[j + 1] = col[j + 1] | (1 << (board[i][j] - 1));
            box[wx[j] + wy[i]] = box[wx[j] + wy[i]] | (1 << (board[i][j] - 1));
        }
    }


    solve(0,0);

}