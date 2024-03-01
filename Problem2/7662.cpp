#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;

unordered_map <int,int> mp;

int n;
char com;
int num;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    int t;
    cin >> t;
    while(t--){
        priority_queue<int, vector<int>, greater<int>> pq;
        priority_queue<int, vector<int>, less<int>> pq2;
        cin >> n;
        mp.clear();
        
        for(int i = 0; i<n;i++){
            cin >> com >> num;
            if(com == 'I'){
                pq.push(num);
                pq2.push(num);
                mp[num]++;
            }
            else{
                if(num == -1){
                    if(pq.size()){
                        mp[pq.top()]--;
                        pq.pop();
                    }
                }
                else{
                    if(pq2.size()){
                        mp[pq2.top()]--;
                        pq2.pop();
                    }
                }
                while(pq.size() && mp[pq.top()] == 0){
                    pq.pop();
                }
                while(pq2.size() && mp[pq2.top()] == 0){
                    pq2.pop();
                }
            }
            
        }
        while(pq.size() && mp[pq.top()] == 0){
                    pq.pop();
                }
                while(pq2.size() && mp[pq2.top()] == 0){
                    pq2.pop();
                }
        if(pq.size() == 0 || pq2.size() == 0){
            cout<<"EMPTY\n";
        }
        else{
            cout<<pq2.top() << " " << pq.top()<<'\n';
        }
    }
}
