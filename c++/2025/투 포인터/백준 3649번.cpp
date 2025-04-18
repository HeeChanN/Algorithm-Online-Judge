#include<bits/stdc++.h>

using namespace std;

#define nano 10000000

int x, n,num;
vector<int> v(1000004);

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    while(cin>>x){
        x = x * nano;
        cin >> n;
        for(int i = 0;i<n;i++){
            cin >> v[i];
        }
        sort(v.begin(), v.begin() + n);
        int l = 0;
        int r = n-1;
        int flag = 0;
        while(l<r){
             num = v[l] + v[r];
             if (num == x){
                 cout << "yes " << v[l] << " " << v[r] <<"\n";
                 flag = 1;
                 break;
             }
             else if (num > x){
                 r--;
             }
             else{
                 l++;
             }
        }
        if(flag == 0){
            cout <<"danger\n";
        }
    }
}
