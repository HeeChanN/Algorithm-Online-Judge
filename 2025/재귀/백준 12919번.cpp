#include<bits/stdc++.h>
#include<unordered_map>

using namespace std;

string str1;
string str2;
string rstr2;
int ret;


int go(string str1){
    if(ret == 1){
        return 0;
    }
    if(str1.length() == str2.length()){
        if(str1 == str2){
            ret = 1;
        }
        return 0;
    }
    size_t pos = str2.find(str1);
    size_t pos2 = rstr2.find(str1);
    if((pos == string::npos) && (pos2 == string::npos)){
        return 0;
    }
    
    string add_A = str1 + "A";
    string add_B = str1 + "B";
    reverse(add_B.begin(), add_B.end());
    
    go(add_A);
    go(add_B);
    
    return 0;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> str1;
    cin >> str2;
    
    rstr2 = str2;
    reverse(rstr2.begin(),rstr2.end());
    
    go(str1);
    cout<<ret;
}
