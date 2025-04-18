#include<bits/stdc++.h>
using namespace std;
int n;
int arr[1001][3];
int dp[1001][3];
int first_c;
int go(int num, int color, int p) {
    if (color == p) {
        return 987654321;
    }
    if (num == n-1 ) {
        if (color == first_c || p == color) { // 마지막 집은 첫번째 집과 색이 달라야 되고 이전 집과도 색이 달라야함
            return 987654321;
        }
        return arr[num][color];
    }

    int& ret = dp[num][color];
    if (ret != 987654321) {
        return ret;
    }

    for (int i = 0; i < 3; i++) {
        ret = min(go(num + 1, i, color), ret);
       
    }
    ret += arr[num][color];
    return ret;
}
int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >>n;
    for (int i = 0; i < n; i++) {
        for (int j = 0; j < 3; j++) {
            cin >> arr[i][j];
        }
    }
    
    int cost = 987654321;
    for (int i = 0; i < 3; i++) {
        fill(&dp[0][0], &dp[1000][3], 987654321);
        first_c = i;
        cost = min(go(0, i, -1), cost);
    }
    cout << cost;
}
