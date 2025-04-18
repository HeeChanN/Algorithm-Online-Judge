#include<bits/stdc++.h>

using namespace std;

string s, t;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> s;
    cin >> t;
    
    int start = t.size() -1;
    int dest = s.size() - 1;
    
    string tmp = t;
    
    while(start >  dest){
        if(tmp[start] == 'A'){
            tmp = tmp.substr(0, start);
            start--;
        }
        else if (tmp[start] == 'B'){
            tmp = tmp.substr(0, start);
            reverse(tmp.begin(), tmp.end());
            start--;
        }
    }
    if(tmp == s){
        cout<<"1";
    }
    else{
        cout<<"0";
    }
}
