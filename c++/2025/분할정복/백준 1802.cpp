#include <bits/stdc++.h>

using namespace std;

int t;
string str;

bool check(int s, int e){
    if(s == e){
        return true;
    }
    int l = s;
    int r = e;
    while(l<r){
        if(str[l++]==str[r--]){
            return false;
        }
    }
    return check(s,r-1);
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    cin >> t;
    while(t--){
        cin >> str;

        bool tmp = check(0,str.length()-1);
        
        if(tmp == 1){
            cout<<"YES\n";
        }
        else{
            cout<<"NO\n";
        }
    }
}
