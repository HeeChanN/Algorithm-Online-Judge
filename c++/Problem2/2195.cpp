#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;

map<string, int> mp;
string s;
string t;
int ret;

int main(){
    cin >> s;
    cin >> t;
    
    
    int i = 0;
    while(i < t.size()){
        int len = 1;
        for(int j = 1;j<=s.size();j++){
            string tmp = t.substr(i,j);
            if(s.find(tmp) != string :: npos){
                len = j;
            }
        }
        ret++;
        i += len;
    }
    cout<<ret;
}
