#include<bits/stdc++.h>

using namespace std;

vector<pair<int,int>> adj[52];
priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
int dist[52];


int solution(int N, vector<vector<int>> road, int K) {
    int answer = 0;
    
    for(int i = 0; i < road.size(); i++){
        adj[road[i][0]].push_back({road[i][2], road[i][1]});
        adj[road[i][1]].push_back({road[i][2], road[i][0]});
    }
    
    pq.push({0,1});
    
    fill(&dist[0], &dist[51], 987654321);
    dist[1] = 0;
    
    while(pq.size()){
        int d = pq.top().first;
        int p = pq.top().second;
        pq.pop();
        
        if(d != dist[p]){
            continue;
        }
        
        for(pair<int,int> next : adj[p]){
            int next_d = next.first;
            int next_p = next.second;
            
            if(dist[next_p] > dist[p] + next_d){
                dist[next_p] = dist[p] + next_d;
                pq.push({dist[next_p], next_p});
            }
        }
    }
    for(int i = 1; i<= N;i++){
        if(dist[i] <=K){
            answer++;
        }
    }
    
    
    return answer;
}
