#include <bits/stdc++.h>

using namespace std;

int n;
string str;

int go(int l, int r){
    while(l<r){
        if(str[l] != str[r]){
            return 0;
        }
        l++;
        r--;
    }
    return 1;
}

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    while(n--){
        cin>>str;
        
        int l = 0;
        int r = str.size()-1;
        int cnt = 0;
        int flag = 1;
        while(l<r){
            if(str[l] == str[r]){
                l++;
                r--;
            }
            else{
                cnt = 1;
                flag = go(l+1, r) | go(l, r-1);
                break;
            }
        }
        if(cnt == 0 && flag == 1){
        cout<< "0\n";
        }
        else if (cnt == 1 && flag ==1){
            cout<<"1\n";
        }
        else{
            cout << "2\n";
        }
    }
    
}
