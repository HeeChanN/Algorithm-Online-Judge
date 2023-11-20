#include<bits/stdc++.h>

using namespace std;

int n, m, k;

int main(void) {
    cin >> k >> n;
    int i = k+1;
    if (n == 1) {
        cout << "-1";
    }
    else {
        while ( (i-k) * n < i) {
            i++;
        }
        cout << i;
    }
}