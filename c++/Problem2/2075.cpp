#include<bits/stdc++.h>

using namespace std;

priority_queue<int, vector<int>, greater<int>> pq;
int redIdx,n;
int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    
    for(int i = 0; i<n;i++){
        for(int j = 0;j<n;j++){
            int num;
            cin >> num;
            if(pq.size()==n){
                if(pq.top()<num){
                    pq.pop();
                    pq.push(num);
                }
            }
            else{
                pq.push(num);
            }
        }
    }
    cout<<pq.top();
}
