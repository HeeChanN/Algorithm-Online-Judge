#include<bits/stdc++.h>

using namespace std;

vector<int> arr;
int n;
int m;

int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);


    for (int i = 1; i <= 10; i++) {
        cin >> n;
        vector<int> change;
        arr = change;
        for (int j = 0; j < n; j++) {
            int s;
            cin >> s;
            arr.push_back(s);
        }

        cin >> m;
        char inst;
        for (int j = 0; j < m; j++) {
            cin >> inst;
            if (inst == 'I') {
                int x, y;
                cin >> x >> y;
                vector<int> tmp;
                for (int k = 0; k < y; k++) {
                    int s;
                    cin >> s;
                    tmp.push_back(s);
                }
                arr.insert(arr.begin() + x , tmp.begin(), tmp.end());
            }
            else if (inst == 'D') {
                int x, y;
                cin >> x >> y;
                arr.erase(arr.begin() + x , arr.begin() + x + y );
            }
            else {
                int y;
                cin >> y;
                for(int i = 0;i<y;i++){
                    int s;
                    cin >> s;
                    arr.push_back(s);
                }
            }
        }
        cout << "#" << i << " ";
        for (int j = 0; j < 10; j++) {
            cout << arr[j] << " ";
        }
        cout << "\n";
    }
    return 0;
}
