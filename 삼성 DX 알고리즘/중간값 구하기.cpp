#include <bits/stdc++.h>

using namespace std;



int main() {
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    
    cin>> t;
    for(int i = 1; i<=t;i++){
        int n, start;
        int ret = 0;
        cin >> n >> start;
        
        priority_queue<int> maxq;
        priority_queue<int, vector<int>, greater<int>> minq;
        
        maxq.push(start);
        minq.push(start);
        
        for(int i = 0; i<n;i++){
            int a,b;
            cin >> a >> b;
            int middle = maxq.top();
            if(a > middle && b > middle){
                minq.push(a);
                minq.push(b);
                minq.pop();
                maxq.push(minq.top());
            }
            else if (a < middle && b < middle){
                maxq.push(a);
                maxq.push(b);
                maxq.pop();
                minq.push(maxq.top());
            }
            else if (a < middle && b > middle){
                maxq.push(a);
                minq.push(b);
            }
            else if (a > middle && b < middle){
                maxq.push(b);
                minq.push(a);
            }
            int tmp = maxq.top();
            ret = (ret + tmp) % 20171109;
            
        }
        cout<<"#"<<i <<" "<<ret<<"\n";
    }
    
    return 0;
}
