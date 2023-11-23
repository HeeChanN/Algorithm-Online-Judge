#include<bits/stdc++.h>

using namespace std;

int n;
int dp[1001];


int main() {
    dp[1] = 1;
    dp[2] = 0;
    dp[3] = 1;
    dp[4] = 1;
    dp[5] = 1;
    cin >> n;
    for (int i = 6; i <= n; i++) {
        if (dp[i - 1] == 0 || dp[i - 3] == 0 || dp[i - 4] == 0) {
            dp[i] = 1;
        }
        else {
            dp[i] = 0;
        }
    }
    if (dp[n] == 1) {
        cout << "SK";
    }
    else {
        cout << "CY";
    }
}