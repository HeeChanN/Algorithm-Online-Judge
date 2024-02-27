#include<bits/stdc++.h>

using namespace std;

int n,t;
string str;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> t;
    while(t--){
        vector<int> v;
        cin >> n;
        cin >> str;
        for(int i = 0; i<n;i++){
            v.push_back(str[i]-'0');
        }
        cin >> str;
        
        if(v[0] == 1){
            str[0] = '*';
            str[1] = 'x';
        }
        else if (v[0] == 2){
            str[0] = '*';
            str[1] = '*';
        }
        else{
            str[0] = 'x';
            str[1] = 'x';
        }
        
        for(int i = 1; i<v.size();i++){
            int j = i -1;
            int cnt = 0;
            while(j < i + 2){
                if(cnt == v[i]){
                    str[j] = 'x';
                }
                if(str[j] == '#'){
                    str[j] = '*';
                    cnt++;
                }
                else if( str[j] == '*'){
                    cnt++;
                }
                j++;
            }
        }
        int ret = 0;
        for(int i = 0; i<str.size();i++){
            if(str[i] == '*'){
                ret++;
            }
        }
        cout<<ret<<'\n';
        
    }
}
