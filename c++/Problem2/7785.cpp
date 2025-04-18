#include <bits/stdc++.h>
#include <unordered_set>

using namespace std;

unordered_set<string> people;
int n;
string str1,str2;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>n;
    for(int i = 0; i<n; i++){
        cin>>str1>>str2;
        if(str2 == "enter"){
            people.insert(str1);
        }
        else{
            people.erase(str1);
        }
    }
    
    vector<string> ret(people.begin(),people.end());
    sort(ret.begin(),ret.end(),greater<string>());
    
    for(string person: ret){
        cout<< person << '\n';
    }
    
}
