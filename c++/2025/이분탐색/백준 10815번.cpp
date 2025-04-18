#include<bits/stdc++.h>

using namespace std;

int n,m,num;
vector<int> v(500004);
vector<int> visited(500004);

int main(){
    ios_base::sync_with_stdio(false);
    cin.tie(NULL);
    cout.tie(NULL);
    
    cin >> n;
    
    for(int i = 0; i<n;i++){
        cin >>v[i]; 
    }
    
    sort(v.begin(), v.end());
    
    cin >> m;
    
    for(int i = 0;i<m;i++){
        cin >> num;
        int pos = upper_bound(v.begin(), v.end(), num) - lower_bound(v.begin(), v.end(), num);
        if(pos == 1){
            visited[i] = 1;
        }
    }
    for(int i = 0; i<m;i++){
        cout << visited[i] << " ";
    }
}
