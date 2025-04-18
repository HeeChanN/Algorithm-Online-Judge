#include <bits/stdc++.h>

using namespace std;


priority_queue<int, vector<int>, less<int>> pq;
vector<pair<int,int>> v;
int town, lim;
int cnt;
int a,b;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    int n;
    cin >> n;
    
    for(int i = 0 ;i<n;i++){
        cin >> a >> b;
        v.push_back({a,b});
    }
    cin >> town >> lim;
    
    
    sort(v.begin(), v.end());
    
    for(int i = 0; i<v.size();i++){
        if(v[i].first <= lim){
            pq.push(v[i].second);
        }
        else{
            while(pq.size() && v[i].first > lim){
                int gas = pq.top();
                lim += gas;
                pq.pop();
                cnt++;
            }
            if(v[i].first <= lim){
                pq.push(v[i].second);
            }
            else{
                break;
            }
            
        }
    }
    while(pq.size() && town > lim){
        int gas = pq.top();
        lim += gas;
        pq.pop();
        cnt++;
    }
    if(lim < town){
        cout<<-1;
    }
    else{
        cout << cnt;
    }
}
