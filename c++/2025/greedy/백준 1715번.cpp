#include <bits/stdc++.h>

using namespace std;

int n;
priority_queue<int, vector<int>, greater<int>> pq;
int ret;
int a,b;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    int num = 0;
    for(int i = 0; i< n; i++){
        cin >> num;
        pq.push(num);
    }
    
    while(pq.size()>1){
        a = pq.top();
        pq.pop();
        b = pq.top();
        pq.pop();
        
        pq.push(a+b);
        ret = ret + a+b;
    }
    cout<<ret;
}
