#include <bits/stdc++.h>

using namespace std;

int n, m;
int a,b,c;

int ret, flag;

vector<pair<int,int>> adj[100001];
priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
int visited[100001];

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;

    for (int i = 0;i < m ; i ++){
        cin>> a>> b >> c;
        adj[a-1].push_back({c,b-1});
        adj[b-1].push_back({c,a-1});
    }
    
    pq.push({0,0});
    
    while(pq.size()){
        int here = pq.top().second;
        int d = pq.top().first;
        pq.pop();
        if (visited[here] == 1){
            continue;
        }
        flag = max (flag, d);
        ret = ret + d;
        visited[here] = 1;
        for (pair<int,int> next : adj[here]){
            if (visited[next.second] == 0){
                pq.push(next);
            }
        }
    }
    cout<<ret - flag;
}
