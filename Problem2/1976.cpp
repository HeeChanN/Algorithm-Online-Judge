#include <bits/stdc++.h>

using namespace std;

int n,m;
int num;
int parent[204];
int flag = 0;

int find(int num){
    if(parent[num] == num){
        return num;
    }
    return parent[num] = find(parent[num]);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> m;
    for(int i =1;i<=n;i++){
        parent[i] = i;
    }
    for(int i = 1; i<=n;i++){
        
        for(int j = 1;j<=n;j++){
            cin >> num;
            if(num == 1){
                int p_a = find(i);
                int p_b = find(j);
                parent[p_a] = p_b;
            }
        }
    }
    int prev=0;
    for(int i =0;i<m;i++){
        cin >> num;
        int p = find(num);
        if(prev == 0){
            prev = p;
        }
        else if(prev != p){
            flag = 1;
            break;
        }
    }
    if(flag == 0){
        cout<<"YES";
    }
    else{
        cout<<"NO";
    }
}
