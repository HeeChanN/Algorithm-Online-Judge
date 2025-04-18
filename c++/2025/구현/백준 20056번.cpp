#include<bits/stdc++.h>

using namespace std;

struct A{
    int y,x,m,d,s;
};

int dy[] = {-1,-1,0,1,1,1,0,-1};
int dx[] = {0,1,1,1,0,-1,-1,-1};

int n,m,k;
queue<A> q;

int change_value(int a){
    if(a < 1){
        return a + n;
    }
    else if (a>n){
        return a % n;
    }
    return a;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>> n >> m >> k;
    for(int i =0;i<m;i++){
        A fire;
        cin >>fire.y >> fire.x >> fire.m >> fire.s >> fire.d;
        q.push(fire);
    }
    
    for(int i = 0; i<k;i++){
        vector<A> arr[54][54];
        while(q.size()){
            A fire = q.front();
            q.pop();
            int ny = fire.y + (dy[fire.d] * fire.s) % n;
            int nx = fire.x + (dx[fire.d] * fire.s) % n;
            // cout<< fire.x << " " << dx[fire.d] << " " << fire.s << " " << dx[fire.d] * fire.s << "\n";
            
            fire.y = change_value(ny);
            fire.x = change_value(nx);
            arr[fire.y][fire.x].push_back(fire);
        }
        for(int b=1;b<=n;b++){
            for(int c = 1;c<=n;c++){
                if(arr[b][c].size() == 1){
                    q.push(arr[b][c][0]);
                }
                else if (arr[b][c].size() >= 2){
                    int sum_m = arr[b][c][0].m;
                    int sum_s = arr[b][c][0].s;
                    int flag =  arr[b][c][0].d % 2;
                    for(int l = 1;l<arr[b][c].size();l++){
                        sum_m += arr[b][c][l].m;
                        sum_s += arr[b][c][l].s;
                        if(arr[b][c][l].d % 2 != flag){
                            flag = -1;
                        }
                    }
                    if(sum_m / 5 != 0){
                        A fire = arr[b][c][0];
                        fire.m = sum_m / 5;
                        fire.s = sum_s / arr[b][c].size();
                        
                        for(int l = 0;l<4;l++){
                            if(flag == -1){
                                fire.d =2*l + 1;
                            }
                            else{
                                fire.d = 2*l;
                            }
                            q.push(fire);
                        }
                    }
                }
            }
        }
    }
    
    int ret = 0;
    while(q.size()){
        A fire = q.front();
        ret += fire.m;
        q.pop();
    }
    cout << ret;
}
