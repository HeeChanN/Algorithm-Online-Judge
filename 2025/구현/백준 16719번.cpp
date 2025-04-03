#include<bits/stdc++.h>

using namespace std;

string str;
map<char, int> mp;
vector<int> v;
int visited[104];

void go(int pos){
    priority_queue<pair<int,int>, vector<pair<int,int>>, greater<pair<int,int>>> pq;
    for(int i = pos; i<str.length();i++){
        pq.push({mp[str[i]],i});
    }
    while(pq.size()){
        int pi = pq.top().second;
        char ch = 'A' + pq.top().first;
        pq.pop();
        if(visited[pi]==1){
            continue;
        }
        visited[pi] = 1;
        for(int i =0 ; i<str.length();i++){
            if(visited[i] == 1){
                cout<<str[i];
            }
        }
        cout<<"\n";
        go(pi);
    }
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> str;
    
    for(int i = 0; i<26;i++){
        mp['A'+i] = i;
    }
    
    go(0);
}
