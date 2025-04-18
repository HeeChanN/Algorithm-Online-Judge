#include <bits/stdc++.h>

using namespace std;

int n,s,e;
int cnt;

vector<pair<int,int>> v;
priority_queue<int, vector<int>, greater<int>> pq;


int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i =0;i<n;i++){
        cin>>s>>e;
        v.push_back({s,e});
    }
    
    sort(v.begin(), v.end());
    
    for(int i =0;i<n;i++){
        pq.push(v[i].second);
        if(pq.top() <=v[i].first){
            pq.pop();
        }
    }
    cout<<pq.size();
}
