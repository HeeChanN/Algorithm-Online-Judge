#include<bits/stdc++.h>

using namespace std;

typedef pair<int,pair<int,int>> p;


int n;
int t=1;
int arr[130][130];
int dist[130][130];
int dy[] = {-1,0,1,0};
int dx[] = {0,1,0,-1};

priority_queue<p, vector<p>, greater<p>> pq;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    while(t){
        cin >> n;
        if(n == 0){
            break;
        }
        
        memset(arr,0,sizeof(arr));
        fill(&dist[0][0],&dist[129][130],987654321);
        
        for(int i = 0; i < n;i++){
            for(int j=0;j<n;j++){
                cin >> arr[i][j];
            }
        }
        dist[0][0] = arr[0][0];
        pq.push({dist[0][0],{0,0}});
        
        while(pq.size() != 0){
            int py = pq.top().second.first;
            int px = pq.top().second.second;
            int d = pq.top().first;
            pq.pop();
            if(dist[py][px] != d){
                continue;
            }
            for(int i =0; i<4;i++){
               int ny = py + dy[i];
               int nx = px + dx[i];
               if(ny >=n || nx >= n || ny < 0 || nx < 0){
                   continue;
               }
               if(dist[ny][nx] > d + arr[ny][nx]){
                dist[ny][nx] = d + arr[ny][nx];
                pq.push({dist[ny][nx],{ny,nx}});
               }
            }
            
        }
        cout<<"Problem "<<t<<": "<<dist[n-1][n-1]<<"\n";
        t++;
    }
}
