#include<bits/stdc++.h>

using namespace std;

int n,k;
string str;
stack<char> v;
vector<char> ret;
char start;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n >> k;
    cin>>str;
    int cnt = k;
    
    start = str[0];
    v.push(str[0]);
    for(int i = 1; i<str.length();i++){
        if(str[i] > start){
            while(v.size() != 0 && str[i] > start && k!=0){
                k--;
                v.pop();
                if(v.size() != 0){
                    start = v.top();
                }
            }
            v.push(str[i]);
            start = str[i];
        }
        else{
            v.push(str[i]);
            start = str[i];
        }
    }
    while(v.size()){
        ret.push_back(v.top());
        v.pop();
    }
    reverse(ret.begin(), ret.end());
    for(int i = 0; i<n-cnt;i++){
        cout<<ret[i];
    }
    
}
