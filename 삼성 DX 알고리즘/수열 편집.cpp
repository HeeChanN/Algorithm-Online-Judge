#include<bits/stdc++.h>

using namespace std;

vector<int> arr;
int n,m,l;
int t;

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin>>t;
    
    for(int i =1; i <= t;i++){
        cin>> n >> m >> l;
        vector<int> change;
        arr = change;
        
        for(int j = 0;j<n;j++){
            int s;
            cin >> s;
            arr.push_back(s);
        }
    
        char inst;
        for(int j = 0; j <m;j++){
            cin >> inst;
            int x,y;
            if (inst == 'I'){
                cin >> x >> y;
                arr.insert(arr.begin()+x, y);
            }
            else if (inst == 'D'){
                cin >> x;
                arr.erase(arr.begin()+x);
            }
            else{
                cin>> x >> y;
                arr[x] = y;
            }
        }
        cout<<"#"<<i<<" ";
        if(l >= arr.size()){
            cout<<"-1";
        }
        else{
            cout<<arr[l];
        }
        cout<<"\n";
    }
    return 0;
}
