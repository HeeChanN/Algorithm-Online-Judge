#include<bits/stdc++.h>

using namespace std;

struct A{
    int idx;
    int gold;
    int silver;
    int bronze;
};

int n,k,tmp;
int r[1005];
vector<A> v;
int idx;
A num;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> k;
    
    for(int i = 0;i<n;i++){
        cin >> num.idx >> num.gold >> num.silver >> num.bronze;
        if(num.idx == k){
            idx = i;
        }
        v.push_back(num);
    }
    int cnt = 1;
    for(int i = 0;i<n;i++){
        if(v[i].idx == k){
            continue;
        }
        if((v[i].gold == v[idx].gold) && (v[i].silver == v[idx].silver) && (v[i].bronze > v[idx].bronze)){
            cnt++;
        }
        else if ((v[i].gold == v[idx].gold) && (v[i].silver > v[idx].silver)){
            cnt++;
        }
        else if ((v[i].gold > v[idx].gold)){
            cnt++;
        }
    }
    
    cout << cnt;
}
