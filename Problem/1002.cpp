#include <iostream>
using namespace std;

int main() {
	int T;
	int x1, y1, r1, x2, y2, r2;
	int d, dist1, dist2;
	cin >> T;

	while(T--) {
		cin >> x1 >> y1 >> r1 >> x2 >> y2 >> r2;
		d = (x1 - x2) * (x1 - x2) + (y1 - y2) * (y1 - y2);
		dist1 = (r1 - r2) * (r1 - r2);
		dist2 = (r1 + r2) * (r1 + r2);

		if (d == 0) {
			if (dist1 == 0)
				cout << "-1" << '\n';
			else
				cout << "0" << '\n';
		}
		else if (d == dist1 || d == dist2)
			cout << "1" << '\n';
		else if (dist1 < d && d < dist2)
			cout << "2" << '\n';
		else
			cout << "0" << '\n';
	}
}