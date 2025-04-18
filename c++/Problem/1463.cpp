#include<bits/stdc++.h>

using namespace std;

int n;
int dp[1000004];

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    fill(&dp[0], &dp[1000003], 987654321);
    dp[1] = 0;
    for (int i = 2; i <= n; i++) {
        if (i % 2 == 0) {
            dp[i] = min(dp[i],dp[i / 2] + 1);
        }
        if (i % 3 == 0) {
            dp[i] = min(dp[i], dp[i / 3] + 1);
        }
        dp[i] = min(dp[i],dp[i - 1] + 1);
    }
    cout << dp[n] << "\n";
}