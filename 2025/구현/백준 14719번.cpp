#include<bits/stdc++.h>

using namespace std;

int h,w,num;
int max_h;
vector<int> v;
int visited[504];
int ret;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> h >> w;

    for(int i = 0; i<w;i++){
        cin>>num;
        v.push_back(num);
        max_h = max(max_h, num);
    
    }
    
    for(int i =max_h;i>=1;i--){
        vector<int> hop;
        for(int j = 0;j<w;j++){
            if(v[j] == i){
                visited[j] = 1;
            }
            if(visited[j] == 1){
                hop.push_back(j);
            }
        }
        if(hop.size() == 1){
            continue;
        }
        for(int j = 0; j<hop.size()-1;j++){
            ret = ret + hop[j+1] - hop[j] -1;
        }
    }
    cout<<ret;
}
