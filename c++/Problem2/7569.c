#include<bits/stdc++.h>

using namespace std;

int arr[101][101][101];

int h,n,m;

struct A{
    int z;
    int y;
    int x;
};

queue<A> q;

int dz[] = {0,0,0,0,1,-1};
int dy[]={-1,0,1,0,0,0};
int dx[] = {0,1,0,-1,0,0};

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> m >> n >> h;
    
    int tmp =0;
    for(int i = 0; i < h;i++){
        for(int j = 0 ; j<n;j++){
            for(int k = 0; k<m;k++){
                cin>>arr[i][j][k];
                if(arr[i][j][k] ==1){
                    q.push({i,j,k});
                }
                else if (arr[i][j][k] == 0){
                    tmp ++;
                }
            }
        }
    }
    if(tmp == 0){
        cout<<"0";
        return 0;
    }
    
    
    int cnt = 0;
    int flag = q.size();
    while(q.size()){
        int z = q.front().z;
        int y = q.front().y;
        int x = q.front().x;
        q.pop();
        flag--;
        for(int i = 0; i<6;i++){
            int nz = z + dz[i];
            int ny = y + dy[i];
            int nx = x + dx[i];
            if(nz <0 || ny < 0 || nx < 0 || nz >= h || ny >=n || nx>=m || arr[nz][ny][nx] != 0){
                continue;
            }
            arr[nz][ny][nx] = 1;
            q.push({nz,ny,nx});
            tmp--;
        }
        
        if(flag==0){
            flag = q.size();
            cnt++;
        }
    }
    
    if(tmp == 0){
        cout<<cnt-1;
    }
    else{
        cout<<"-1";
    }
    
    return 0;
}
