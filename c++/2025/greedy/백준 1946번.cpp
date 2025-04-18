#include<bits/stdc++.h>

using namespace std;

int t;
int n;
priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
int a,b;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    while(t--){
        cin >> n;
        for(int i = 0; i<n;i++){
            cin >> a >> b;
            pq.push({a,b});
        }
        pair<int,int> high = pq.top();
        int cnt = 1;
        pq.pop();
        while(pq.size()){
            pair<int,int> next_value = pq.top();
            pq.pop();
            if(next_value.first < high.first || next_value.second < high.second){
                cnt++;
                high = next_value;
            }
        }
        cout << cnt << "\n";
    }
}
