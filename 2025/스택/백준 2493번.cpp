#include<bits/stdc++.h>

using namespace std;

int n;

priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;

vector<int> arr;
int num;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);

    cin >> n;
    arr.push_back(0);
    for(int i = 1 ;i<=n;i++){
        cin>> num;
        arr.push_back(num);
    }
    
    pq.push({arr[n],n});
    
    for(int i = n-1;i>=1;i--){
        pair<int,int> t = pq.top();
        int h = t.first;
        int idx = t.second;
        
        if(h >arr[i]){
            pq.push({arr[i],i});
        }
        else if (h < arr[i]){
            arr[idx] = i;
            pq.pop();
            while(pq.size()){
                t = pq.top();
                if(t.first > arr[i]){
                    pq.push({arr[i],i});
                    break;
                }
                else{
                    arr[t.second] = i;
                    pq.pop();
                }
            }
            if(pq.size() == 0){
                pq.push({arr[i],i});
            }
        }
    }
    
    while(pq.size()){
        pair<int,int> t = pq.top();
        arr[t.second] = 0;
        pq.pop();
    }
    for(int i = 1;i<=n;i++){
        cout<<arr[i]<<" ";
    }
}
