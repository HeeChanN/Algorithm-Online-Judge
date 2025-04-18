#include <bits/stdc++.h>
using namespace std;

static const int MAX_ROW = 1002;
static const int MAX_DAY = 366;

int cal[MAX_ROW][MAX_DAY];
int height[366];

vector<pair<int,int>> v;

int n;

int find_row(int l, int r) {
    for(int row=0; row<MAX_ROW; row++){
        bool canUse = true;
        for(int d=l; d<=r; d++){
            if(cal[row][d] == 1){
                canUse = false;
                break;
            }
        }
        if(canUse) {
            return row; 
        }
    }
    return MAX_ROW-1;
}


void fill_cal(int l, int r, int row) {
    for(int d=l; d<=r; d++){
        cal[row][d] = 1;
    }
}


bool comp(pair<int,int> a, pair<int,int> b){
    if(a.first == b.first){
        return (a.second > b.second);
    }
    return (a.first < b.first);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);

    cin >> n;
    v.resize(n);

    for(int i=0; i<n; i++){
        cin >> v[i].first >> v[i].second;
    }

    sort(v.begin(), v.end(), comp);

    for(auto &it : v) {
        int s = it.first; 
        int e = it.second;
        int row = find_row(s, e);
        fill_cal(s, e, row);
    }

    for(int day=1; day<=365; day++){
        for(int row=MAX_ROW-1; row>=0; row--){
            if(cal[row][day] == 1){
                height[day] = row + 1;
                break;
            }
        }
    }


    int answer = 0;
    int day = 1;
    while(day <= 365){

        if(height[day] == 0) {
            day++;
            continue;
        }

        int start = day;
        int maxH = height[day];

        while(day+1 <= 365 && height[day+1] != 0){
            day++;
            maxH = max(maxH, height[day]);
        }
        int end = day;

        answer += (end - start + 1) * maxH;
        day++;
    }

    cout << answer << "\n";
    return 0;
}
