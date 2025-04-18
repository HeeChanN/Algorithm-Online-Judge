#include<bits/stdc++.h>
using namespace std;
int n;
double ret = 0;
double arr[10002];
double sum[10002];
int main() {
	cin >> n;
	sum[0] = 1;
	for (int i = 0; i < n; i++) {
		cin >> arr[i];
	}
	
	for (int i = 0; i < n; i++) {
		double tmp = arr[i];
		ret = max(ret, tmp);
		for (int j = i+1; j < n; j++) {
			tmp = tmp * arr[j];
			ret = max(ret, tmp);
		}
	}
	printf("%.3lf", ret);
}