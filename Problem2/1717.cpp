#include <bits/stdc++.h>

using namespace std;

int n,m;
int a,b,c;
int parent[1000004];

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
    for(int i =0;i<=n;i++){
        parent[i] = i;
    }
    for(int i = 0; i<m;i++){
        cin >> a >> b >> c;
        if (a == 0){
            int p_a = find(b);
            int p_b = find(c);
            parent[p_a] = p_b;
        }
        else{
            int p_a = find(b);
            int p_b = find(c);
            if(p_a == p_b){
                cout<<"YES"<<"\n";
            }
            else{
                cout<<"NO"<<"\n";
            }
        }
    }
}
